package kr.co.cinema.payment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.HomeService;
import kr.co.cinema.dto.Analysis;
import kr.co.cinema.dto.BranchDayCount;
import kr.co.cinema.dto.DiscountInfo;
import kr.co.cinema.dto.Mileage;
import kr.co.cinema.dto.Payment;
import kr.co.cinema.dto.ScreenCost;
import kr.co.cinema.dto.Seat;

@Service
public class PaymentService {
	private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
	
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private HomeService homeService;
	
	// 결제 정보 등록
	final double MILEAGE_RATE=0.03;		// 마일리지 적립율 변수 선언
	
	public int insertPayment(Payment payment){
		logger.debug("		insertPayment() 진입 payment : "+payment);
		
		int resultPayment = 0;			// 결제 등록 성공 여부
		int resultMileage = 0;			// 마일리지 등록 성공 여부
		int resultReturn = 0;			// 컨트롤러에 반환할 최종 결과 성공 여부
		int resultMemUpdate = 0;		// 회원 마일리지 업데이트 성공 여부
		
		// 결제 등록
		String pmtCode = homeService.madeCode(payment);						// 결제코드 생성
		System.out.println("pmtCode : "+pmtCode);
		payment.setPmtCode(pmtCode);
		resultPayment = paymentDao.insertPayment(payment);
		
		// 마일리지 등록
		String memId = payment.getMemId();									// payment에서 회원 아이디 가져오기
		String nmemCode= payment.getNmemCode();								// payment에서 비회원 코드 가져오기
		int milUse = payment.getUseMileage();
		int milSave = (int) ((payment.getPmtPrice())*MILEAGE_RATE);			// 0.3% 적립
		if(nmemCode == "회원"){
			System.out.println("마일리지등록 : 회원 진입");
			String milCode = homeService.madeCode("mileage");				// 마일리지 코드 생성
			System.out.println("milCode : "+ milCode);
			Mileage mileage = new Mileage();								// 마일리지 객체 생성
			mileage.setMilCode(milCode);									// 마일리지 객체에 데이터 셋팅
			mileage.setPmtCode(pmtCode);
			mileage.setMilSave(milSave);
			mileage.setMilUse(milUse);
			mileage.setMemId(memId);
			
			logger.debug("마일리지 등록 최종 mileage : "+mileage);
			resultMileage = paymentDao.insertMileage(mileage);				// 마일리지 테이블에 등록
			resultMemUpdate = paymentDao.updateMemMileage(memId);			// 회원 마일리지 정보 업데이트
		}
		
		// 좌석 다:다 등록
		Map<String, String> map = new HashMap<String, String>();
		for(int i =0; i<payment.getSeatCode().length;i++){
			if(payment.getSeatCode()[i]==""){
				break;
			}else{
				String seatsCode = homeService.madeCode("seats");
				map.put("seatsCode", seatsCode);
				map.put("pmtCode",pmtCode);
				map.put("seatCode", payment.getSeatCode()[i]);
				paymentDao.insertSeats(map);	
			}
			
		}
		// 좌석 업데이트(able->use)
		Map<String, String> seatMap = new HashMap<String, String>();
		for(int i=0; i<payment.getSeatCode().length;i++){
			if(payment.getSeatCode()[i]==""){
				break;
			}else{
				seatMap.put("seatUseStatus", "use");
				seatMap.put("seatCode", payment.getSeatCode()[i]);
				paymentDao.updateSeat(seatMap);
			}
		}
		

		
		
		if(memId != "비회원"){			// 회원 결제 시
			if(resultPayment == 1 && resultMileage == 1){	// 결제 등록 & 마일리지 등록이 성공여부 판단
				resultReturn = 1;
			}else{
				resultReturn = 0;
			}
		}else{								// 비회원 결제 시
			if(resultPayment == 1){			// 결제 등록 성공여부 판단
				resultReturn = 1;
			}else{
				resultReturn = 0;
			}
		}
		
		return resultReturn;
	}
	
	
	
	
	// 비회원 코드 가져오기
	public String searchOneNmemCode(String phone){
		logger.debug("		searchOneNmemCode() 진입 phone : "+phone);
		return paymentDao.selectOneNmemCode(phone);
	}
	
	// 좌석 정보 가져오기
	public String searchOneSeatInfo(String seatCode){
		logger.debug("		searchOneSeatInfo() 진입 seatCode : "+seatCode);
		String returnSeatInfo = null;
		Seat seatInfo = paymentDao.selectOneSeatInfo(seatCode);
		if(seatInfo == null){
			returnSeatInfo=null;
		}else{
			String seatRow = seatInfo.getSeatRow();
			int seatCol = seatInfo.getSeatCol();
			returnSeatInfo = seatRow+seatCol;
		}
		return returnSeatInfo;
	}
	
	// 회원정보 (마일리지, 생일) 정보 가져오기
	public Map<String, Object> searchOneMemInfo(String memId){
		logger.debug("		searchOneMemInfo() 진입 memId : "+memId);
		return paymentDao.selectOneMemInfo(memId);
	}
	
	// 할인 정보(전체) 가져오기
	public List<DiscountInfo> searchListDiscountInfo(){
		logger.debug(			"searchListDiscountInfo() 진입");
		return paymentDao.selectListDiscountInfo();
	}
	
	// 할인 정보(사람) 가져오기
		public List<DiscountInfo> searchListDcPersonInfo(){
			logger.debug(				"searchListDcPersonInfo() 진입");
			
			List<DiscountInfo> returnDiscountInfo = new ArrayList<DiscountInfo>();		// 반환할 새로운 리스트 생성
			List<DiscountInfo> discountInfo = paymentDao.selectListDiscountInfo();		// DB에서 할인정보(전체) 가져오기
			for(int i=0;i<discountInfo.size();i++){
				String separation = discountInfo.get(i).getDcinfSeparation();			// 리스트 인덱스 별 separation 값 가져오기
				if(separation.equals("사람")){
					returnDiscountInfo.add(discountInfo.get(i));						// separation 값이 "사람"이면 반환 리스트에 DB정보 셋팅
				}
			}
			logger.debug(		"returnDiscountInfo : "+returnDiscountInfo.toString());
			return returnDiscountInfo;
		}
	
	// 상영 단가 가져오기
	public List<ScreenCost> searchListScreenCost(){
		logger.debug(		"searchListScreenCost() 진입");
		return paymentDao.selectListScreenCost();
	}
	
	// 결제시 영화 정보 가져오기
	public Map<String, Object> searchBookingInfo(String scsCode){
		logger.debug(		"searchBookingInfo() 진입");
		
		int digitalCost=0;			// 디지털 단가 변수 초기화
		int ThreeDCost=0;			// 3D 단가 변수 초기화
		int imaxCost=0;				// IMAX 단가 변수 초기화
		int morningCost=0;			// 조조 할인 변수 초기화
		int nightCost=0;			// 심야 할인 변수 초기화
		String resultCost="";		// 반환할 최종가격 변수 초기화
		
		
		// DB에서 가져온 상영 단가 변수에 대입하기
		for(int i=0; i<searchListScreenCost().size(); i++ ){
			ScreenCost screenCost = searchListScreenCost().get(i);					// 상영 단가 가져오기
			switch (screenCost.getSccoScreen()){
				case "디지털" : 														// 상영 단가 이름이 "디지털"이면
					digitalCost = screenCost.getSccoPrice();						// 변수 digitalCost에 DB에서 가져온 값(가격) 대입
					break;
				case "3D" : 														// 상영 단가 이름이 "3D"이면
					ThreeDCost = screenCost.getSccoPrice();							// 변수 ThreeDCost 에 DB에서 가져온 값(가격) 대입
					break;
				case "IMAX" :														// 상영 단가 이름이 "IMAX"이면
					imaxCost = screenCost.getSccoPrice();							// 변수 imaxCost 에 DB에서 가져온 값(가격) 대입
					break;
				default :
					break;
			}
			
		// DB에서 가져온 할인 정보 변수에 대입하기
		}for(int i=0; i<searchListDiscountInfo().size();i++){
			DiscountInfo discountInfo = searchListDiscountInfo().get(i);			// 할인 정보 가져오기
			switch (discountInfo.getDcinfInfo()){
				case "조조" :															// 할인 정보 이름이 "조조"이면
					morningCost=discountInfo.getDcinfPrice();						// 변수 morningCost에 할인 가격 대입
					break;
				case "심야" :															// 할인 정보 이름이 "심야"이면
					nightCost=discountInfo.getDcinfPrice();							// 변수 nightCost에 할인 가격 대입
					break;
				default :
					break;
			}
		}
		
		// 예매 정보로 가져온 상영정보에 해당하는 가격정보 대입하기
		Map<String, Object> bookingInfo = paymentDao.selectBookingInfo(scsCode);		// 상영 정보 가져오기
		switch((bookingInfo.get("scsScreen")).toString()){
			case "디지털" :
				switch((bookingInfo.get("scsTimeDiscount")).toString()){
					case "일반" :													// 상영 단가가 "디지털"이고, 할인 정보가 "일반"일때
						resultCost = Integer.toString(digitalCost);				// 결과 값 : 디지털 단가
						bookingInfo.put("finalCost", resultCost);
						break;
					case "조조" : 												// 상영 단가가 "디지털"이고, 할인 정보가 "조조"일때
						resultCost = Integer.toString(digitalCost-morningCost);	// 결과 값 : (디지털 단가)-(조조 할인가격)
						bookingInfo.put("finalCost", resultCost);
						break;
					case "심야" : 												// 상영 단가가 "디지털"이고, 할인 정보가 "심야"일때
						resultCost = Integer.toString(digitalCost-nightCost);	// 결과 값 : (디지털 단가)-(심야 할인가격)
						bookingInfo.put("finalCost", resultCost);
						break;
				}
				break;
			case "3D" :
				switch((bookingInfo.get("scsTimeDiscount")).toString()){
					case "일반" :													// 상영 단가가 "3D"이고, 할인 정보가 "일반"일때
						resultCost = Integer.toString(ThreeDCost);								// 결과 값 : 3D 단가
						bookingInfo.put("finalCost", resultCost);
						break;
					case "조조" : 												// 상영 단가가 "3D"이고, 할인 정보가 "조조"일때
						resultCost = Integer.toString(ThreeDCost-morningCost);					// 결과 값 : (3D 단가)-(조조 할인가격)
						bookingInfo.put("finalCost", resultCost);
						break;
					case "심야" : 												// 상영 단가가 "3D"이고, 할인 정보가 "심야"일때
						resultCost = Integer.toString(ThreeDCost-nightCost);						// 결과 값 : (3D 단가)-(심야 할인가격)
						bookingInfo.put("finalCost", resultCost);
						break;
			}
				break;
			case "IMAX" :
				switch((bookingInfo.get("scsTimeDiscount")).toString()){
					case "일반" : 												// 상영 단가가 "IMAX"이고, 할인 정보가 "일반"일때
						resultCost = Integer.toString(imaxCost);									// 결과 값 : IMAX 단가
						bookingInfo.put("finalCost", resultCost);
						break;
					case "조조" :  												// 상영 단가가 "IMAX"이고, 할인 정보가 "조조"일때
						resultCost = Integer.toString(imaxCost-morningCost);						// 결과 값 : (IMAX 단가)-(조조 할인가격)
						bookingInfo.put("finalCost", resultCost);
						break;
					case "심야" : 												// 상영 단가가 "IMAX"이고, 할인 정보가 "심야"일때
						resultCost = Integer.toString(imaxCost-nightCost);						// 결과 값 : (IMAX 단가)-(심야 할인가격)
						bookingInfo.put("finalCost", resultCost);
						break;
			}
				break;
		}
		logger.debug("		bookingInfo : "+bookingInfo);
		return bookingInfo;
	}
	
	/***************분석/통계 시작********************/
	// ANALYSIS 업데이트
	public int updateAnalysis(Payment payment){
		logger.debug(		"updateAnalysis() 진입");
		
		Analysis analysis = new Analysis();			// DB로 가져갈 정보를 담을 Analysis 객체 생성
		
		int getMovCode = paymentDao.selectOneMovCode(payment.getScsCode());		// 예매 정보에서 영화코드 가져오기
		logger.debug("updateAnalysis bookingInfo : "+getMovCode);

		analysis.setMovCode(getMovCode);			// Analysis에 영화 코드 셋팅
		
		int pmtPrice = payment.getPmtPrice();		// 결제 금액 가져오기
		int ticketNum = payment.getPmtTicketNum();	// 티켓 수 가져오기
		String memId = payment.getMemId();			// 회원 아이디 가져오기
		String nmemCode = payment.getNmemCode();	// 비회원 코드 가져오기
		
		String gender = "";		// 성별 변수 초기화
		String birth="";		// 생년월일 변수 초기화
		
		if(nmemCode == "회원"){						// 회원 일때
			
			Map<String, Object> memberMap = paymentDao.selectOneMemInfo(memId);		// 회원 아이디로 회원정보 가져오기
			logger.debug("	updateAnalysis memberMap : "+memberMap);
			
			gender =  (String) memberMap.get("memGender");							// 회원 정보 : 회원 성별
			Date memBirth = (Date) memberMap.get("memBirth");						// 회원 정보 : 생년월일
			birth = memBirth.toString();											// 생년월일 String으로 변환
			System.out.println("회원 birth : "+birth);
			
			// 성별,누적매출,예매누적 정보 담기
			switch (gender){
			case "남" :
				analysis.setAnlManTicketCount(ticketNum);
				analysis.setAnlTotalTicketCount(ticketNum);			// 전체 예매 수
				analysis.setAnlAcSales(pmtPrice);					// 누적 매출액
				break;
			case "여" :
				analysis.setAnlWomanTicketCount(ticketNum);
				analysis.setAnlTotalTicketCount(ticketNum);			// 전체 예매 수
				analysis.setAnlAcSales(pmtPrice);					// 누적 매출액
				break;
			default :
				break;
			
			}
			
		}else{										// 비회원 일때	
			Map<String, Object> nmemInfo = paymentDao.selectOneNmemInfo(nmemCode);	// 비회원 코드로 비회원 정보 가져오기
			
			logger.debug("	updateAnalysis nmemInfo : "+nmemInfo);

			Date nmemBirthDate = (Date) nmemInfo.get("nmemBirth");			// 맵에 있는 nmemBirth 값 nmemBirthDate에 셋팅
			birth =nmemBirthDate.toString();								// nmemBirthDate를  String으로 변환
			System.out.println("비회원 birth : "+birth);
		}
			
			int birthYear =Integer.parseInt(birth.substring(0,4));			// 생년
			int birthMonth = Integer.parseInt(birth.substring(5,7));		// 월
			int birthDay = Integer.parseInt(birth.substring(8,10));			// 일
			
			int getAge = getAge(birthYear, birthMonth, birthDay);			// getAge 메서드(만 나이) 호출
			
			int ages = getAge/10;											// 나이/10으로 연령대 구분
			
			// 연령 정보 담기
			switch (ages){
			case (1) :
				analysis.setAnl10sTicketCount(ticketNum);			// Analysis에 10대 예매 수 셋팅
				break;
			case (2) :
				analysis.setAnl20sTicketCount(ticketNum);			// Analysis에 20대 예매 수 셋팅
				break;
			case (3) :
				analysis.setAnl30sTicketCount(ticketNum);			// Analysis에 30대 예매 수 셋팅
				break;
			case (4) :
				analysis.setAnl40sTicketCount(ticketNum);			// Analysis에 40대 예매 수 셋팅
				break;
			default :
				analysis.setAnlOver50sTicketCount(ticketNum);		// Analysis에 50대 이상 예매 수 셋팅
				break;
			}
			
			
			logger.debug("updateAnalysis db로 갈"+analysis);
		return paymentDao.updateAnalysis(analysis);
	}
	
	// 만 나이 구하기
	 public int getAge(int birthYear, int birthMonth, int birthDay)
	 {
	         Calendar current = Calendar.getInstance();
	         int currentYear  = current.get(Calendar.YEAR);
	         int currentMonth = current.get(Calendar.MONTH) + 1;
	         int currentDay   = current.get(Calendar.DAY_OF_MONTH);
	        
	         int age = currentYear - birthYear;
	         // 생일 안 지난 경우 -1
	         if (birthMonth * 100 + birthDay > currentMonth * 100 + currentDay)  
	             age--;
	        
	         return age;
	 }
	 
	 // 지점별 분석
	 public int updateBranchDayCount(Payment payment){
		 logger.debug("	updateBranchDayCount 진입 payment : "+payment);
		 
		 String scsCode = payment.getScsCode();				// payment에서 scsCode 코드 가져오기
		 int pmtTicketNum = payment.getPmtTicketNum();		// payment에서 pmtTicketNum 가져오기
		 int pmtPrice = payment.getPmtPrice();				// payment에서 pmtPrice 가져오기
		 
		 Map<String, Object> movieInfo = 
				 paymentDao.selectBookingInfo(scsCode);		// scsCode로 예매 정보 가져오기
		 int movCode = (int) movieInfo.get("movCode");		// 예매 정보에서 영화코드movCode 가져오기
		 int brcCode = (int) movieInfo.get("brcCode");		// 예매 정보에서 지점코드brcCode 가져오기
		 
		 BranchDayCount branchDayCount = new BranchDayCount();	// DB로 가져갈 branchDayCount 생성
		 branchDayCount.setMovCode(movCode);					// branchDayCount에 영화 코드 셋팅
		 branchDayCount.setBrcCode(brcCode);					// branchDayCount에 지점 코드 셋팅
		 branchDayCount.setBrcCntClientCount(pmtTicketNum);		// branchDayCount에 티켓 수 셋팅
		 branchDayCount.setBrcCntSaleTotal(pmtPrice);			// branchDayCount에 매출 액 셋팅
		 
		 Date date = new Date();						// 현재 날짜 생성
		 SimpleDateFormat sdf = 
				 new SimpleDateFormat("yyyy-MM-dd");	// 형식 변환
		 String today = sdf.format(date);
		 
		 branchDayCount.setBrcCntDate(today);			// branchDayCount에 현재 날짜 셋팅
		 
		 logger.debug("	updateBranchDayCount branchDayCount : "+branchDayCount);
		 return paymentDao.updateBrcDayCount(branchDayCount);
	 }
	 
	 
	 //**************************************
	 // 결제 취소
	 public int updateCancelPayment(String pmtCode){
		 logger.debug("	updateCancelPayment 진입 pmtCode : "+pmtCode);
		 
		 Map<String, Object> payment = paymentDao.selectOnePaymentInfo(pmtCode);
		 String memId = (String) payment.get("memId");	// 결제 한 회원 아이디
		 int pmtPrice = (int) payment.get("pmtPrice");	// 결제 한 금액
		
		 // 마일리지 내역 등록(취소)
		 Mileage mileage = new Mileage();						// 마일리지 객체 생성
		 mileage.setMemId(memId);								// 마일리지 객체에 memId 셋팅
		 mileage.setMilCode(homeService.madeCode("mileage"));	// 마일리지 코드 생성 & 셋팅
		 int saveMileage = (int) -(pmtPrice*MILEAGE_RATE);		// 결제 금액에 대한 (-)마일리지
		 mileage.setMilSave(saveMileage);						// 마일리지 셋팅
		 mileage.setMilUse(0);									// 사용 마일리지 0으로 셋팅
		 mileage.setPmtCode(pmtCode);							// 결제 코드 셋팅
		 logger.debug("	updateCancelPayment mileage : "+mileage);
		 paymentDao.insertMileage(mileage);						// 취소 : 회원 마일리지 내역 추가
	 
		 // 회원 마일리지 업데이트
		 logger.debug("	updateCancelPayment memId : "+memId);
		 paymentDao.updateMemMileage(memId);					// 회원 마일리지 정보 업데이트
		 
		 // 좌석 정보 업데이트
		 List<String> seatCode = paymentDao.selectSeatInfo(pmtCode);	// 결제 한 좌석정보 가져오기
		 logger.debug("	updateCancelPayment seatInfo : "+seatCode);
		 Map<String, String> seatMap = new HashMap<String, String>();	// mapper로 보낼 map 생성
		 
		 for(int i=0;i<seatCode.size();i++){							// 가져온 좌석정보 크기만큼 for문 실행
			 seatMap.put("seatUseStatus", "able");
			 seatMap.put("seatCode", seatCode.get(i));
			 paymentDao.insertSeats(seatMap);
		 }
		 
		 return 0;
	 }
}

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
	
	
	// ****************결제 등록************
	
	final double MILEAGE_RATE=0.03;		// 마일리지 적립율 변수 선언
	
	// 결제 등록(MAIN)
	public int insertPayment(Payment payment){
		logger.debug("		insertPayment() 진입 payment : "+payment);
	
		String pmtCode = homeService.madeCode(payment);						// 결제코드 생성
		payment.setPmtCode(pmtCode);
		
		String memId = payment.getMemId();									// payment에서 회원 아이디 가져오기
		String nmemCode= payment.getNmemCode();								// payment에서 비회원 코드 가져오기
		String[] seatCode=payment.getSeatCode();							// payment에서 좌석 코드 가져오기
		int pmtPrice = payment.getPmtPrice();								// payment에서 결제 금액 가져오기
		int pmtTicketNum = payment.getPmtTicketNum();						// payment에서 티켓 수 가져오기
		String scsCode = payment.getScsCode();								// payment에서 scsCode(상영일정코드)가져오기
		int milUse = payment.getUseMileage();
		int milSave = (int) ((payment.getPmtPrice())*MILEAGE_RATE);			// 0.03% 적립
		
		// 결제 정보 등록
		insertPaymentInfo(payment);
		
		// 마일리지 등록
		insertMileage(memId, nmemCode, pmtCode, milSave, milUse);
		
		// 마일리지 업데이트
		updateMileage(memId);
		
		// 좌석 다:다 등록
		insertSeats(seatCode, pmtCode);
		
		// 좌석 업데이트
		updateSeatInfo(seatCode);
		
		// analysis 업데이트
		updateAnalysis(memId, nmemCode, pmtTicketNum, pmtPrice, scsCode);
		
		// 지점별 예매.매출 업데이트
		updateBranchDayCount(scsCode, pmtTicketNum, pmtPrice);
		
		return 0;
	}
	
	// 결제 정보 등록
	public int insertPaymentInfo(Payment payment){
		logger.debug("		insertPaymentInfo() 진입 payment : "+payment);

		return paymentDao.insertPayment(payment);	
	}
	
	// 마일리지 등록
	public int insertMileage(String memId, String nmemCode, String pmtCode, int milSave ,int milUse){
		logger.debug("		insertMileage() 진입 memId : "+memId+" nmemCode : "+nmemCode+
				" pmtCode : "+pmtCode+" milSave: "+milSave+" milUse : "+milUse);
		
		int MileageResult=0;
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
			MileageResult=paymentDao.insertMileage(mileage);				// 마일리지 테이블에 등록
		}
		
		return MileageResult;	
	}
	
	// 좌석 다:다 등록
	public int insertSeats(String[] seatCode, String pmtCode){
		logger.debug("		insertSeats() 진입 seatCode : "+seatCode);
		
		Map<String, String> map = new HashMap<String, String>();
		for(int i =0; i<seatCode.length;i++){
			if(seatCode[i]==""){
				break;
			}else{
				String seatsCode = homeService.madeCode("seats");
				map.put("seatsCode", seatsCode);
				map.put("pmtCode",pmtCode);
				map.put("seatCode", seatCode[i]);
				paymentDao.insertSeats(map);	
			}
		}
		return 0;
	}
	
	// 좌석 업데이트(able->use)
	public int updateSeatInfo(String[] seatCode){
		logger.debug("		updateSeatInfo() 진입 seatCode : "+seatCode);
		
		Map<String, String> seatMap = new HashMap<String, String>();
		for(int i=0; i<seatCode.length;i++){
			if(seatCode[i]==""){
				break;
			}else{
				seatMap.put("seatUseStatus", "use");
				seatMap.put("seatCode", seatCode[i]);
				paymentDao.updateSeat(seatMap);
			}
		}
		
		return 0;
	}
	
	// 지점별 분석
	 public int updateBranchDayCount(String scsCode, int pmtTicketNum, int pmtPrice){
		 logger.debug("	updateBranchDayCount 진입 scsCode : "+
				 	scsCode+" pmtTicketNum : "+pmtTicketNum+" pmtPrice : "+pmtPrice);
		 
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
	 
	 
	 
	 
	 //*****************결제취소*********************
	 
	 // 결제 취소 MAIN
	 public int updateCancelPayment(String pmtCode){
		 logger.debug("	updateCancelPayment 진입 pmtCode : "+pmtCode);
		 
		 Map<String, Object> payment = 
				 paymentDao.selectOnePaymentInfo(pmtCode);		// DB에서 결제 정보 가져오기
		 logger.debug("결제취소 들어온 map : "+payment);
		 String scsCode=(String) payment.get("scsCode");		// 결제 한 상영 코드
		 String memId = (String) payment.get("memId");			// 결제 한 회원 아이디
		 String nmemCode = (String) payment.get("nmemCode");	// 결제 한 비회원 코드
		 int pmtTicketNum=-(int) payment.get("pmtTicketNum");	// 결제 한 인원
		 int pmtPrice = -(int) payment.get("pmtPrice");			// 결제 한 금액
		 
		 // payment 상태 업데이트
		 updatePaymentStatus(pmtCode);
		 
		 // 마일리지 정보 업데이트
		 updateMileageInfo(memId, pmtPrice, pmtCode);
		 
		 // 회원 마일리지 업데이트
		 updateMileage(memId);
		 
		// 좌석 정보 업데이트
		 updateSeatInfo(pmtCode);
				 
		 // 통계 업데이트
		 updateAnalysis(memId, nmemCode, pmtTicketNum, pmtPrice, scsCode);
		 
		 // 지점별 예매.매출 업데이트
		 updateBranchDayCount(scsCode, pmtTicketNum, pmtPrice);
		 return 0;
	 }

	 // payment 상태 업데이트
	 public int updatePaymentStatus(String pmtCode){
		 logger.debug("		updatePaymentStatus pmtCode : "+pmtCode);
		 Map<String, String> map = new HashMap<String, String>();
		 map.put("pmtStatus", "취소");
		 map.put("pmtCode", pmtCode);
		 
		 return paymentDao.updatePaymentStatus(map);
	 }
	 
	 // 마일리지 내역 등록(취소)
	 public int updateMileageInfo(String memId, int pmtPrice, String pmtCode){
		 logger.debug("		updateMileageInfo memId : "+memId
				 +" pmtPrice : "+pmtPrice+" pmtCode : "+pmtCode);
		 
		 Mileage mileage = new Mileage();						// 마일리지 객체 생성
		 mileage.setMemId(memId);								// 마일리지 객체에 memId 셋팅
		 mileage.setMilCode(homeService.madeCode("mileage"));	// 마일리지 코드 생성 & 셋팅
		 int saveMileage = (int) -(pmtPrice*MILEAGE_RATE);		// 결제 금액에 대한 (-)마일리지
		 mileage.setMilSave(saveMileage);						// 마일리지 셋팅
		 mileage.setMilUse(0);									// 사용 마일리지 0으로 셋팅
		 mileage.setPmtCode(pmtCode);							// 결제 코드 셋팅
		 
		 logger.debug(" DB로 갈 updateMileageInfo mileage : "+mileage);
		 return paymentDao.insertMileage(mileage);
	 }
	 
	 // 회원 테이블 마일리지 업데이트
	 public int updateMileage(String memId){
		 logger.debug("		updateMileage memId : "+memId);
		return paymentDao.updateMemMileage(memId);					// 회원 마일리지 정보 업데이트
	 }
	 
	 // 좌석 정보 업데이트
	 public int updateSeatInfo(String pmtCode){
		 logger.debug("		updateSeatInfo pmtCode : "+pmtCode);
		 
		 List<String> seatCode = paymentDao.selectSeatInfo(pmtCode);	// 결제 한 좌석정보 가져오기
		 logger.debug("	updateCancelPayment seatInfo : "+seatCode);
		 Map<String, String> seatMap = new HashMap<String, String>();	// mapper로 보낼 map 생성
		 
		 for(int i=0;i<seatCode.size();i++){							// 가져온 좌석정보 크기만큼 for문 실행
			 seatMap.put("seatUseStatus", "able");
			 seatMap.put("seatCode", seatCode.get(i));
			 paymentDao.updateSeat(seatMap);
		 }
		 return 0;
	 }
	 
	// Analysis에서 결제정보 빼기
	 public int updateAnalysis(String memId, String nmemCode, int pmtTicketNum, int pmtPrice, String scsCode){
		 logger.debug("		updateAnalysis memId : "+memId+" nmemCode : "+
				 	nmemCode+" pmtTicketNum : "+pmtTicketNum+" pmtPrice : "+pmtPrice+" scsCode : "+scsCode);
		 
		 Analysis analysis = new Analysis();
		 
		 int getMovCode = paymentDao.selectOneMovCode(scsCode);		// 예매 정보에서 영화코드 가져오기
			logger.debug("updateAnalysis bookingInfo : "+getMovCode);

			analysis.setMovCode(getMovCode);			// Analysis에 영화 코드 셋팅
			
			String gender = "";		// 성별 변수 초기화
			String birth="";		// 생년월일 변수 초기화
			
			if(nmemCode.equals("회원")){						// 회원 일때
				System.out.println("회원쪽 진입");
				Map<String, Object> memberMap = paymentDao.selectOneMemInfo(memId);		// 회원 아이디로 회원정보 가져오기
				logger.debug("	updateAnalysis memberMap : "+memberMap);
				
				gender =  (String) memberMap.get("memGender");							// 회원 정보 : 회원 성별
				Date memBirth = (Date) memberMap.get("memBirth");						// 회원 정보 : 생년월일
				birth = memBirth.toString();											// 생년월일 String으로 변환
				System.out.println("회원 birth : "+birth);
				
				// 성별,누적매출,예매누적 정보 담기
				switch (gender){
				case "남" :
					analysis.setAnlManTicketCount(pmtTicketNum);
					analysis.setAnlTotalTicketCount(pmtTicketNum);			// 전체 예매 수
					analysis.setAnlAcSales(pmtPrice);						// 누적 매출액
					break;
				case "여" :
					analysis.setAnlWomanTicketCount(pmtTicketNum);
					analysis.setAnlTotalTicketCount(pmtTicketNum);			// 전체 예매 수
					analysis.setAnlAcSales(pmtPrice);						// 누적 매출액
					break;
				default :
					break;
				
				}
				
			}else {										// 비회원 일때	
				System.out.println("비회원쪽 진입");
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
					analysis.setAnl10sTicketCount(pmtTicketNum);			// Analysis에 10대 예매 수 셋팅
					break;
				case (2) :
					analysis.setAnl20sTicketCount(pmtTicketNum);			// Analysis에 20대 예매 수 셋팅
					break;
				case (3) :
					analysis.setAnl30sTicketCount(pmtTicketNum);			// Analysis에 30대 예매 수 셋팅
					break;
				case (4) :
					analysis.setAnl40sTicketCount(pmtTicketNum);			// Analysis에 40대 예매 수 셋팅
					break;
				default :
					analysis.setAnlOver50sTicketCount(pmtTicketNum);		// Analysis에 50대 이상 예매 수 셋팅
					break;
				}
				
			logger.debug("updateAnalysis db로 갈"+analysis);
			return paymentDao.updateAnalysis(analysis);
	 }
	 
	 
		// ************* 예매 -> 결제 화면*************
		
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
				char seatRow = seatInfo.getSeatRow();
				String seatCol =Integer.toString(seatInfo.getSeatCol());
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
		
}

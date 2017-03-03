package kr.co.cinema.payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.HomeService;
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
	final double MILEAGE_RATE=0.3;		// 마일리지 적립율 변수 선언
	
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
		int milUse = payment.getUseMileage();
		int milSave = (int) ((payment.getPmtPrice())*MILEAGE_RATE);			// 0.3% 적립
		if(memId != "비회원"){
			String milCode = homeService.madeCode("mileage");				// 마일리지 코드 생성
			Mileage mileage = new Mileage();								// 마일리지 객체 생성
			mileage.setMilCode(milCode);									// 마일리지 객체에 데이터 셋팅
			mileage.setPmtCode(pmtCode);
			mileage.setMilSave(milSave);
			mileage.setMilUse(milUse);
			mileage.setMemId(memId);
			
			resultMileage = paymentDao.insertMileage(mileage);				// 마일리지 테이블에 등록
			resultMemUpdate = paymentDao.updateMemMileage(memId);			// 회원 마일리지 정보 업데이트
		}
		
		// 좌석 다:다 등록
		Map<String, String> map = new HashMap<String, String>();
		for(int i =0; i<payment.getSeatCode().length;i++){
			if(payment.getSeatCode()[i]==""){
				break;
			}else{
				String seatsCode = homeService.makeCode("seats");
				map.put("seatsCode", seatsCode);
				map.put("pmtCode",pmtCode);
				map.put("seatCode", payment.getSeatCode()[i]);
				paymentDao.insertSeats(map);	
			}
			
		}
		// 좌석 업데이트(able->use)
		for(int i=0; i<payment.getSeatCode().length;i++){
			if(payment.getSeatCode()[i]==""){
				break;
			}else{
				paymentDao.updateSeat(payment.getSeatCode()[i]);
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
	
	// 마일리지 정보 가져오기
	public Map<String, Integer> searchOneMileage(String memId){
		logger.debug("		selectOneMileage() 진입 memId : "+memId);
		return paymentDao.selectOneMileage(memId);
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
	public BookingInfo searchBookingInfo(String scsCode){
		logger.debug(		"searchBookingInfo() 진입");
		
		int digitalCost=0;			// 디지털 단가 변수 초기화
		int ThreeDCost=0;			// 3D 단가 변수 초기화
		int imaxCost=0;				// IMAX 단가 변수 초기화
		int morningCost=0;			// 조조 할인 변수 초기화
		int nightCost=0;			// 심야 할인 변수 초기화
		int resultCost=0;			// 반환할 최종가격 변수 초기화
		
		
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
		BookingInfo bookingInfo = paymentDao.selectBookingInfo(scsCode);		// 상영 정보 가져오기
		switch(bookingInfo.getScsScreen()){
			case "디지털" :
				switch(bookingInfo.getScsTimeDiscount()){
					case "일반" :													// 상영 단가가 "디지털"이고, 할인 정보가 "일반"일때
						resultCost = digitalCost;								// 결과 값 : 디지털 단가
						bookingInfo.setFinalCost(resultCost);
						break;
					case "조조" : 												// 상영 단가가 "디지털"이고, 할인 정보가 "조조"일때
						resultCost = digitalCost-morningCost;					// 결과 값 : (디지털 단가)-(조조 할인가격)
						bookingInfo.setFinalCost(resultCost);
						break;
					case "심야" : 												// 상영 단가가 "디지털"이고, 할인 정보가 "심야"일때
						resultCost = digitalCost-nightCost;						// 결과 값 : (디지털 단가)-(심야 할인가격)
						bookingInfo.setFinalCost(resultCost);
						break;
				}
				break;
			case "3D" :
				switch(bookingInfo.getScsTimeDiscount()){
					case "일반" :													// 상영 단가가 "3D"이고, 할인 정보가 "일반"일때
						resultCost = ThreeDCost;								// 결과 값 : 3D 단가
						bookingInfo.setFinalCost(resultCost);
						break;
					case "조조" : 												// 상영 단가가 "3D"이고, 할인 정보가 "조조"일때
						resultCost = ThreeDCost-morningCost;					// 결과 값 : (3D 단가)-(조조 할인가격)
						bookingInfo.setFinalCost(resultCost);
						break;
					case "심야" : 												// 상영 단가가 "3D"이고, 할인 정보가 "심야"일때
						resultCost = ThreeDCost-nightCost;						// 결과 값 : (3D 단가)-(심야 할인가격)
						bookingInfo.setFinalCost(resultCost);
						break;
			}
				break;
			case "IMAX" :
				switch(bookingInfo.getScsTimeDiscount()){
					case "일반" : 												// 상영 단가가 "IMAX"이고, 할인 정보가 "일반"일때
						resultCost = imaxCost;									// 결과 값 : IMAX 단가
						bookingInfo.setFinalCost(resultCost);
						break;
					case "조조" :  												// 상영 단가가 "IMAX"이고, 할인 정보가 "조조"일때
						resultCost = imaxCost-morningCost;						// 결과 값 : (IMAX 단가)-(조조 할인가격)
						bookingInfo.setFinalCost(resultCost);
						break;
					case "심야" : 												// 상영 단가가 "IMAX"이고, 할인 정보가 "심야"일때
						resultCost = imaxCost-nightCost;						// 결과 값 : (IMAX 단가)-(심야 할인가격)
						bookingInfo.setFinalCost(resultCost);
						break;
			}
				break;
		}
		logger.debug("		bookingInfo : "+bookingInfo);
		return bookingInfo;
	}
}

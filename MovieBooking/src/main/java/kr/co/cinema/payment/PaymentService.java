package kr.co.cinema.payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.dto.DiscountInfo;
import kr.co.cinema.dto.ScreenCost;

@Service
public class PaymentService {
	private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
	
	@Autowired
	private PaymentDao paymentDao;
	
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

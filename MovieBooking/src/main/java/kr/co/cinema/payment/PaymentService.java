package kr.co.cinema.payment;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.dto.DiscountInfo;

@Service
public class PaymentService {
	private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
	
	@Autowired
	private PaymentDao paymentDao;
	
	// 상영 단가 가져오기
	public List<DiscountInfo> searchListDiscountInfo(){
		
		return paymentDao.selectListDiscountInfo();
	}
	
	// 결제시 영화 정보 가져오기
	public BookingInfo searchBookingInfo(String scsCode){
	
		return paymentDao.selectBookingInfo(scsCode);
	}
}

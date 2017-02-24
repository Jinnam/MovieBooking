package kr.co.cinema.payment;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.cinema.HomeController;
import kr.co.cinema.booking.BookingSeatSelectDto;
import kr.co.cinema.dto.DiscountInfo;
import kr.co.cinema.dto.Payment;

@Controller
public class PaymentController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	@Autowired
	private PaymentService paymentService;
	
	// 결제 페이지 GET
	@RequestMapping(value="/payment")
	public String payment(Model model,
			BookingSeatSelectDto bookingSeatSelectDto){
		logger.debug("		payment() get방식 진입");
		
		// 할인 정보 가져오기.
		List<DiscountInfo> discountInfo = paymentService.searchListDiscountInfo();
		model.addAttribute("DiscountInfo", discountInfo);
		
		// 영화 정보 가져오기.
	//	String scsCode = bookingSeatSelectDto.getScsCode();
		String personNum = bookingSeatSelectDto.getPersonNum();
		String scsCode="43170221101101104";										// test를 위한 scsCode
		BookingInfo bookingInfo = paymentService.searchBookingInfo(scsCode);	// 상영일정코드로 상영 정보 가져오기
	//	bookingInfo.setPersonNum(personNum);									// bookingInfo에 인원 수 추가
		bookingInfo.setPersonNum("1");
		logger.debug(		"payment() get방식 : "+bookingInfo.toString());
		model.addAttribute("bookingInfo",bookingInfo);
		
		return "payment/payment";
	}
	
	// 결제 페이지 POST
	@RequestMapping(value="/payment", method=RequestMethod.POST)
	public String payment(Payment payment){
		
		
		return "payment/payment";
	}
}

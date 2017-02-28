package kr.co.cinema.payment;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
			HttpSession session,
			BookingSeatSelectDto bookingSeatSelectDto){
		logger.debug("	payment() get방식 진입");
		logger.debug("	bookingSeatSelectDto : "+bookingSeatSelectDto);
		
		// session 확인 후 반환할 페이지 초기화
		String resultPage=null;
		
	 	session.setAttribute("phone", "01011112222");				//가라 세션
		// 세션 있는지 없는지 확인 후 결제페이지or 비회원 확인 페이지 이동
		if(session.getAttribute("phone") !=null){
			
			//session 정보 가져오기
		//	String memId = (String) session.getAttribute("id");
			String memId = "id001";
			Map<String, Integer> map = paymentService.searchOneMileage(memId);
			System.out.println("map : "+map);
			model.addAttribute("memMap", map);
			
			// 할인 정보 가져오기.
			List<DiscountInfo> discountInfo = paymentService.searchListDcPersonInfo();
			logger.debug(		"할인정보 가져온값 : "+discountInfo.toString());
			model.addAttribute("DiscountInfo", discountInfo);
			
			// 영화 정보 가져오기.
			String scsCode = bookingSeatSelectDto.getScsCode();
			String personNum = bookingSeatSelectDto.getPersonNum();						// test를 위한 scsCode
			BookingInfo bookingInfo = paymentService.searchBookingInfo(scsCode);		// 상영일정코드로 상영 정보 가져오기
			bookingInfo.setPersonNum(personNum);										// bookingInfo에 인원 수 추가
			logger.debug(		"payment() get방식 : "+bookingInfo.toString());
			model.addAttribute("bookingInfo",bookingInfo);
			
			resultPage="payment/payment";
		}else{
			resultPage="movieMain";
		}
			
		return resultPage;
	}
	
	// 결제 페이지 POST
	@RequestMapping(value="/payment", method=RequestMethod.POST)
	public String payment(Payment payment){
		logger.debug("payment post:"+payment.toString());
		
		return "redirect:movieMain";
	}
}

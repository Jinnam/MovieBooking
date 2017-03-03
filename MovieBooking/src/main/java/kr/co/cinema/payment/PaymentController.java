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
		String resultPage="movieMain";
		
		session.setAttribute("phone", "01011112222");							// ***가짜 세션***
	 	String getSession = (String) session.getAttribute("phone");
		// 세션 있는지 없는지 확인 후 결제페이지or 비회원 확인 페이지 이동
		if(getSession !=null){
			model.addAttribute("bookingSeatSelectDto",bookingSeatSelectDto);	// 예매에서 넘어온 정보
			
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
			String seatCode1 = 
					paymentService.searchOneSeatInfo(bookingSeatSelectDto.getSeatCode1());	// 첫번째 좌석 이름
			String seatCode2 = 
					paymentService.searchOneSeatInfo(bookingSeatSelectDto.getSeatCode2());	// 두번째 좌석 이름
			String seatCode3 = 
					paymentService.searchOneSeatInfo(bookingSeatSelectDto.getSeatCode3());	// 세번째 좌석 이름
			String seatCode4 = 
					paymentService.searchOneSeatInfo(bookingSeatSelectDto.getSeatCode4());	// 네번째 좌석 이름
			String personNum = bookingSeatSelectDto.getPersonNum();							// test를 위한 scsCode 추출
			BookingInfo bookingInfo = paymentService.searchBookingInfo(scsCode);			// 상영일정코드로 상영 정보 가져오기
			bookingInfo.setPersonNum(personNum);											// bookingInfo에 인원 수 추가
			bookingInfo.setSeatCode1(seatCode1);											// 첫번째 좌석 이름 추가
			bookingInfo.setSeatCode2(seatCode2);											// 두번째 좌석 이름 추가
			bookingInfo.setSeatCode3(seatCode3);											// 세번째 좌석 이름 추가
			bookingInfo.setSeatCode4(seatCode4);											// 네번째 좌석 이름 추가
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
	public String payment(Model model, Payment payment, HttpSession session){
		logger.debug("		payment post:"+payment.toString());
		
		session.setAttribute("phone", "01012344322");
		
		String id = (String) session.getAttribute("id");							// 세션에 있는 id값을 가져옴
		String phone = (String) session.getAttribute("phone");						// 세션에 있는 전화번호를 가져옴
		if(id != null){
			payment.setMemId(id);
			payment.setNmemCode("회원");
		}else{
			String nmemCode = paymentService.searchOneNmemCode(phone);
			payment.setNmemCode(nmemCode);
			payment.setMemId("비회원");
		}
		paymentService.insertPayment(payment);										// db에 결제 등록
		
		model.addAttribute("payment",payment);										// 결제 결과 보여주기 위한 정보를 model에 올림
		return "payment/paymentResult";
	}
}

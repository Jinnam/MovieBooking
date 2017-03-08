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
		
	 	String getSessionPhone = (String) session.getAttribute("phone");		// 세션에서 전화번호 가져오기
	 	
		// ***세션에 전화번호가 있는지 없는지 확인 후 결제페이지or 비회원 확인 페이지 이동***
		if(getSessionPhone != null){	// 회원
			logger.debug(" payment get 회원 진입");
			model.addAttribute("bookingSeatSelectDto",bookingSeatSelectDto);	// 예매에서 넘어온 정보
			
			// session 정보 가져오기
			String memId = (String) session.getAttribute("id");					// 세션에서 회원 아이디 가져오기

			Map<String, Object> map = paymentService.searchOneMemInfo(memId);	// 아이디로 회원 정보(마일리지) 가져오기
			System.out.println("map : "+map);
			model.addAttribute("memMap", map);									// 회원정보(마일리지) 모델에 올리기
			
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
			String personNum = bookingSeatSelectDto.getPersonNum();							// 예매 인원
			
			Map<String, Object> bookingInfo = paymentService.searchBookingInfo(scsCode);	// 상영일정코드로 상영 정보 가져오기
			bookingInfo.put("personNum",personNum);											// bookingInfo에 인원 수 추가
			bookingInfo.put("seatCode1",seatCode1);											// 첫번째 좌석 이름 추가
			bookingInfo.put("seatCode2",seatCode2);											// 두번째 좌석 이름 추가
			bookingInfo.put("seatCode3",seatCode3);											// 세번째 좌석 이름 추가
			bookingInfo.put("seatCode4",seatCode4);											// 네번째 좌석 이름 추가
			logger.debug(		"payment() get방식 : "+bookingInfo.toString());
			model.addAttribute("bookingInfo",bookingInfo);
			
			resultPage="payment/payment";
		}
		
		//비회원은 <로그인/비회원결제> 선택 페이지 이동
		else{
			logger.debug(" payment get 비회원 진입");
			model.addAttribute("bookingSeatSelectDto",bookingSeatSelectDto);
			resultPage="login/memberLogin";
		}
			
		return resultPage;
	}
	
	// 결제 페이지 POST
	@RequestMapping(value="/payment", method=RequestMethod.POST)
	public String payment(Model model, Payment payment, HttpSession session){
		logger.debug("		payment post:"+payment.toString());
		
		String id = (String) session.getAttribute("id");							// 세션에 있는 id값을 가져옴
		String phone = (String) session.getAttribute("phone");						// 세션에 있는 전화번호를 가져옴
		System.out.println("세션 아이디 : "+id+"  세션 전화번호 : "+phone);
		if(id != null){
			payment.setMemId(id);
			payment.setNmemCode("회원");
		}else{
			String nmemCode = paymentService.searchOneNmemCode(phone);
			payment.setNmemCode(nmemCode);
			payment.setMemId("비회원");
			session.invalidate();								// 비회원 세션 만료
		}
		String[] seatCode = new String[4];						// seatCode를 배열에 넣기 위해 4개의 배열 생성
		seatCode[0] = payment.getSeatCode1();					// 첫번재 배열에 첫번째 좌석코드 셋팅
		seatCode[1] = payment.getSeatCode2();					// 두번재 배열에 두번째 좌석코드 셋팅
		seatCode[2] = payment.getSeatCode3();					// 세번재 배열에 세번째 좌석코드 셋팅
		seatCode[3] = payment.getSeatCode4();					// 네번재 배열에 네번째 좌석코드 셋팅
		payment.setSeatCode(seatCode);
		
		paymentService.insertPayment(payment);					// 결제 등록		
		
		model.addAttribute("payment",payment);					// 결제 결과 보여주기 위한 정보를 model에 올림
		
		return "payment/paymentResult";
	}
	
	// 예매 취소
	
	@RequestMapping(value="/cancelpayment")
	public String cancelPayment(String pmtCode){
		logger.debug("		cancelPayment :"+pmtCode);
	
		paymentService.updateCancelPayment(pmtCode);
		
		return "redirect:bookingSelect";
	}
}

package kr.co.cinema.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.cinema.dto.DiscountInfo;
import kr.co.cinema.dto.Payment;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	// 결제 페이지 GET
	@RequestMapping(value="/payment")
	public String payment(Model model){
		
		// 할인 정보 가져오기.
		List<DiscountInfo> discountInfo = paymentService.searchListDiscountInfo();
		model.addAttribute("DiscountInfo", discountInfo);
		
		// 영화 정보 가져오기.
		
		
		return "payment/payment";
	}
	
	// 결제 페이지 POST
	@RequestMapping(value="/payment", method=RequestMethod.POST)
	public String payment(Payment payment){
		
		
		return "payment/payment";
	}
}

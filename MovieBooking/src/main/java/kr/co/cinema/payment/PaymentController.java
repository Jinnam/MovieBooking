package kr.co.cinema.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.cinema.dto.Payment;
import kr.co.cinema.dto.ScreenCost;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value="/payment")
	public String payment(Model model){
		
		// 할인 정보 가져오기.
	//	List<ScreenCost> screenCost = paymentService.searchListDiscountInfo();
	//	model.addAttribute("ScreenCost", screenCost);
		
		return "payment/payment";
	}
	
	@RequestMapping(value="/payment", method=RequestMethod.POST)
	public String payment(Payment payment){
		
		
		return "payment/payment";
	}
}

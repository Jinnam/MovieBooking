package kr.co.cinema.booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BookingController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

	
	//영화 예매 선택페이지 1
	@RequestMapping(value = "/bookingSelect1", method = RequestMethod.GET)
	public String bookingSelect1() {	
		return "booking/bookingSelect1";
	}
	
	
	
}

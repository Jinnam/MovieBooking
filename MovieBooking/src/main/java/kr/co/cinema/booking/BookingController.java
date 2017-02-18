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
	@RequestMapping(value = "/bookingSelect", method = RequestMethod.GET)
	public String bookingSelect() {	
		logger.debug("bookingSelect 영화 예매 선택페이지");
		return "booking/bookingSelect";
	}
	
	//영화 좌석 선택페이지 1
	@RequestMapping(value = "/bookingSeatSelect", method = RequestMethod.POST)
	public String bookingSeatSelect() {	
		logger.debug("bookingSeatSelect 영화 좌석 선택페이지");
		return "booking/bookingSeatSelect";
	}	
	
}

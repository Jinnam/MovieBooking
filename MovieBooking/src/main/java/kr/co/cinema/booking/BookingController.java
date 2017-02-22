package kr.co.cinema.booking;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.cinema.dto.Movie;


@Controller
public class BookingController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	BookingService bookingService;
	
	//영화 예매 선택페이지
	@RequestMapping(value = "/bookingSelect", method = RequestMethod.GET)
	public String bookingSelect(Model model) {	
		logger.debug("bookingSelect 영화 예매 선택페이지");
		
		List<String> date =bookingService.searchListDate();
		System.out.println(date.get(0).toString());
		List<Movie> movie=bookingService.searchListMovie();
		System.out.println(movie.get(0).toString());
		
		model.addAttribute("date",bookingService.searchListDate());
		model.addAttribute("movie",bookingService.searchListMovie());
		model.addAttribute("branch",bookingService.searchListBranch());
		return "booking/bookingSelect";
	}
	
	//영화 좌석 선택페이지
	@RequestMapping(value = "/bookingSeatSelect", method = RequestMethod.POST)
	public String bookingSeatSelect() {	
		logger.debug("bookingSeatSelect 영화 좌석 선택페이지");
		return "booking/bookingSeatSelect";
	}	
	
}

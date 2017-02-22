package kr.co.cinema.booking;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.cinema.dto.BookingSelect;
import kr.co.cinema.dto.Movie;
import kr.co.cinema.dto.ScreenSchedule;


@Controller
public class BookingController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	BookingService bookingService;
	
	
	//AJAX 영화 상영 일정 가져오기
	@RequestMapping(value = "/searchListScreenInfo", method = RequestMethod.POST)
	public @ResponseBody List<ScreenSchedule> searchListScreenInfo(BookingSelect bookingSelect) {	
		logger.debug("searchListScreenInfo 영화 상영일정 가져오기");
		return bookingService.searchListScreenInfo(bookingSelect);
	}	
	
	//영화 예매 선택페이지
	@RequestMapping(value = "/bookingSelect", method = RequestMethod.GET)
	public String bookingSelect(Model model) {	
		logger.debug("bookingSelect 영화 예매 선택페이지");			
		model.addAttribute("date",bookingService.searchListDate());			//상영날짜 가져오기
		model.addAttribute("movie",bookingService.searchListMovie());		//상영 영화 가져오기
		model.addAttribute("branch",bookingService.searchListBranch());		//상영 지점 가져오기
		return "booking/bookingSelect";
	}
	
	//영화 좌석 선택페이지
	@RequestMapping(value = "/bookingSeatSelect", method = RequestMethod.POST)
	public String bookingSeatSelect() {	
		logger.debug("bookingSeatSelect 영화 좌석 선택페이지");
		return "booking/bookingSeatSelect";
	}	
	
}

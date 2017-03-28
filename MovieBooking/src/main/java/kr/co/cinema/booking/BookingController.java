package kr.co.cinema.booking;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.cinema.dto.ScreenSchedule;
import kr.co.cinema.dto.Seat;


@Controller
public class BookingController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	BookingService bookingService;
	@Autowired
	BookingDao bookingDao;
	
	//AJAX 영화 조건선택
	@RequestMapping(value = "/searchListBookingSelect", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> searchListBookingSelect(BookingSelectDto bookingSelect) {	
		logger.debug("searchListBookingSelect 영화 조건선택 ");
		return bookingService.searchListBookingSelect(bookingSelect);
	}	
	
	//AJAX 영화 조건선택 3개 상영 일정 가져오기
	@RequestMapping(value = "/searchListScreenInfo", method = RequestMethod.GET)
	public @ResponseBody List<ScreenSchedule> searchListScreenInfo(BookingSelectDto bookingSelect) {	
		logger.debug("searchListScreenInfo 영화 상영일정 가져오기");
		return bookingDao.selectListScreenInfo(bookingSelect);
	}	
	
	//영화 예매 선택페이지
	@RequestMapping(value = "/bookingSelect", method = RequestMethod.GET)
	public String bookingSelect(Model model) {	
		logger.debug("bookingSelect 영화 예매 선택페이지");			
		model.addAttribute("date",bookingDao.selectListDate());			//상영날짜 가져오기
		model.addAttribute("movie",bookingDao.selectListMovie());		//상영 영화 가져오기
		model.addAttribute("branch",bookingDao.selectListBranch());		//상영 지점 가져오기
		return "booking/bookingSelect";
	}
	
	//영화 좌석 선택페이지
	@RequestMapping(value = "/bookingSeatSelect", method = RequestMethod.POST)
	public String bookingSeatSelect(@RequestParam(value="scsCode") String scsCode,Model model) {	
		logger.debug("bookingSeatSelect 영화 좌석 선택페이지");
		
		Map<String,String> map = bookingDao.selectOneScreenSchedule(scsCode); // 상영일정코드에 맞는 상영정보 및영화정보 가져오기
		List<Seat> seat = bookingDao.countTotalSeat(scsCode); //상영코드 일치하는 좌석 정보 가져오기
		model.addAttribute("map",map);
		model.addAttribute("seat",seat);
		model.addAttribute("scsCode",scsCode);

		return "booking/bookingSeatSelect";
	}	
	
}

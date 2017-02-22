package kr.co.cinema.booking;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.dto.BookingSelect;
import kr.co.cinema.dto.Branch;
import kr.co.cinema.dto.Movie;
import kr.co.cinema.dto.ScreenSchedule;

@Service
public class BookingService {
	private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
	
	@Autowired
	BookingDao bookingDao;
	
	//ajax 영화+지점+날짜에 맞는 상영일정 가져오기
	public List<ScreenSchedule> searchListScreenInfo(BookingSelect bookingSelect){
		logger.debug("searchListScreenInfo 영화+지점+날짜에 맞는 상영일정 가져오기");	
		return bookingDao.SelectListScreenInfo(bookingSelect);		
	}
	
	//영화 예매페이지에서 나타낼 현재 상영중인 영화가 있는 날짜 조회
	public List<String> searchListDate(){
		logger.debug("searchListDate 상영중인날짜리스트조회");		
		return bookingDao.selectListDate();
	}	
	
	//영화 예매페이지에서 나타낼 현재 상영중인 영화 조회
	public List<Movie> searchListMovie(){
		logger.debug("searchListMovie 상영중인영화리스트조회");	
		return bookingDao.selectListMovie();
	}	
	
	//영화 예매페이지에서 나타낼 지점 전체 조회
	public List<Branch> searchListBranch(){
		logger.debug("searchListMovie 상영중인지점조회");	
		return bookingDao.selectListBranch();
	}
}

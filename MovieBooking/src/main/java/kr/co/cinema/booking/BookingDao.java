package kr.co.cinema.booking;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.Branch;
import kr.co.cinema.dto.Movie;
import kr.co.cinema.dto.ScreenSchedule;

@Repository
public class BookingDao {
	private static final Logger logger = LoggerFactory.getLogger(BookingDao.class);
		
	@Autowired
	private SqlSessionTemplate session;
	
	private final String mapperNS="kr.co.cinema.booking.BookingMapper.";
	
	
	//ajax 영화+지점+날짜에 맞는 상영일정 가져오기
	public List<ScreenSchedule> SelectListScreenInfo(BookingSelectDto bookingSelect){
		logger.debug("SelectListScreenInfo 영화+지점+날짜에 맞는 상영일정 가져오기");
		return session.selectList(mapperNS+"SelectListScreenInfo",bookingSelect);		
	}
	
	//영화 예매페이지에서 나타낼 현재 상영중인 영화가 있는 날짜 조회
	public List<String> selectListDate(){
		logger.debug("selectListDate 상영중인날짜리스트조회");		
		return session.selectList(mapperNS+"selectListDate");
	}
	
	//영화 예매페이지에서 나타낼 현재 상영중인 영화 조회
	public List<Movie> selectListMovie(){
		logger.debug("selectListDate 상영중인영화리스트조회");		
		return session.selectList(mapperNS+"selectListMovie");
	}
	
	//영화 예매페이지에서 나타낼 현재 상영중인 지점 조회
	public List<Branch> selectListBranch(){
		logger.debug("selectListDate 상영중인지점리스트조회");		
		return session.selectList(mapperNS+"selectListBranch");
	}	
}		

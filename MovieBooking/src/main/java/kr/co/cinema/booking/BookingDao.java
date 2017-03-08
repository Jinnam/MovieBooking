package kr.co.cinema.booking;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.Branch;
import kr.co.cinema.dto.Movie;
import kr.co.cinema.dto.ScreenSchedule;
import kr.co.cinema.dto.Seat;

@Repository
public class BookingDao {
	private static final Logger logger = LoggerFactory.getLogger(BookingDao.class);
		
	@Autowired
	private SqlSessionTemplate session;
	
	private final String mapperNS="kr.co.cinema.booking.BookingMapper.";


	//상영일정코드에 맞는 사용중인 좌석 수 가져오기
	public List<Seat> countUseSeat(String scsCode){
		logger.debug("countUseSeat 상영일정코드에 맞는 사용중인 좌석 수 가져오기");
		return session.selectList(mapperNS+"selectListSeat",scsCode);		
	}	
	
	//상영일정코드에 맞는 좌석 수 가져오기
	public List<Seat> countTotalSeat(String scsCode){
		logger.debug("countTotalSeat 상영일정코드에 맞는 좌석 수 가져오기");
		return session.selectList(mapperNS+"selectListSeat",scsCode);		
	}	
	
	//상영일정코드에 맞는 좌석 정보 가져오기
	public List<Seat> selectListSeat(String scsCode){
		logger.debug("selectListSeat 상영일정코드에 맞는 좌석 정보 가져오기");
		return session.selectList(mapperNS+"selectListSeat",scsCode);		
	}
	
	//상영일정코드에 맞는 상영일정및 영화정보  가져오기
	public Map<String,String> selectOneScreenSchedule(String scsCode){
		logger.debug("selectOneScreenSchedule 상영일정코드에 맞는 상영일정및 영화정보  가져오기");
		return session.selectOne(mapperNS+"selectOneScreenSchedule",scsCode);		
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
	
	//---------------------------------------- ajax -------------------------------------------------------
	
		//ajax 조건 1 영화 선택시 지점 가져오기
		public List<Map> selectListBranchCheckMovie(BookingSelectDto bookingSelect){
			logger.debug("SelectListBranchCheckMovie 조건 1 영화 선택시 지점 가져오기");
			return session.selectList(mapperNS+"SelectListBranchCheckMovie",bookingSelect);		
		}
		
		//ajax 조건 1 영화 선택시 날짜 가져오기
		public List<Map> selectListDateCheckMovie(BookingSelectDto bookingSelect){
			logger.debug("SelectListDateCheckMovie 조건 1 영화 선택시 지점 가져오기");
			return session.selectList(mapperNS+"SelectListDateCheckMovie",bookingSelect);		
		}
		
		//ajax 조건 1 지점 선택시 영화 가져오기
		public List<Map> selectListMovieCheckBranch(BookingSelectDto bookingSelect){
			logger.debug("SelectListMovieCheckBranch 조건 1 지점 선택시 영화 가져오기");
			return session.selectList(mapperNS+"SelectListMovieCheckBranch",bookingSelect);		
		}		
		
		//ajax 조건 1 지점 선택시 날짜 가져오기
		public List<Map> selectListDateCheckBranch(BookingSelectDto bookingSelect){
			logger.debug("SelectListDateCheckBranch 조건 1 지점 선택시 날짜 가져오기");
			return session.selectList(mapperNS+"SelectListDateCheckBranch",bookingSelect);		
		}				
		
		//ajax 조건 1 날짜 선택시 영화 가져오기
		public List<Map> selectListMovieCheckDate(BookingSelectDto bookingSelect){
			logger.debug("SelectListMovieCheckDate 조건 1 날짜 선택시 영화 가져오기");
			return session.selectList(mapperNS+"SelectListMovieCheckDate",bookingSelect);		
		}			
		
		//ajax 조건 1 날짜 선택시 지점 가져오기
		public List<Map> selectListBranchCheckDate(BookingSelectDto bookingSelect){
			logger.debug("SelectListBranchCheckDate 조건 1 날짜 선택시 지점 가져오기");
			return session.selectList(mapperNS+"SelectListBranchCheckDate",bookingSelect);		
		}		
		
		
		//ajax 조건 2 영화 지점 날짜 중 조건2가지 선택한경우
		public List<Map> selectListOptionCheckTwo(BookingSelectDto bookingSelect){
			logger.debug("SelectListOptionCheckTwo 조건 2 영화 지점 날짜 중 조건2가지 선택한경우");
			return session.selectList(mapperNS+"SelectListOptionCheckTwo",bookingSelect);		
		}		
		
		//ajax 영화+지점+날짜에 맞는 상영일정 가져오기
		public List<ScreenSchedule> selectListScreenInfo(BookingSelectDto bookingSelect){
			logger.debug("SelectListScreenInfo 영화+지점+날짜에 맞는 상영일정 가져오기");
			return session.selectList(mapperNS+"SelectListScreenInfo",bookingSelect);		
		}
		
	//---------------------------------------- ajax -------------------------------------------------------	
		
}		

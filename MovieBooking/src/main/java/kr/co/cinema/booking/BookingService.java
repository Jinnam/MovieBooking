package kr.co.cinema.booking;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
	private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
	
	@Autowired
	BookingDao bookingDao;
	
	
	public Map<String,Object> searchListBookingSelect(BookingSelectDto bookingSelect){
		
		
		int brcCode = bookingSelect.getBrcCode();		//지점코드
		int movCode = bookingSelect.getMovCode();		//영화코드
		String date = bookingSelect.getDate();			//날짜
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		//조건 1개인경우 
			
		if(movCode!=0 && brcCode==0 && date.equals("")){ //조건 1개 영화코드만 선택한 경우	
			map.put("branch", bookingDao.selectListBranchCheckMovie(bookingSelect)); //지점가져오기
			map.put("date", bookingDao.selectListDateCheckMovie(bookingSelect));	//날짜 가져오기
		}else if(brcCode!=0 && movCode==0 && date.equals("")){ //조건 1개 지점코드만 선택한 경우
			map.put("movie", bookingDao.selectListMovieCheckBranch(bookingSelect));	//영화 가져오기
			map.put("date", bookingDao.selectListDateCheckBranch(bookingSelect));	//날짜 가져오기
		}else if(!date.equals("") && brcCode==0 && movCode==0){ //조건 1개 날짜만 선택한 경우
			map.put("movie", bookingDao.selectListMovieCheckDate(bookingSelect));	//영화 가져오기
			map.put("branch", bookingDao.selectListBranchCheckDate(bookingSelect)); //지점가져오기
		}else if(date.equals("") && brcCode!=0 && movCode!=0){ //조건 2개 영화 ,지점 선택한 경우 날짜 가져오기
			map.put("date", bookingDao.selectListOptionCheckTwo(bookingSelect));
		}else if(brcCode==0 && movCode!=0 && !date.equals("")){ //조건 2개 영화,날짜 선택한경우 지점 가져오기
			map.put("branch", bookingDao.selectListOptionCheckTwo(bookingSelect));
		}else if(movCode==0 && brcCode!=0 && !date.equals("")){ //조건 2개 지점 ,날짜 선택한경우 영화 가져오기
			map.put("movie", bookingDao.selectListOptionCheckTwo(bookingSelect));
		}
		
		
		return map;		
	}
}

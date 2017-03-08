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
			
		if(brcCode==0 && date.equals("")){ //조건 1 영화코드만 선택한 경우	
			map.put("branch", bookingDao.SelectListBranchCheckMovie(bookingSelect));
			map.put("date", bookingDao.SelectListDateCheckMovie(bookingSelect));
			System.out.println(map.toString());
		}else if(movCode==0 && date.equals("")){ //조건 2 지점코드만 선택한 경우
			
		}else if(brcCode==0 && movCode==0){ //조건 3 날짜만 선택한 경우
			
		}
		
		//조건 2개인 경우
		
		if(date.equals("")){ //영화 ,지점 선택한 경우
			System.out.println("영화지점선택");
		}else if(brcCode==0){ //영화,날짜 선택한경우
			
		}else if(movCode==0){ //지점 ,날짜 선택한경우
			
		}
		
		
		return map;		
	}
}

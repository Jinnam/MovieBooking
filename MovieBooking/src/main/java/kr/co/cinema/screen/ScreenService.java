package kr.co.cinema.screen;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.HomeService;
import kr.co.cinema.dto.BranchAndScreen;
import kr.co.cinema.dto.Screen;
import kr.co.cinema.dto.ScreenCost;
import kr.co.cinema.dto.ScreenSchedule;
import kr.co.cinema.dto.Seat;

@Service
public class ScreenService {

	private static final Logger logger = LoggerFactory.getLogger(ScreenService.class);
	
	@Autowired
	private ScreenDao screenDao;
	@Autowired
	private HomeService homeService;
	
	/************************************************************************************************************
	상영관 관리 메서드
	************************************************************************************************************/	

	//상영관등록전 지점이름으로 지점 코드 조회하기 
	public String selectBrcCode(String brcName) {
		logger.debug(" Service selectBrcCode post실행");
		return screenDao.selectBrcCode(brcName);
	}

	//상영관등록
	public int insertScreen(Screen screen) {
		logger.debug(" Service selectBrcCode post실행");
		String ScrCode = homeService.madeCode(screen);
		screen.setScrCode(ScrCode);
		return screenDao.insertScreen(screen);
	}
	
	//상영관리스트조회
	public List<Screen> selectScreenList() {
		logger.debug(" Service selectScreenList get실행");
		return screenDao.selectScreenList();
	}
	
	/************************************************************************************************************
	상영일정 관리 메서드 : 상영일정등록/상영일정리스트/상영일정수정
	************************************************************************************************************/	

	//상영일정 등록전 영화이름으로 영화 코드조회 ajax
	public Map<String, Object> selectMovieCode(String movKorName) {
		logger.debug(" Service selectMovieCode post실행");
		Map<String, Object> movInfo = screenDao.selectMovieCode(movKorName);
		String movRunTime = ((Time)movInfo.get("movRunTime")).toString();
		movInfo.put("getHour",Integer.parseInt((movRunTime.substring(0,2))));
		movInfo.put("getMinute", Integer.parseInt((movRunTime.substring(3,5))));
		System.out.println(movInfo.toString());
		
		return movInfo;
	}
	
	//상영일정 등록 : 지점이름으로 지점코드, 상영관리스트 조회하기
	public List<BranchAndScreen> selectmovieAndScreens(List<BranchAndScreen> movieAndScreens) {
		logger.debug(" Service selectmovieAndScreens post실행");
		return screenDao.selectmovieAndScreens(movieAndScreens);
	}
	
	// 스크린 가격 가져오기
	public List<String> searchListScreenCost(){
		logger.debug("	searchListScreenCost 진입");
		return screenDao.selectListScreenCost();
	}
	
	// 상영관 정보 가져오기
	public List<HashMap<String, Object>> findScreenInfo(int brcCode){
		logger.debug("	findScreenInfo 진입 brcCode : "+brcCode);
		return screenDao.selectScreenInfo(brcCode);
	}
	
	// *****상영일정 등록 main*****
	public int insertScs(ScreenSchedule screenSchedule){
		logger.debug("	insertScs 진입 screenSchedule : "+screenSchedule);

		String scsCode = homeService.madeCode(screenSchedule);				// 상영일정 코드 생성
		screenSchedule.setScsCode(scsCode);									// 상영일정 코드 셋팅
		String getScrCode = screenSchedule.getScrCode();					// 스크린코드 가져오기
		Map<String, Integer> getRowCol=screenDao.selectRowCol(getScrCode);	// 상영관 행열 갖오기
		int getRow = getRowCol.get("scrRowSize");							// 행
		int getCol = getRowCol.get("scrColSize");							// 열
		
		// 상영일정 등록
		int resultScs = insertScreenSchedule(screenSchedule);
		
		// 좌석 등록
		int resultSeat = insertSeat(getScrCode,scsCode,getRow,getCol);
		return resultScs+resultSeat;
	}
	// seatCode, scsCode scrCode 
	// 좌석 등록
	public int insertSeat(String scrCode, String scsCode, int row, int col){
		logger.debug("	insertSeat 진입 scrCode : "+scrCode+" scsCode : "+scsCode+" row:"+row+" col :"+col);
		int result=-1;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				Seat seat = new Seat();
				seat.setScrCode(scrCode);						// 상영관코드 셋팅
				seat.setScsCode(scsCode);						// 상영일정 코드 셋팅
				seat.setSeatRow((char)(i+65));					// 알파벳으로 변환 후 셋팅  
				seat.setSeatCol(j+1);							// 열번호 1부터 시작
				seat.setSeatCode(homeService.madeCode(seat));	// 좌석코드 생성
				logger.debug("seat : " + seat);
				result = screenDao.insertSeat(seat);
			}
		}
		return result;
	}
	
	
	// 상영일정 등록 
		public int insertScreenSchedule(ScreenSchedule screenSchedule){
			logger.debug("	insertScreenSchedule 진입 screenSchedule : "+screenSchedule);
			
			String getStartTime = screenSchedule.getScsStartTime();		// 시작 시간 h시m분
			String getFinishTime = screenSchedule.getScsFinishTime();	// 종료시간 h시 m분
			String startTime = changeTimeStyle(getStartTime);			// hh:mm:ss 로 변환
			String finishTime = changeTimeStyle(getFinishTime);			// hh:mm:ss 로 변환

			screenSchedule.setScsStartTime(startTime);		// 시작시간 셋팅
			screenSchedule.setScsFinishTime(finishTime);	// 종료시간 셋팅
			
			return screenDao.insertScs(screenSchedule);
		}
	// h시m분으로 들어온 값 hh:mm:ss로 바꾸기
		public String changeTimeStyle(String getTime){
			
			int si = getTime.indexOf("시");				// "시" 인덱스 값
			String hour = getTime.substring(0,si);		// "시" 앞 글자 가져오기
			int boon = getTime.indexOf("분");			// "분" 인덱스 값
			String minute=getTime.substring(si+1,boon);	// "시"와"분"사이 값
			
			if(hour.length()<2){		//시간 값이 한자리이면 앞에 "0" 붙여줌
				hour="0"+hour;
			}
			if(minute.length()<2){		// 분 값이 한자리이면 앞에 "0" 붙여줌
				minute="0"+minute;
			}
			
			String returnStartTime=hour+":"+minute+":00"; //반환 값
			return returnStartTime;
		}
		
		// 상영정보 가져오기(List)
		public List<HashMap<String, Object>> searchScreenSchedule(){
			logger.debug("	searchScreenSchedule 진입");
			return screenDao.selectListScreenSchedule();
		}
}

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
	
	// 지점 정보 가져오기
		public List<HashMap<String, Object>> searchBranchInfo(){
			logger.debug("	searchBranchInfo 진입");
			return screenDao.selectBranchInfo();
		}
		
	// 상영관 정보 가져오기
	public List<HashMap<String, Object>> findScreenInfo(String brcCode){
		logger.debug("	findScreenInfo 진입 brcCode : "+brcCode);
		return screenDao.selectScreenInfo(brcCode);
	}

}

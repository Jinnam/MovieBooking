package kr.co.cinema.screen;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.HomeService;
import kr.co.cinema.dto.BranchAndScreen;
import kr.co.cinema.dto.Screen;

@Service
public class ScreenService {

	private static final Logger logger = LoggerFactory.getLogger(ScreenService.class);
	
	@Autowired
	private ScreenDao sreenDao;
	@Autowired
	private HomeService homeService;
	
	/************************************************************************************************************
	상영관 관리 메서드
	************************************************************************************************************/	

	//상영관등록전 지점이름으로 지점 코드 조회하기 
	public String selectBrcCode(String brcName) {
		logger.debug(" Service selectBrcCode post실행");
		return sreenDao.selectBrcCode(brcName);
	}

	//상영관등록
	public int insertScreen(Screen screen) {
		logger.debug(" Service selectBrcCode post실행");
		String ScrCode = homeService.madeCode(screen);
		screen.setScrCode(ScrCode);
		return sreenDao.insertScreen(screen);
	}
	
	//상영관리스트조회
	public List<Screen> selectScreenList() {
		logger.debug(" Service selectScreenList get실행");
		return sreenDao.selectScreenList();
	}
	
	/************************************************************************************************************
	상영일정 관리 메서드 : 상영일정등록/상영일정리스트/상영일정수정
	************************************************************************************************************/	

	//상영일정 등록전 영화이름으로 영화 코드조회 ajax
	public String selectMovieCode(String movKorName) {
		logger.debug(" Service selectMovieCode post실행");
		return sreenDao.selectMovieCode(movKorName);
	}
	
	//상영일정 등록 : 지점이름으로 지점코드, 상영관리스트 조회하기
	public List<BranchAndScreen> selectmovieAndScreens(List<BranchAndScreen> movieAndScreens) {
		logger.debug(" Service selectmovieAndScreens post실행");
		return sreenDao.selectmovieAndScreens(movieAndScreens);
	}

}

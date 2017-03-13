package kr.co.cinema.screen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.BranchAndScreen;
import kr.co.cinema.dto.Screen;
import kr.co.cinema.dto.ScreenSchedule;
import kr.co.cinema.dto.Seat;

@Repository
public class ScreenDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ScreenDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="kr.co.cinema.screen.ScreenMapper.";
	
	/************************************************************************************************************
	상영관 관리 메서드
	************************************************************************************************************/	

	//스크린등록전 지점이름으로 지점코드조회
	public String selectBrcCode(String brcName) {
		logger.debug(" Dao selectBrcCode");
		return sqlSession.selectOne(NS+"selectBrcCode", brcName);
	}

	//상영관 등록
	public int insertScreen(Screen screen) {
		logger.debug(" Dao insertScreen");
		return sqlSession.insert(NS+"insertScreen", screen);
	}
	
	//상영관리스트조회
	public List<Screen> selectScreenList() {
		logger.debug(" Dao selectScreenList");
		return sqlSession.selectList(NS+"selectScreenList");
	}

	/************************************************************************************************************
	상영일정 관리 메서드 : 상영일정등록/상영일정리스트/상영일정수정
	************************************************************************************************************/	

	//상영일정 등록전 영화이름으로 영화코드 조회
	public Map<String, Object> selectMovieCode(String movKorName) {
		logger.debug(" Dao selectMovieCode");
		return sqlSession.selectOne(NS+"selectMovieCode", movKorName);
	}
	
	//상영일정 등록 : 지점이름으로 지점코드, 상영관리스트 조회하기
	public List<BranchAndScreen> selectmovieAndScreens(List<BranchAndScreen> movieAndScreens) {
		logger.debug(" Dao selectmovieAndScreens");
		return sqlSession.selectList(NS+"selectmovieAndScreens", movieAndScreens);
	}
	
	// 스크린 가격 가져오기
	public List<String> selectListScreenCost(){
		logger.debug("	selectListScreenCost 진입");
		return sqlSession.selectList(NS+"selectScreenCost");
	}

	// 상영관 정보 가져오기
	public List<HashMap<String, Object>> selectScreenInfo(int brcCode){
		logger.debug("	selectScreenInfo 진입 brcCode : "+brcCode);
		return sqlSession.selectList(NS+"selectScreenInfo", brcCode);
	}
	
	// 상영일정 등록
	public int insertScs(ScreenSchedule screenSchedule){
		logger.debug("	insertScs 진입 screenSchedule : "+screenSchedule);
		return sqlSession.insert(NS+"insertScs",screenSchedule);
	}
	
	//좌석 등록
	public int insertSeat(Seat seat){
		logger.debug("	insertSeat 진입 seat : "+seat);
		return sqlSession.insert(NS+"insertSeat",seat);	
	}
	
	// 좌석 행/열 가져오기
	public Map<String,Integer> selectRowCol(String scsCode){
		logger.debug("	selectRowCol 진입 scsCode : "+scsCode);
		return sqlSession.selectOne(NS+"selectRowCol",scsCode);
	}
	
	// 상영일정 리스트
	public List<HashMap<String,Object>> selectListScreenSchedule(){
		logger.debug("	selectListScreenSchedule 진입");
		return sqlSession.selectList(NS+"selectScreenSchedule");
	}
}

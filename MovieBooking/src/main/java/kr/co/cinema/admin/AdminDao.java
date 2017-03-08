package kr.co.cinema.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.Admin;
import kr.co.cinema.dto.Branch;
import kr.co.cinema.dto.BranchDayCount;
import kr.co.cinema.dto.Character;
import kr.co.cinema.dto.Member;
import kr.co.cinema.dto.Movie;
import kr.co.cinema.dto.MovieAndBranchDayCount;
import kr.co.cinema.dto.ScreenCost;

@Repository
public class AdminDao {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "kr.co.cinema.admin.AdminMapper.";

	/************************************************************************************************************
	메인페이지 메서드
	************************************************************************************************************/

	//메인페이지 하단우측 영화별 예매율 순위
	public List<Movie> selectClientCount() {
		logger.debug(" Dao selectClientCount");
		return sqlSession.selectList(NS+"selectClientCount");
	}
	
	//원그래프 지점 이름, 지점 코드, 매출합계 조회
	public List<Branch> selectBranchForBarGraph() {
		logger.debug(" Dao selectBranchForBarGraph");
		return sqlSession.selectList(NS+"selectBranchForBarGraph");
	}
	
	//선그래프 총 매출액
	public int selectBranchCount() {
		logger.debug(" Dao selectBranchCount");
		return sqlSession.selectOne(NS+"selectBranchCount");
	}
	
	//선그래프 월 매출액
	public List<BranchDayCount> selectMonthBranchCount() {
		logger.debug(" Dao selectMonthBranchCount");
		return sqlSession.selectList(NS+"selectMonthBranchCount");
	}
	//원 그래프 데이터 상위3지점조회
	public List<MovieAndBranchDayCount> selectMovieCodeForCircleGraph() {
		logger.debug(" Dao selectMovieCodeForCircleGraph");
		return sqlSession.selectList(NS+"selectMovieCodeForCircleGraph");
	}

	/************************************************************************************************************
	지점관리 메서드 : 지점등록/지점조회/지점수정/지점탈퇴
	************************************************************************************************************/

	//지점리스트 조회
	public List<Branch> selectBranchList() {
		logger.debug(" Dao selectBranchList");
		return sqlSession.selectList(NS+"selectBranchList");
	}
	
	//지점등록
	public int insertBranch(Branch branch) {
		logger.debug(" Dao insertBranch");
		return sqlSession.insert(NS+"insertBranch", branch);
	}
	
	//지점 수정하기 위한 조회
	public Branch selectBranchForUpdate(int brcCode) {
		logger.debug(" Dao selectBranchForUpdate");
		return sqlSession.selectOne(NS+"selectBranchForUpdate", brcCode);
	}
	
	//지점수정
	public int updateBranch(Branch branch) {
		logger.debug(" Dao updateBranch");
		return sqlSession.update(NS+"updateBranch", branch);
	}

	//지점탈퇴
	public int deleteBranch(int brcCode) {
		logger.debug(" Dao deleteBranch");
		return sqlSession.delete(NS+"deleteBranch", brcCode);
	}

	/************************************************************************************************************
	지점관리자 메서드 : 지점관리자등록/지점관리자조회/지점관리자수정/지점관리자삭제
	************************************************************************************************************/	

	//지점 관리자 리스트 조회
	public List<Admin> selectAdminList() {
		logger.debug(" Dao selectAdminList");
		return sqlSession.selectList(NS+"selectAdminList");
	}

	//지점 관리자 등록
	public int insertAdmin(Admin admin) {
		logger.debug(" Dao insertAdmin");
		return sqlSession.insert(NS+"insertAdmin", admin);
	}

	//지점관리자 수정 전 관리자 아이디 & 권한조회
	public Admin selectAdminAuthAndId(Admin admin) {
		logger.debug(" Dao selectAdminAuthAndId");
		return sqlSession.selectOne(NS+"selectAdminAuthAndId", admin);
	}
	
	//지점 관리자 수정
	public int updateAdmin(Admin admin) {
		logger.debug(" Dao updateAdmin");
		return sqlSession.update(NS+"updateAdmin", admin);
	}
	
	//지점 관리자 삭제
	public int deleteAdmin(Admin admId) {
		logger.debug(" Dao deleteAdmin");
		return sqlSession.delete(NS+"deleteAdmin", admId);
	}

	/************************************************************************************************************
	회원 관리 메서드 : 회원리스트조회
	************************************************************************************************************/

	//회원리스트 조회
	public List<Member> selectMemberList() {
		logger.debug(" Dao selectMemberList");
		return sqlSession.selectList(NS+"selectMemberList");
	}

	/************************************************************************************************************
	영화 관리 메서드 : 영화등록/영화리스트/영화상세/영화수정
	************************************************************************************************************/	
	
	//영화등록전 인물이름으로 인물코드조회
	public String selectCharCodeForInsertMovie(String charKorName) {
		logger.debug(" Dao selectCharCodeForInsertMovie");
		return sqlSession.selectOne(NS+"selectCharCodeForInsertMovie", charKorName);
	}
	
	//관리자 영화 등록 : 모달을 사용해서 인물이름으로 등록할 감독코드와 감독이름 조회
	public List<Character> selectCharCodeForAddMovie(String charKorName) {
		logger.debug(" Dao selectCharCodeForAddMovie");
		return sqlSession.selectList(NS+"selectCharCodeForAddMovie", charKorName);
	}
	
	//영화 등록 : 모달에서 조회한 인물정보중 인물 코드로 폼에 넣을 선택한 인물코드조회
	public int choiceCharCode(int charCode) {
		logger.debug(" Dao choiceCharCode");
		return sqlSession.selectOne(NS+"choiceCharCode", charCode);
	}
	
	//영화등록
	public int insertMovie(Movie movie) {
		logger.debug(" Dao insertMovie");
		return sqlSession.insert(NS+"insertMovie", movie);
	}
	
	//관리자 영화조회
	public List<Movie> selectMovieList() {
		logger.debug(" Dao selectMovieList");
		return sqlSession.selectList(NS+"selectMovieList");
	}

	/************************************************************************************************************
	단가 관리 메서드 : 단가등록/단가수정
	************************************************************************************************************/		

	//단가등록
	public int insertCost(ScreenCost screenCost) {
		logger.debug(" Dao insertCost");
		return sqlSession.insert(NS+"insertCost", screenCost);
	}
	
	/************************************************************************************************************
	인물 관리 메서드 : 인물등록/인물리스트/인물상세/인물수정
	************************************************************************************************************/	
	
	//인물등록
	public int insertChar(Character character) {
		logger.debug(" Dao insertChar");
		return sqlSession.insert(NS+"insertChar", character);
	}
	
	//인물리스트조회
	public List<Character> selectCharacterList() {
		logger.debug(" Dao selectCharacterList");
		return sqlSession.selectList(NS+"selectCharacterList");
	}

}

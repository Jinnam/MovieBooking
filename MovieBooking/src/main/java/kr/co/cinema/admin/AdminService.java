package kr.co.cinema.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.HomeService;
import kr.co.cinema.dto.Admin;
import kr.co.cinema.dto.Branch;
import kr.co.cinema.dto.BranchAndScreen;
import kr.co.cinema.dto.BranchDayCount;
import kr.co.cinema.dto.Character;
import kr.co.cinema.dto.Member;
import kr.co.cinema.dto.Movie;
import kr.co.cinema.dto.MovieAndBranchDayCount;
import kr.co.cinema.dto.Screen;
import kr.co.cinema.dto.ScreenCost;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private HomeService homeService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	/************************************************************************************************************
	메인페이지 메서드
	************************************************************************************************************/

	//메인페이지 하단우측 영화별 예매율 순위
	public List<Movie> selectClientCount() {
		logger.debug(" Service selectClientCount get실행");
		List<Movie> selectClientCount = adminDao.selectClientCount();
		logger.debug("서비스 하단표 테스트 : "+selectClientCount);
		return selectClientCount;
	}

	//바그래프 지점 이름, 지점 코드, 매출합계 조회
	public List<Branch> selectBranchForBarGraph() {
		logger.debug(" Service selectBranchForBarGraph get실행");
		List<Branch> selectBranchForBarGraph = adminDao.selectBranchForBarGraph();
		logger.debug("서비스 바그래프 테스트 : "+selectBranchForBarGraph);
		return selectBranchForBarGraph;
	}
	
	//선그래프 총 매출액
	public int selectBranchCount() {
		logger.debug(" Service selectBranchCount get실행");
		return adminDao.selectBranchCount();
	}
	
	//선그래프 월 매출액
	public List<BranchDayCount> selectMonthBranchCount() {
		logger.debug(" Service selectMonthBranchCount get실행");
		List<BranchDayCount> selectMonthBranchCount = adminDao.selectMonthBranchCount();
		logger.debug("서비스 바그래프 테스트 : "+selectMonthBranchCount);
		return selectMonthBranchCount;
	}
	//원 그래프 데이터 상위3지점조회
	public List<MovieAndBranchDayCount> selectMovieCodeForCircleGraph() {
		logger.debug(" Service selectMovieCodeForCircleGraph get실행");
		return adminDao.selectMovieCodeForCircleGraph();
	}

	/************************************************************************************************************
	지점관리자 메서드 : 지점관리자등록/지점관리자조회/지점관리자수정/지점관리자삭제
	************************************************************************************************************/	

	//지점리스트 조회
	public List<Branch> selectBranchList() {
		logger.debug(" Service selectBranchList get실행");
		List<Branch> branchList = adminDao.selectBranchList();
		logger.debug(" Service selectBranchList"+branchList.toString());
		return branchList;
	}
	
	//지점 등록
	public int insertBranch(Branch branch) {
		logger.debug(" Service insertBranch post실행");
		return adminDao.insertBranch(branch);
	}
	
	//지점 수정하기 위한 조회
	public Branch selectBranchForUpdate(int brcCode) {
		logger.debug(" Service selectBranchForUpdate get실행");
		return adminDao.selectBranchForUpdate(brcCode);
	}

	//지점 수정
	public int updateBranch(Branch branch) {
		logger.debug(" Service updateBranch post실행");
		return adminDao.updateBranch(branch);	
	}
	
	//지점 탈퇴
	public int deleteBranch(int brcCode) {
		logger.debug(" Service deleteBranch get실행");
		return adminDao.deleteBranch(brcCode);
	}
	
	//지점관리자 리스트
	public List<Admin> selectAdminList() {
		logger.debug(" Service selectAdminList get실행");
		return adminDao.selectAdminList();
	}

	//지점관리자 등록
	public int insertAdmin(Admin admin) {
		logger.debug(" Service insertAdmin post실행");
		return adminDao.insertAdmin(admin);
	}
	//지점관리자 수정 전 권한과 아이디 조회
	public Admin selectAdminAuthAndId(Admin admin) {
		logger.debug(" Service selectAdminAuthAndId get실행");
		return adminDao.selectAdminAuthAndId(admin);
	}
	//지점관리자 수정
	public int updateAdmin(Admin admin) {
		logger.debug(" Service updateAdmin post실행");
		return adminDao.updateAdmin(admin);
	}
	
	//관리자 삭제
	public int deleteAdmin(Admin admId) {
		logger.debug(" Service deleteAdmin get실행");
		return adminDao.deleteAdmin(admId);
	}

	/************************************************************************************************************
	회원 관리 메서드 : 회원리스트조회
	************************************************************************************************************/
	
	//회원리스트 조회
	public List<Member> selectMemberList() {
		logger.debug(" Service selectMemberList get실행");
		List<Member> selectMemberList = adminDao.selectMemberList();
		return selectMemberList;
	}
	
	/************************************************************************************************************
	영화 관리 메서드 : 영화등록/영화리스트/영화상세/영화수정
	************************************************************************************************************/	
	
	//영화등록 전 인물이름으로 인물코드조회
	public String selectCharCodeForInsertMovie(String charKorName) {
		logger.debug(" Service selectCharCodeForInsertMovie post실행");
		return adminDao.selectCharCodeForInsertMovie(charKorName);
	}
	
	//관리자 영화 등록 : 모달을 사용해서 인물이름으로 등록할 감독코드와 감독이름 조회
	public List<Character> selectCharCodeForAddMovie(String charKorName) {
		logger.debug(" Service selectCharCodeForAddMovie post실행");
		return adminDao.selectCharCodeForAddMovie(charKorName);
	}
	
	//영화 등록 : 모달에서 조회한 인물정보중 인물 코드로 폼에 넣을 선택한 인물코드조회
	public String choiceCharCode(String charKorName) {
		logger.debug(" Service choiceCharCode post실행");
		return adminDao.choiceCharCode(charKorName);
	}
	
	//영화등록
	public int insertMovie(Movie movie) {
		logger.debug(" Service insertMovie post실행");
		return adminDao.insertMovie(movie);
	}
	
	//관리자 영화조회
	public List<Movie> selectMovieList() {
		logger.debug(" Service selectMovieList get실행");
		return adminDao.selectMovieList();
	}

	/************************************************************************************************************
	단가 관리 메서드 : 단가등록/단가수정
	************************************************************************************************************/		
	
	//단가등록
	public int insertCost(ScreenCost screenCost) {
		logger.debug(" Service insertCost post실행");
		return adminDao.insertCost(screenCost);
	}
	
	/************************************************************************************************************
	인물 관리 메서드
	************************************************************************************************************/	
	
	//인물등록
	public int insertChar(Character character) {
		logger.debug(" Service insertChar post실행");
		return adminDao.insertChar(character);
	}
	
	//인물리스트조회
	public List<Character> selectCharacterList() {
		logger.debug(" Service selectCharacterList get실행");
		return adminDao.selectCharacterList();
		
	}


}

package kr.co.cinema.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.dto.Admin;
import kr.co.cinema.dto.Branch;
import kr.co.cinema.dto.Character;
import kr.co.cinema.dto.Member;
import kr.co.cinema.dto.Movie;
import kr.co.cinema.dto.ScreenCost;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	//메인페이지 하단우측 영화별 예매율 순위
	public List<Movie> selectClientCount() {
		logger.debug(" Service selectClientCount get실행");
		List<Movie> selectClientCount = adminDao.selectClientCount();
		logger.debug(" Service selectClientCount"+selectClientCount.toString());
		return selectClientCount;
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
		return adminDao.selectMemberList();
	}
	
	/************************************************************************************************************
	영화 관리 메서드 : 영화등록/영화리스트/영화상세/영화수정
	 * @param charKorName 
	************************************************************************************************************/	
	
	//영화등록 전 인물이름으로 인물코드조회
	public String selectCharCodeForInsertMovie(String charKorName) {
		logger.debug(" Service selectCharCodeForInsertMovie post실행");
		return adminDao.selectCharCodeForInsertMovie(charKorName);
	}
	
	//영화등록
	public int insertMovie(Movie movie) {
		logger.debug(" Service insertMovie post실행");
		return adminDao.insertMovie(movie);
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
	인물 관리 메서드 : 인물등록/인물리스트/인물상세/인물수정
	************************************************************************************************************/	
	
	//인물등록
	public int insertChar(Character character) {
		logger.debug(" Service insertChar post실행");
		return adminDao.insertChar(character);
	}

	

}

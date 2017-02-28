package kr.co.cinema.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.Admin;
import kr.co.cinema.dto.Branch;
import kr.co.cinema.dto.Member;
import kr.co.cinema.dto.Movie;

@Repository
public class AdminDao {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "kr.co.cinema.admin.AdminMapper.";
	
	//메인페이지 하단우측 영화별 예매율 순위
	public List<Movie> selectClientCount() {
		logger.debug(" Dao selectClientCount");
		return sqlSession.selectList(NS+"selectClientCount");
	}
	
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

	//회원리스트 조회
	public List<Member> selectMemberList() {
		logger.debug(" Dao selectMemberList");
		return sqlSession.selectList(NS+"selectMemberList");
	}
	
	//영화등록전 인물이름으로 인물코드조회
	public String selectCharCodeForInsertMovie() {
		logger.debug(" Dao selectCharCodeForInsertMovie");
		return sqlSession.selectOne(NS+"selectCharCodeForInsertMovie");
	}
	//영화등록
	public int insertMovie(Movie movie) {
		logger.debug(" Dao insertMovie");
		return sqlSession.insert(NS+"insertMovie", movie);
	}

}

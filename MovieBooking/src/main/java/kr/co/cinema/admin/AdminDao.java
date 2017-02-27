package kr.co.cinema.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.Admin;
import kr.co.cinema.dto.Branch;
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
}

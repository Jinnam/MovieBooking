package kr.co.cinema.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}

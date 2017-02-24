package kr.co.cinema.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.Branch;

@Repository
public class AdminDao {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private SqlSessionTemplate sqlSession;
	//지점리스트 조회
	private final String NS = "kr.co.cinema.admin.AdminMapper.";
	public List<Branch> selectBranchList() {
		logger.debug(" Dao selectBranchList");
		return sqlSession.selectList(NS+"selectBranchList");
	}
}

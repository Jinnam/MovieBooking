package kr.co.cinema.admin.branch;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminBranchDao {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminBranchDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="kr.co.cinema.admin.branch.AdminBranchMapper.";

}

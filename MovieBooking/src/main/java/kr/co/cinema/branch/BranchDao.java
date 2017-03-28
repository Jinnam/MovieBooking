package kr.co.cinema.branch;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchDao {

private static final Logger logger = LoggerFactory.getLogger(BranchDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="kr.co.cinema.branch.BranchMapper.";
	
	// 지점 지역 이름 가져오기
	public List<String> selectBrnchLocal(){
		logger.debug("	selectBrnchLocal 진입");
		return sqlSession.selectList(NS+"selectBranchLocal");
	}
	
	// 지점 이름 가져오기
	public List<String> selectBrnchName(String branchLocal){
		logger.debug("	selectBrnchName 진입 branchLocal : "+branchLocal);
		return sqlSession.selectList(NS+"selectBranchName",branchLocal);
	}
	
	// 지점 이름 가져오기
	public Map<String, String> selectBrnchInfo(String branchName){
		logger.debug("	selectBrnchInfo 진입 branchName : "+branchName);
		return sqlSession.selectOne(NS+"selectBranchInfo",branchName);
	}
}

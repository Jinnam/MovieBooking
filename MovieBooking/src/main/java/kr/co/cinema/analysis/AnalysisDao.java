package kr.co.cinema.analysis;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.Branch;
import kr.co.cinema.payment.PaymentDao;

@Repository
public class AnalysisDao {

private static final Logger logger = LoggerFactory.getLogger(PaymentDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="kr.co.cinema.analisys.AnalisysMapper.";
	
	// 지점 지역 가져오기
	public Branch selectOneBranchInfo(){
		logger.debug("		selectOneBranchInfo() 진입");
		return sqlSession.selectOne(NS+"selectBranchInfo");
	}
}

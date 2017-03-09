package kr.co.cinema.analysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	// 지점 정보 가져오기
	public List<Branch> selectOneBranchInfo(){
		logger.debug("		selectOneBranchInfo() 진입");
		return sqlSession.selectList(NS+"selectBranchInfo");
	}
	
	// 지점별 영화 예매.매출 정보 가져오기
	public List<HashMap<String,Object>> selectListBrcDayCount(Map<String, String> map){
		logger.debug("		selectListBrcDayCount() 진입 map : "+map);
		return sqlSession.selectList(NS+"seleceBrcCntSale",map);
	}
}

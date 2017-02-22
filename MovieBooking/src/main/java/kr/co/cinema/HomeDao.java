package kr.co.cinema;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDao {
	private static final Logger logger = LoggerFactory.getLogger(HomeDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="kr.co.cinema.HomeMapper.";
	
	// 코드 생성을 위해 기존 코드 가져오는 메서드
	public String selectOneCode(Map<String, String> map){
		logger.debug("			selectOneCode() 진입 map : "+map);
		return sqlSession.selectOne(NS+"selectCode",map);
	}
	
	// 코드 생성을 위해 기존 스크린 코드 가져오는 메서드
	public String selectOneScreenCode(int brcCode){
		logger.debug("			selectOneScreenCode 진입 brcCode : "+brcCode);
		return sqlSession.selectOne(NS+"selectScreenCode", brcCode);
	}
	
}

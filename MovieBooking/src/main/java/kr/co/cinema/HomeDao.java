package kr.co.cinema;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="kr.co.cinema.HomeMapper.";
	
	// 코드 생성을 위해 기존 코드 가져오는 메서드
	public String selectOneCode(String kind){
		return sqlSession.selectOne(NS+"selectCode",kind);
		
	}
	
}

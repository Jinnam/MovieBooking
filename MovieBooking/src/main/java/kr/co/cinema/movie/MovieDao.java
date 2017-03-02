package kr.co.cinema.movie;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {
	private static final Logger logger = LoggerFactory.getLogger(MovieDao.class);
	
	@Autowired
	private SqlSessionTemplate session;
	
	private final String mapperNS="kr.co.cinema.movie.MovieMapper.";
	
	//박스오피스 리스트 가져오기
	public List<Map> selectListBoxOffice(){
		logger.debug("selectListBoxOffice 박스오피스 리스트 가져오기");
		return session.selectList(mapperNS+"selectListBoxOffice");		
	}

}

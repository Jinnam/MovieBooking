package kr.co.cinema.movie;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.Branch;

@Repository
public class MovieDao {
	private static final Logger logger = LoggerFactory.getLogger(MovieDao.class);
	
	@Autowired
	private SqlSessionTemplate session;
	
	private final String mapperNS="kr.co.cinema.movie.MovieMapper.";
	
	
	//좋아요 
	public int insertLikeMovie(String mId,String movCode){
		logger.debug("insertLikeMovie 좋아요");
		return session.insert(mapperNS+"insertLikeMovie",movCode);
	}
	
	//리플 & 평점 등록 reply 테이블
	public int insertReplyToReply(ReplyInputDto replyInputDto){
		logger.debug("insertReplyToReply 리플 등록 (reply)");
		return session.insert(mapperNS+"insertReplyToReply",replyInputDto);
	}
	//평점 누적 grade 테이블
	public int insertReplyToGrade(ReplyInputDto replyInputDto){
		logger.debug("insertReplyToGrade 평점누적 (grade테이블)");
		return session.insert(mapperNS+"insertReplyToGrade",replyInputDto);
	}	
	
	//평점 중복검사
	public Map<String,Object> selectOneReply(ReplyInputDto replyInputDto){
		logger.debug("selectOneReply 평점 중복검사");
		return session.selectOne(mapperNS+"selectOneReply",replyInputDto);
	}
	
	//영화코드로 영화 통계정보 가져오기
	public Map<String,String> selectOneMovieCountInfo(String movCode){
		logger.debug("selectOneMovieCountInfo 영화코드로 영화 통계정보 가져오기");
		return session.selectOne(mapperNS+"selectOneMovieCountInfo", movCode);		
	}
	
	//인물코드로 감독 필모그래피 가져오기
	public List<Map> selectListProduceFilmography(String charCode){
		logger.debug("selectListProduceFilmography 인물코드로 감독 필모그래피 가져오기");
		return session.selectList(mapperNS+"selectListProduceFilmography",charCode);		
	}	
	
	//인물코드로 필모그래피 가져오기
	public List<Map> selectListfilmography(String charCode){
		logger.debug("selectListfilmography 인물코드로 필모그래피 가져오기");
		return session.selectList(mapperNS+"selectListfilmography",charCode);		
	}
	
	//인물코드로 인물정보 가져오기
	public Map<String,String> selectOneCharInfo(String charCode){
		logger.debug("selectOneCharInfo 인물코드로 인물정보 가져오기");
		return session.selectOne(mapperNS+"selectOneCharInfo",charCode);		
	}
	
	//영화코드로 리플 가져오기
	public List<String> selectListReply(String movCode){
		logger.debug("selectListReply 영화코드로 리플 가져오기");
		return session.selectList(mapperNS+"selectListReply",movCode);
	}
	
	//영화코드로 스틸컷 이미지 가져오기
	public List<String> selectListStcImg(String movCode){
		logger.debug("selectListStcImg 영화코드로 스틸컷 이미지 가져오기");
		return session.selectList(mapperNS+"selectListStcImg",movCode);		
	}
	
	//영화코드로 인물 코드,이름 가져오기
	public List<Map> selectListCharNameCode(String movCode){
		logger.debug("selectListCharNameCode 영화코드로 인물 코드,이름 가져오기");
		return session.selectList(mapperNS+"selectListCharNameCode",movCode);	
	}
	
	//영화코드에 맞는 영화 가져오기
	public Map<String,String> selectOneMovieInfo(String movCode){
		logger.debug("selectOneMovieInfo 영화코드에 맞는 영화 가져오기");
		return session.selectOne(mapperNS+"selectOneMovieInfo",movCode);		
	}
	
	//상영예정 리스트 가져오기
	public List<Map> selectListExpected(){
		logger.debug("selectListExpected 상영예정 리스트 가져오기");
		return session.selectList(mapperNS+"selectListExpected");		
	}
	
	//최신개봉 리스트 가져오기
	public List<Map> selectListNewMovie(){
		logger.debug("selectListNewMovie 최신개봉 리스트 가져오기");
		return session.selectList(mapperNS+"selectListNewMovie");		
	}
	
	//박스오피스 리스트 가져오기
	public List<Map> selectListBoxOffice(){
		logger.debug("selectListBoxOffice 박스오피스 리스트 가져오기");
		return session.selectList(mapperNS+"selectListBoxOffice");		
	}
	
	//홈화면 박스오피스 리스트 가져오기
	public List<Map> selectListBoxOfficeHome(){
		logger.debug("selectListBoxOfficeHome 박스오피스 리스트 가져오기");
		return session.selectList(mapperNS+"selectListBoxOfficeHome");		
	}	

}

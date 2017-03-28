package kr.co.cinema.movie;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.HomeService;
import kr.co.cinema.dto.Branch;

@Service
public class MovieService {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	@Autowired
	MovieDao movieDao;
	@Autowired
	HomeService homeService;
	
	
	
	public int addReplyforMovie(ReplyInputDto replyInputDto){
		
		Map<String,Object> map = movieDao.selectOneReply(replyInputDto);		
		
		if(map==null){ //중복 안될경우
			replyInputDto.setRpCode(homeService.madeCode("reply")); //리플 코드 세팅
			movieDao.insertReplyToReply(replyInputDto); //리플 테이블에 리플 평점 등록
			movieDao.insertReplyToGrade(replyInputDto);	//평점 누적	
			return 1;	
		}else{ //중복될경우
			return 0;	
		}

	}
	
}

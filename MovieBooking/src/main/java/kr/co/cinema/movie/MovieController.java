package kr.co.cinema.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MovieController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	//클라이언트측 영화 리스트페이지
	@RequestMapping(value = "/clientMovieList", method = RequestMethod.GET)
	public String memberMovieList() {
		return "movie/clientMovieList";
	}	

	//클라이언트측 영화 상세페이지
	@RequestMapping(value = "/clientMovieDetail", method = RequestMethod.GET)
	public String memberMovieDetail() {
		return "movie/clientMovieDetail";
	}
	
	//클라이언트측 인물 상세페이지
	@RequestMapping(value = "/clientCharacterDetail", method = RequestMethod.GET)
	public String memberCharacterDetail() {
		return "movie/clientCharacterDetail";
	}
	
	
	
	
}

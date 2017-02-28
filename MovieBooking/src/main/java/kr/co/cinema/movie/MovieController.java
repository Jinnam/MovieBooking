package kr.co.cinema.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MovieController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	//클라이언트측 영화 리스트페이지 박스오피스
	@RequestMapping(value = "/clientMovieListBoxoffice1", method = RequestMethod.GET)
	public String clientMovieListBoxoffice() {
		return "movie/clientMovieListBoxoffice";
	}	

	//클라이언트측 영화 리스트페이지 최신개봉작
	@RequestMapping(value = "/clientMovieListNewMovie2", method = RequestMethod.GET)
	public String clientMovieListNewMovie() {
		return "movie/clientMovieListNewMovie";
	}	
	
	//클라이언트측 영화 리스트페이지 상영예정작
	@RequestMapping(value = "/clientMovieListExpected3", method = RequestMethod.GET)
	public String clientMovieListExpected() {
		return "movie/clientMovieListExpected";
	}		
	
	//클라이언트측 영화 상세페이지
	@RequestMapping(value = "/clientMovieDetail", method = RequestMethod.GET)
	public String memberMovieDetail() {
		return "movie/clientMovieDetail";
	}
	
	//클라이언트측 인물 상세페이지
	@RequestMapping(value = "/clientCharDetail", method = RequestMethod.GET)
	public String memberCharacterDetail() {
		return "movie/clientCharDetail";
	}
	
	
	
	
}

package kr.co.cinema.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MovieController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	MovieDao movieDao;
	@Autowired
	MovieService movieService;
	
	
	//좋아요
	@RequestMapping(value = "/addlikeMovie", method = RequestMethod.GET)
	public String addLikeMovie(@RequestParam(value="movCode")String movCode, HttpSession session,HttpServletRequest request) {
		logger.debug("addLikeMovie 좋아요");
		String mId=(String) session.getAttribute("id");	
		movieDao.insertLikeMovie(mId, movCode);
		return "redirect:"+request.getHeader("referer");
	}
	
	//평점 & 리플등록
	@RequestMapping(value = "/addReplyforMovie", method = RequestMethod.POST)
	public String addReplyforMovie(Model model,ReplyInputDto replyInputDto) {
		logger.debug("addReplyforMovie 평점 & 리플등록");
		int result = movieService.addReplyforMovie(replyInputDto);
		
		if(result == 1){ //정상등록
			return "redirect:clientMovieDetail?movCode="+replyInputDto.getMovCode();
		}else{ //중복
			model.addAttribute("url","clientMovieDetail?movCode="+replyInputDto.getMovCode());
			return "movie/falseReply";
		}	
	}		
	
	//클라이언트측 영화 리스트페이지 박스오피스
	@RequestMapping(value = "/clientMovieListBoxoffice1", method = RequestMethod.GET)
	public String clientMovieListBoxoffice(Model model) {
		logger.debug("clientMovieListBoxoffice 클라이언트측 영화 리스트페이지 박스오피스");
		model.addAttribute("boxList",movieDao.selectListBoxOffice()); //박스오피스 리스트 가져오기
		return "movie/clientMovieListBoxoffice";
	}	

	//클라이언트측 영화 리스트페이지 최신개봉작
	@RequestMapping(value = "/clientMovieListNewMovie2", method = RequestMethod.GET)
	public String clientMovieListNewMovie(Model model) {
		logger.debug("clientMovieListNewMovie 클라이언트측 영화 리스트페이지 최신개봉작");
		model.addAttribute("boxList",movieDao.selectListNewMovie()); //최신개봉 리스트 가져오기
		return "movie/clientMovieListNewMovie";
	}	
	
	//클라이언트측 영화 리스트페이지 상영예정작
	@RequestMapping(value = "/clientMovieListExpected3", method = RequestMethod.GET)
	public String clientMovieListExpected(Model model) {
		logger.debug("clientMovieListExpected 클라이언트측 영화 리스트페이지 상영예정작");
		model.addAttribute("boxList",movieDao.selectListExpected()); //상영예정 리스트 가져오기
		return "movie/clientMovieListExpected";
	}		
	
	//클라이언트측 영화 상세페이지
	@RequestMapping(value = "/clientMovieDetail", method = RequestMethod.GET)
	public String clientMovieDetail(Model model,@RequestParam(value="movCode") String movCode) {
		logger.debug("clientMovieDetail 클라이언트측 영화 상세페이지");
		model.addAttribute("movie",movieDao.selectOneMovieInfo(movCode)); //영화정보 세팅
		model.addAttribute("charList",movieDao.selectListCharNameCode(movCode)); //인물정보 세팅
		model.addAttribute("stcImgList",movieDao.selectListStcImg(movCode)); //스틸컷 이미지 세팅
		model.addAttribute("ticketCount",movieDao.selectOneMovieCountInfo(movCode)); //통계정보 세팅
		model.addAttribute("replyList",movieDao.selectListReply(movCode)); //리플및 유저 평점 세팅
		return "movie/clientMovieDetail";
	}
	
	//클라이언트측 인물 상세페이지
	@RequestMapping(value = "/clientCharDetail", method = RequestMethod.GET)
	public String clientCharDetail(Model model,@RequestParam(value="charCode") String charCode) {
		logger.debug("clientCharDetail 클라이언트측 인물 상세페이지");
		model.addAttribute("charInfo",movieDao.selectOneCharInfo(charCode)); //인물정보 세팅
		model.addAttribute("filmoList",movieDao.selectListfilmography(charCode)); //필모그래피
		model.addAttribute("produceFilmoList",movieDao.selectListProduceFilmography(charCode)); //감독 필모그래피
		return "movie/clientCharDetail";
	}
	
	//클라이언트측 이벤트 리스트
	@RequestMapping(value = "/clientEventList", method = RequestMethod.GET)
	public String clientEventList() {
		logger.debug("clientEventList 클라이언트측 이벤트 리스트페이지");
		return "movie/clientEventList";
	}
	
	
}

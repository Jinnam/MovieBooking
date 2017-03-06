package kr.co.cinema;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.cinema.dto.BranchDayCount;
import kr.co.cinema.dto.Screen;
import kr.co.cinema.dto.ScreenSchedule;
import kr.co.cinema.movie.MovieDao;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private HomeService homeService;
	@Autowired
	private MovieDao movieDao;
	
	//진남이가 쓰는 테이스 페이지 사용 ㄴㄴ
	@RequestMapping(value="/codeTest", method=RequestMethod.GET)
	public String codeTest(){
		return "payment/codeTest";
	}
	@RequestMapping(value="/codeTest", method=RequestMethod.POST)
	public String codeTest(@RequestParam("kind") String kind, Model model){
		logger.debug("/codeTest Post 진입");
		System.out.println("homeController kind : "+kind);
		
		// <상영일정 코드> 생성 테스트
		ScreenSchedule screenSchedule = new ScreenSchedule();
		screenSchedule.setScrCode("42101101");
		String returnSCSCCode = homeService.madeCode(screenSchedule);
		model.addAttribute("returnSCSCCode",returnSCSCCode);
		
		// <상영 코드> 생성 테스트
		Screen screen = new Screen();
		screen.setBrcCode(41101);
		String returnScreenCode = homeService.madeCode(screen);
		model.addAttribute("returnScreenCode",returnScreenCode);
		
		// <지점별 예매.매출 코드> 생성 테스트
		BranchDayCount branchDayCount = new BranchDayCount();
		branchDayCount.setBrcCode(41101);
		String returnBDCCode = homeService.madeCode(branchDayCount);
		model.addAttribute("returnBDCCode",returnBDCCode);

		// 일반 코드 생성테스트
		String resultCode = homeService.madeCode(kind);
		model.addAttribute("resultCode",resultCode);
		return "payment/codeTest";
	}
	
	//정빈이가쓰는 테스트 페이지 사용 ㄴㄴ
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "main";
	}
	
	//메인 캐러셀 페이지(iframe 하기위한)
	@RequestMapping(value = "/mainCarousel", method = RequestMethod.GET)
	public String mainCarousel() {	
		return "mainCarousel";
	}
	
	//메인 페이지
	@RequestMapping(value = "/movieMain", method = RequestMethod.GET)
	public String movieMain(Model model) {	
		model.addAttribute("boxList",movieDao.selectListBoxOfficeHome()); //박스오피스 리스트 가져오기		
		return "movieMain";
	}
	
	//준비중입니다 페이지
	@RequestMapping(value = "/beforeReady", method = RequestMethod.GET)
	public String beforeReady() {	
		return "beforeReady";
	}	
	
}

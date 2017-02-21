package kr.co.cinema;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	//진남이가 쓰는 테이스 페이지 사용 ㄴㄴ
	@RequestMapping(value="/codeTest", method=RequestMethod.GET)
	public String codeTest(){
		return "payment/codeTest";
	}
	@RequestMapping(value="/codeTest", method=RequestMethod.POST)
	public String codeTest(@RequestParam("kind") String kind, Model model){
		logger.debug("/codeTest Post 진입");
		System.out.println("homeController kind : "+kind);
		HomeService homeService = new HomeService();
		String resultCode = homeService.makeCode(kind);
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
	public String movieMain() {	
		return "movieMain";
	}
	
	//준비중입니다 페이지
	@RequestMapping(value = "/beforeReady", method = RequestMethod.GET)
	public String beforeReady() {	
		return "beforeReady";
	}	
	
}

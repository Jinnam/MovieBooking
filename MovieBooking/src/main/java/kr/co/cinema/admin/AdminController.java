package kr.co.cinema.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	//관리자 메인 페이지 : 메인으로 이동
	@RequestMapping(value="admin/adminMain", method=RequestMethod.GET)
	public String adminMain() {
		logger.debug("관리자 메인 페이지 get실행");
		return "admin/adminMain";
	}
}

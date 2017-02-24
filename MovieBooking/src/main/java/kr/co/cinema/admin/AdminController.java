package kr.co.cinema.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.cinema.dto.Branch;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	//관리자 메인 페이지 : 메인으로 이동
	@RequestMapping(value="adminMain", method=RequestMethod.GET)
	public String adminMain() {
		logger.debug("관리자 메인 페이지 get실행");
		return "admin/adminMain";
	}
	//지점리스트
	@RequestMapping(value="branchList", method=RequestMethod.GET)
	public String selectBranchList() {
		logger.debug("지점리스트 페이지 get실행");
		/*List<Branch> selectBranchList = service.*/
		return "admin/branchList";
	}
}

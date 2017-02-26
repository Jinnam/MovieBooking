package kr.co.cinema.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.cinema.dto.Branch;
import kr.co.cinema.dto.Movie;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	//관리자 메인 페이지 : 메인으로 이동
	@RequestMapping(value="adminMain", method=RequestMethod.GET)
	public String adminMain(Model model) {
		logger.debug(" Controller adminMain get실행");
		List<Movie> selectClientCount = adminService.selectClientCount();
		model.addAttribute("selectClientCount", selectClientCount);
		return "admin/adminMain";
	}
	
	//***지점 등록 페이지 연결만 해놓음
	@RequestMapping(value="branchInsert", method=RequestMethod.GET)
	public String insertBranch() {
		logger.debug(" Controller insertBranch get실행");
		return "admin/branchInsert";
	}
	
	//지점리스트 조회
	@RequestMapping(value="branchList", method=RequestMethod.GET)
	public String selectBranchList(Model model) {
		logger.debug(" Controller selectBranchList get실행");
		List<Branch> selectBranchList = adminService.selectBranchList();
		model.addAttribute("selectBranchList", selectBranchList);
		logger.debug(" Controller selectBranchList"+selectBranchList.toString());
		return "admin/branchList";
	}
	
	//***지점 탈퇴 페이지 연결만 해놓음
	@RequestMapping(value="branchDelete", method=RequestMethod.GET)
	public String deleteBranch() {
		logger.debug(" Controller deleteBranch get실행");
		return "admin/branchDelete";
	}
	
	//***지점관리자 등록 페이지 연결만 해놓음
	@RequestMapping(value="adminInsert", method=RequestMethod.GET)
	public String insertAdmin() {
		logger.debug(" Controller insertAdmin get실행");
		return "admin/adminInsert";
	}
	
	//***지점관리자 리스트 페이지 연결만 해놓음
	@RequestMapping(value="adminList", method=RequestMethod.GET)
	public String selectAdminList() {
		logger.debug(" Controller adminList get실행");
		return "admin/adminList";
	}
	
	//***지점관리자 삭제 페이지 연결만 해놓음
	@RequestMapping(value="adminDelete", method=RequestMethod.GET)
	public String deleteAdmin() {
		logger.debug(" Controller deleteAdmin get실행");
		return "admin/adminDelete";
	}
	
	//***관리자 회원조회 페이지 연결만 해놓음
	@RequestMapping(value="memberList", method=RequestMethod.GET)
	public String selectMemberList() {
		logger.debug(" Controller selectMemberList get실행");
		return "admin/memberList";
	}
}

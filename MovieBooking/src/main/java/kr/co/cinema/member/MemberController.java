package kr.co.cinema.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.cinema.dto.Member;
import kr.co.cinema.dto.NonMember;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;
	
	
	
	
	
	//마이페이지 회원 탈퇴 form
	@RequestMapping(value="/memberDelete", method=RequestMethod.GET)
	public String selectMemberDelete(){
		return "member/memberDelete";
	}
	
	//회원 개인정보 수정 action 미완성
	@RequestMapping(value="/memberModify", method=RequestMethod.POST)
	public String uadatetMemberModify(Model model, HttpSession session){
		String memId = (String) session.getAttribute("id");
		model.addAttribute("updateMembers", memberService.removeMember(memId));
		logger.debug(model.toString());
		return "movieMain";
	}
	
	//회원 개인정보 수정 form
	@RequestMapping(value="/memberModify", method=RequestMethod.GET)
	public String removeMember(Model model, HttpSession session){
		String memId = (String) session.getAttribute("id");
		model.addAttribute("memberModify", memberService.findOneMemberModify(memId));
		logger.debug(model.toString());
		return "member/memberModify";
	}
	//회원 영화 예매 리스트 미완성
	@RequestMapping(value="/bookedMovieLists", method=RequestMethod.GET)
	public String selectBookedMovieList(Model model, HttpSession session){
		String memId = (String) session.getAttribute("id");
		model.addAttribute("dayMovie", memberService.findListMemberMovieName(memId));
		logger.debug(model.toString());
		return "member/bookedMovieList";
	}
	
	//회원 개인정보 영화 예매(상영날짜)
	@RequestMapping(value="/bookedMovieList", method=RequestMethod.GET)
	public String selectBookedDayList(Model model, HttpSession session){
		String memId = (String) session.getAttribute("id");
		model.addAttribute("datePayment", memberService.findListMemberPayment(memId));
		logger.debug(model.toString());
		
		return "member/bookedMovieList";
	}
	
	//회원 개인정보 마일리지 페이지 
	@RequestMapping(value="/mileageList", method=RequestMethod.GET)
	public String selectMileageList(Model model,HttpSession session){
		String memId = (String) session.getAttribute("id");
		model.addAttribute("mlieagelist", memberService.findListMemberMileage(memId));
		return "member/mileageList";
	}
	
	//회원 개인정보 페이지  form 할지 안할지 결정해야함
	@RequestMapping(value="/memberDetail", method=RequestMethod.GET)
	public String selectMemberDetail(){
		return "member/memberDetail";
	}
	
	//비회원 가입 action
	@RequestMapping(value="/nonMemberInsert", method=RequestMethod.POST)
	public String insertNonMember(NonMember nonMember){
		memberService.addNonMember(nonMember);
		logger.debug(nonMember.toString());
		return "login/nonMemberInsert";
	}

	//비회원 가입 form
	@RequestMapping(value="/nonMemberInsert", method=RequestMethod.GET)
	public String insertNonMember(){
		return "login/nonMemberInsert";
	}
	
	//회원 로그인 action
	@RequestMapping(value="/memberLogin", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> memberLogin(Member member, HttpSession session){
		Map<String, String> map = new HashMap<String, String>();
		map.put("memId", member.getMemId());
		map.put("memPw", member.getMemPw());
		Map<String,Object> membersLogin = memberService.findOneMmemberLogin(map);
		System.out.println("membersLogin나오면찍힌거"+membersLogin);
		session.setAttribute("id", membersLogin.get("memId"));
		session.setAttribute("pw", membersLogin.get("memPw"));
		session.setAttribute("name", membersLogin.get("memName"));
		session.setAttribute("phone", membersLogin.get("memPhone"));
		session.setAttribute("mileages", membersLogin.get("memMileage"));
		session.setAttribute("joinday", membersLogin.get("memJoinDay"));
	//	logger.debug("return 값 : "+members.toString());
		
		return membersLogin;
	}
	
	//회원 로그아웃 action
	@RequestMapping(value="/logout")
	public String memberLogout(HttpSession session){
		session.invalidate();
		return "redirect:movieMain";
	}
		
	//회원 PW 찾기
	@RequestMapping(value="/memberFindPw", method=RequestMethod.POST)
	public @ResponseBody String memberFindPw(Member member){
		
		String returnPw = memberService.findOneMemberPwFind(member);
		logger.debug(member.toString());
		System.out.println(returnPw);
		return returnPw;
	}
	
	//회원 ID 찾기
	@RequestMapping(value="/memberFindId", method=RequestMethod.POST)
	public @ResponseBody String memberFindId(Member member){
		
		String returnId = memberService.findOneMemberIdFind(member);
		logger.debug(member.toString());
		System.out.println(returnId);
		
		return returnId;
	}
	
	//회원 ID / PW 찾기 form
	@RequestMapping(value="/memberFind", method=RequestMethod.GET)
	public String memberFind(){
		return "login/memberFind";
	}
	
	//회원가입 중복확인 action
	@RequestMapping(value = "/memeberOverlap", method = RequestMethod.POST)
	public @ResponseBody String overlapMember(@RequestParam(value = "id") String memId) {

		String returnMember = memberService.findOneMemberOverlap(memId);
		logger.debug(memId.toString());
		System.out.println(returnMember);
		return returnMember;
	}
	
	//회원가입 insert Action
	@RequestMapping(value="/memberInsert", method=RequestMethod.POST)
	public String insertMember(Member member){
		memberService.addMember(member);
		logger.info(member + "member확인");
		return "movieMain";
	}
	
	//회원가입 insert form
	@RequestMapping(value="/memberInsert", method=RequestMethod.GET)
	public String insertMember(){
		return "member/memberInsert";
	}
	//회원 약관 동의 form
	@RequestMapping(value="/memberProvision", method=RequestMethod.GET)
	public String memberProvision(){
		return "member/memberProvision";
	}
}

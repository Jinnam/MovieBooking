package kr.co.cinema.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.cinema.dto.Member;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;
	
	//비회원 가입 form
	@RequestMapping(value="/nonMemberInsert", method=RequestMethod.GET)
	public String insertNonMember(){
		return "login/nonMemberInsert";
	}
	
	//회원 로그인 action
	@RequestMapping(value="/memberLogin", method=RequestMethod.POST)
	public String memberLogin(Member member, HttpSession session){
		Map<String, String> map = new HashMap<String, String>();
		map.put("memId", member.getMemId());
		map.put("memPw", member.getMemPw());
		Member members = memberService.findOneMmemberLogin(map);
		logger.debug(members.toString());
		session.setAttribute("id", members.getMemId());
		session.setAttribute("pw", members.getMemPw());
		return "movieMain";
		
	}
	
	//회원 ID / PW 찾기 form
	@RequestMapping(value="/memberFind", method=RequestMethod.GET)
	public String memberFind(){
		return "login/memberFind";
	}
	
	//회원가입 insert Controller Action
	@RequestMapping(value="/memberInsert", method=RequestMethod.POST)
	public String insertMember(Member member){
		memberService.addMember(member);
		logger.info(member + "member확인");
		return "movieMain";
	}
	
	//회원가입 insert Controller form
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

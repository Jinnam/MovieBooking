package kr.co.cinema.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.cinema.dto.Member;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

	@Autowired
	private MemberService memberService;
	
	//회원가입 insert Controller Action
	@RequestMapping(value="/memberInsert", method=RequestMethod.POST)
	public String insertMember(Member member){
		memberService.addMember(member);
		logger.debug(member + "member확인");
		return "redirect:movieMain";
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

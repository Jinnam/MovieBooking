package kr.co.cinema.member;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.dto.Member;

@Service
public class MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private MemberDao memberdao;
	
	public String findOneMemberOverlap(String memId){
		logger.debug("중복확인 service" + memId);
		return memberdao.selectMemeberOverlap(memId);
	}
	
	
	
	
	
	
	//회원 아이디 찾기 select 시작
	public String findOneMemberIdFind(Member member){
		logger.debug("아이디 찾기 service" + member);
		return memberdao.selectOneIdFindMember(member);
	}
	//회원 아이디 찾기 select 종료	
	
	//회원 로그인 select 시작
	public Member findOneMmemberLogin(Map<String, String> map){
		logger.debug("login select service" + map);
		return memberdao.selectMemberLogin(map);
		
	}
	//회원 로그인 select 종료
	
	//회원가입 insert(add) 시작
	public int addMember(Member member){
		logger.debug("member insert service" + member);
		return memberdao.insertMember(member);
	}
	//회원가입 insert(add) 종료
}

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
	
	public Member findOneMmemberLogin(Map<String, String> map){
		logger.debug("login select service" + map);
		return memberdao.selectMemberLogin(map);
		
	}
	
	
	
	//회원가입 insert(add) 시작
	public int addMember(Member member){
		logger.info("member서비스확인" + member);
		return memberdao.insertMember(member);
	}
	//회원가입 insert(add) 종료
}

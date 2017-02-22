package kr.co.cinema.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.dto.Member;

@Service
public class MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
	@Autowired
	private MemberDao memberdao;
	
	//회원가입 insert(add) 시작
	public int addMember(Member member){
		logger.debug("member서비스확인" + member);
		return memberdao.insertMember(member);
	}
	//회원가입 insert(add) 종료
}

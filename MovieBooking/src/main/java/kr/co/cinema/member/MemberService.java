package kr.co.cinema.member;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.HomeService;
import kr.co.cinema.dto.Member;
import kr.co.cinema.dto.Mileage;
import kr.co.cinema.dto.NonMember;
@Service
public class MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private MemberDao memberdao;
	
	//비회원 코드를 불러오기 위한 autowired
	@Autowired
	private HomeService homeService;
	
	//마이페이지 회원의 마일리지 가져오기 시작
	public List<Mileage> findListMemberMileage(String memId){
		logger.debug("마이페이지 마일리지 가져오기 service");
		return memberdao.selectMemberMileage(memId);
	}
	//마이페이지 회원의 마일리지 가져오기 종료
	
	//한 회원 개인정보 가져오기 select 시작
	public String findOneMemberModify(String memId){
		logger.debug("한 회원 개인정보 service" + memId);
		return memberdao.selectMemeberOverlap(memId);
	}
	//한 회원 개인정보 가져오기 select 종료
	
	//비회원 가입 insert 시작
	public int addNonMember(NonMember nonMember){
		//homeService 에서 코드값 불러오기
		String nonMemberCode=homeService.madeCode("nonMember");
		nonMember.setNmemCode(nonMemberCode);
		return memberdao.insertNonMember(nonMember);
	}
	//비회원 가입 insert 종료
	
	//회원가입 중복확인 select 시작
	public String findOneMemberOverlap(String memId){
		logger.debug("중복확인 service" + memId);
		return memberdao.selectMemeberOverlap(memId);
	}
	//회원가입 중복확인 select 종료
	
	//회원 비밀번호 찾기 select 시작
	public String findOneMemberPwFind(Member member){
		logger.debug("비밀번호찾기 service" + member);
		return memberdao.selectOnePwFindMember(member);
	}
	//회원 비밀번호 찾기 select 종료
	
	//회원 아이디 찾기 select 시작
	public String findOneMemberIdFind(Member member){
		logger.debug("아이디 찾기 service" + member);
		return memberdao.selectOneIdFindMember(member);
	}
	//회원 아이디 찾기 select 종료	
	
	//회원 로그인 select 시작
	public Map<String, Object> findOneMmemberLogin(Map<String, String> map){
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

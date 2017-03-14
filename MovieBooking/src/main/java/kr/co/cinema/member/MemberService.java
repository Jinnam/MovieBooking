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
import kr.co.cinema.dto.MypageMemberReserve;
import kr.co.cinema.dto.NonMember;
import kr.co.cinema.dto.ScreenSchedule;
@Service
public class MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private MemberDao memberdao;
	
	//비회원 코드를 불러오기 위한 autowired
	@Autowired
	private HomeService homeService;
	
	//비회원 예매 확인
	public List<MypageMemberReserve> findListNonMemberReserve(NonMember nonMember){
		logger.debug(" 비회원 예매 확인 service **************** " + nonMember);
		return memberdao.selectNonMemberReserve(nonMember);
	}
	
	//회원탈퇴 처리
	public int removeOneMember(String memId){
		logger.debug("회원탈퇴 service : " + memId);
		return memberdao.updateMemberDelete(memId);
	}
	
	//회원 탈퇴 비밀번호 중복 체크
	public int findOneSelectMemberDeleteOverLap(String memId,String memPw){
		logger.debug("회원탈퇴 중복확인 service : " + memId);
		
		int returnResult=-1;
		String dbPW = memberdao.selectMemberOverLapDelete(memId);
		if(memPw.equals(dbPW)){
			returnResult=1;
		}else{
			returnResult=0;
		}
		System.out.println(memPw + " : 1첫째" +dbPW + " : 2번째");
		return returnResult;
		
	}
	
	//마이페이지 회원의 예매 가져오기 select
	public List<ScreenSchedule> findListMemberPayment(String memId){
		logger.debug("상영일자 service" + memId);
		return memberdao.selectPayment(memId);
	}
	
	//마이페이지 회원의 마일리지 가져오기 시작
	public List<Mileage> findListMemberMileage(String memId){
		logger.debug("마이페이지 마일리지 가져오기 service" + memId);
		return memberdao.selectMemberMileage(memId);
	}
	//마이페이지 회원의 마일리지 가져오기 종료
	
	//마이페이지 회원 개인정보 수정하기
	public int modifyMember(Member member){
		logger.debug("회원 수정 update service : " + member);
		return memberdao.modifyMemberUpdate(member);
	}
	
	//한 회원 개인정보 가져오기 select 시작
	public Member findOneMemberModify(String memId){
		logger.debug("한 회원 개인정보 service : " + memId);
		return memberdao.selectOneMemberModify(memId);
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
	
	//회원가입 중복확인 select 시작 문제
	public int findOneMemberOverlap(String memId){
		logger.debug("중복확인 service : " + memId);
		
		int returnResultMember=-1;
		String dbID = memberdao.selectMemeberOverlap(memId);
		
		if(memId.equals(dbID)){
			returnResultMember=1;
		}else{
			returnResultMember=0;
		}
		return  returnResultMember;
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

package kr.co.cinema.member;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.Member;
import kr.co.cinema.dto.Mileage;
import kr.co.cinema.dto.NonMember;

@Repository
public class MemberDao {

	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String Member_NS = "kr.co.cinema.member.MemberMapper.";
	
	//마이페이지 회원의 마일리지 가져오기 시작
	public List<Mileage> selectMemberMileage(String memId){
		logger.debug("마이페이지 마일리지 가져오기 dao");
		return sqlSessionTemplate.selectList(Member_NS + "selectMemberMileage", memId);
	}
	//마이페이지 회원의 마일리지 가져오기 종료
	
	//한 회원 개인정보 가져오기  시작 미완성ㄴ
	public String selectOneMemberModify(String memId){
		logger.debug("한 회원 개인정보 가져오기 dao" + memId);
		return sqlSessionTemplate.selectOne(Member_NS + "selectOneMemberModify", memId);
	}
	//한 회원 개인정보 가져오기  종료
	
	//비회원 가입 insert 시작
	public int insertNonMember(NonMember nonMember){
		logger.debug("비회원 가입 dao" + nonMember);
		return sqlSessionTemplate.insert(Member_NS + "insertNonMember", nonMember);
	}
	//비회원 가입 insert 종료
	
	//회원가입 중복확인 select 시작
	public String selectMemeberOverlap(String memId){
		logger.debug("중복확인 dao" + memId);
		return sqlSessionTemplate.selectOne(Member_NS + "selectMemeberOverlap", memId);
	}
	//회원가입 중복확인 select 종료
	
	//회원 비밀번호 찾기 select 시작
	public String selectOnePwFindMember(Member member){
		logger.debug("비밀번호찾기 dao" + member);
		return sqlSessionTemplate.selectOne(Member_NS + "selectOnePwFindMember", member);
	}
	//회원 비밀번호 찾기 select 종료
	
	//회원 아이디 찾기 select 시작
	public String selectOneIdFindMember(Member member){
		logger.debug("아이디찾기 dao" + member);
		return sqlSessionTemplate.selectOne(Member_NS + "selectOneIdFindMember", member);
	}
	//회원 아이디 찾기 select 종료	
	
	//회원 로그인 select 시작
	public Map<String, String> selectMemberLogin(Map<String, String> map){
		logger.debug("로그인 select dao" + map);
		return sqlSessionTemplate.selectOne(Member_NS + "selectMemberLogin", map);
	}
	//회원 로그인 select 종료
	
	//회원가입 insert 시작
	public int insertMember(Member member){
		logger.debug("회원가입 insert" + member);
		return sqlSessionTemplate.insert(Member_NS + "insertMember", member);
	}
	//회원가입 insert 종료
	
}

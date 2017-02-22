package kr.co.cinema.member;


import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.Member;

@Repository
public class MemberDao {

	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private final String Member_NS = "kr.co.cinema.member.MemberMapper.";
	
	
	//회원가입 insert 시작
	public int insertMember(Member member){
		logger.debug("memberDao확인" + member);
		return sqlSessionTemplate.insert(Member_NS + "insertMember", member);
	}
	//회원가입 insert 종료
	
}

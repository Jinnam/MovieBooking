package kr.co.cinema.payment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.DiscountInfo;

@Repository
public class PaymentDao {
	private static final Logger logger = LoggerFactory.getLogger(PaymentDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="kr.co.cinema.payment.PaymentMapper.";
	
	// 상영 단가 가져오기
	public List<DiscountInfo> selectListDiscountInfo(){
		
		return sqlSession.selectList(NS+"selectDiscountInfo");
	}
	
	// 결제시 영화 정보 가져오기
	public BookingInfo selectBookingInfo(String scsCode){
		
		return sqlSession.selectOne(NS+"selectMovieInfo", scsCode);
	}

}

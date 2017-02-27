package kr.co.cinema.payment;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.DiscountInfo;
import kr.co.cinema.dto.ScreenCost;

@Repository
public class PaymentDao {
	private static final Logger logger = LoggerFactory.getLogger(PaymentDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="kr.co.cinema.payment.PaymentMapper.";
	
	// 마일리지 정보 가져오기
	public Map<String, Integer> selectOneMileage(String memId){
		logger.debug("		selectOneMileage() 진입 memId : "+memId);
		return sqlSession.selectOne(NS+"selectMileage",memId);
	}
	
	// 할인 정보 가져오기
	public List<DiscountInfo> selectListDiscountInfo(){
		logger.debug("		selectListDiscountInfo() 진입");
		return sqlSession.selectList(NS+"selectDiscountInfo");
	}
	
	// 상영 단가 가져오기
	public List<ScreenCost> selectListScreenCost(){
		logger.debug("		selectListScreenCost() 진입");
		return sqlSession.selectList(NS+"selectScreenCost");
	}
	
	// 결제시 영화 정보 가져오기
	public BookingInfo selectBookingInfo(String scsCode){
		logger.debug("		selectBookingInfo() 진입");
		return sqlSession.selectOne(NS+"selectMovieInfo", scsCode);
	}

}

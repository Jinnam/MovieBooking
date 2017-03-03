package kr.co.cinema.payment;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.DiscountInfo;
import kr.co.cinema.dto.Mileage;
import kr.co.cinema.dto.Payment;
import kr.co.cinema.dto.ScreenCost;
import kr.co.cinema.dto.Seat;

@Repository
public class PaymentDao {
	private static final Logger logger = LoggerFactory.getLogger(PaymentDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="kr.co.cinema.payment.PaymentMapper.";
	
	
	// 마일리지 정보 등록
	public int insertMileage(Mileage mileage){
		logger.debug("		insertMileage() 진입 map : "+mileage);
		return sqlSession.insert(NS+"insertMileage", mileage);
		
	}
	// 결제 정보 등록
	public int insertPayment(Payment payment){
		logger.debug("		insertPayment() 진입 payment : "+payment);
		return sqlSession.insert(NS+"insertPayment",payment);
	}
	
	// 비회원 코드 가져오기
	public String selectOneNmemCode(String phone){
		logger.debug("		selectOneNmemCode() 진입 phone : "+phone);
		return sqlSession.selectOne(NS+"selectNmemCode", phone);
	}
	
	// 좌석 정보 가져오기
	public Seat selectOneSeatInfo(String seatCode){
		logger.debug("		selectOneSeatInfo() 진입 seatCode : "+seatCode);
		return sqlSession.selectOne(NS+"selectSeatInfo", seatCode);
	}
	
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

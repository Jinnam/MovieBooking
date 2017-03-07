package kr.co.cinema.payment;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.Analysis;
import kr.co.cinema.dto.BranchDayCount;
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
	
	
	//************** 결제 취소  **************
	
	// payment 상태 업데이트
	public int updatePaymentStatus(Map<String, String> map){
		logger.debug("		updatePaymentStatus() 진입 map : "+map);
		return sqlSession.update(NS+"updatePaymentStatus",map);
	}
	
	// 결제정보 가져오기
	public Map<String, Object> selectOnePaymentInfo(String pmtCode){
		logger.debug("		selectOnePaymentInfo() 진입 pmtCode : "+pmtCode);
		return sqlSession.selectOne(NS+"selectPaymentInfo",pmtCode);
	}
	
	// 좌석 (다:다)에서 좌석정보 가져오기
	public List<String> selectSeatInfo(String pmtCode){
		logger.debug("		selectSeatInfo() 진입 pmtCode : "+pmtCode);
		return sqlSession.selectList(NS+"selectSeatsInfo", pmtCode);
	}
	
	//************** 결제 후 등록 **************
	
	// 지점별 일일예매,매출 업데이트
	public int updateBrcDayCount(BranchDayCount branchDayCount){
		logger.debug("		updateBrcDayCount() 진입 branchDayCount : "+branchDayCount);
		return sqlSession.update(NS+"updateBrcDayCount", branchDayCount);
	}
	
	// 영화 코드 가져오기
	public int selectOneMovCode(String scsCode){
		logger.debug("		selectOneMovCode() 진입 scsCode : "+scsCode);
		return sqlSession.selectOne(NS+"selectMovcode",scsCode);
	}
	
	// Analysis 업데이트
	public int updateAnalysis(Analysis analysis){
		logger.debug("		updateAnalysis() 진입 analysis : "+analysis);
		return sqlSession.update(NS+"updateAnalysis", analysis);
	}
	
	// 비회원 정보 가져오기
	public Map<String, Object> selectOneNmemInfo(String nmemCode){
		logger.debug("		selectOneNmemInfo() 진입 nmemCode : "+nmemCode);
		return sqlSession.selectOne(NS+"selectNmemInfo",nmemCode);
	}
	
	// 좌석정보 업데이트
	public int updateSeat(Map<String, String> map){
		logger.debug("		updateSeat() 진입 seatCode : "+map);
		return sqlSession.update(NS+"updateSeat", map);
	}
	
	// 좌석(다:다) 등록
	public int insertSeats(Map<String, String> map){
		logger.debug("		insertSeats() 진입 map : "+map);
		return sqlSession.insert(NS+"insertSeats", map);
	}
	
	// 회원 마일리지 업데이트
	public int updateMemMileage(String memId){
		logger.debug("		updateMemMileage() 진입 memId : "+memId);
		return sqlSession.update(NS+"updateMemMileage", memId);
	}
	
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
	
	
	//************** 결제 화면 **************
	
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
	
	// 회원 정보 (마일리지, 생일) 정보 가져오기
	public Map<String, Object> selectOneMemInfo(String memId){
		logger.debug("		selectOneMemInfo() 진입 memId : "+memId);
		return sqlSession.selectOne(NS+"selectMemInfo",memId);
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
	public Map<String, Object> selectBookingInfo(String scsCode){
		logger.debug("		selectBookingInfo() 진입");
		return sqlSession.selectOne(NS+"selectMovieInfo", scsCode);
	}

}

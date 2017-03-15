package kr.co.cinema.management;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.cinema.dto.DiscountInfo;

@Repository
public class ManagementDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementDao.class);

	private final String NS = "kr.co.cinema.management.ManagementMapper.";
	
	//할인정보 등록
	public int insertDiscountInfo(DiscountInfo discountInfo) {
		logger.debug(" Dao insertDiscountInfo");
		return sqlSession.insert(NS+"insertDiscountInfo", discountInfo);
	}

	//할인정보 리스트
	public List<DiscountInfo> selectDiscountInfoList() {
		logger.debug(" Dao selectDiscountInfoList");
		return sqlSession.selectList(NS+"selectDiscountInfoList");
	}

}

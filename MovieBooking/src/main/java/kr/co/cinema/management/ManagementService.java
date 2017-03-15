package kr.co.cinema.management;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.dto.DiscountInfo;

@Service
public class ManagementService {
	@Autowired
	private ManagementDao managementDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementService.class);

	//할인정보 등록
	public int insertDiscountInfo(DiscountInfo discountInfo) {
		logger.debug(" Service insertDiscountInfo post실행");
		return managementDao.insertDiscountInfo(discountInfo);
		
	}

	//할인정보 리스트
	public List<DiscountInfo> selectDiscountInfoList() {
		logger.debug(" Service selectDiscountInfoList get실행");
		List<DiscountInfo> selectDiscountInfoList = managementDao.selectDiscountInfoList();
		return selectDiscountInfoList;
	}
}

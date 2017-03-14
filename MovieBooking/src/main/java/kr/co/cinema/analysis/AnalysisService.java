package kr.co.cinema.analysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.dto.Branch;

@Service
public class AnalysisService {
	private static final Logger logger = LoggerFactory.getLogger(AnalysisService.class);

	@Autowired
	private AnalysisDao analysisDao;
	
	//-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/ 영화 통계 관련 /-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/
		// 영화 이름 가져오기
		public List<HashMap<String, Object>> searchListMovie(String movName){
			logger.debug("		searchListMovie() 진입");
			String likeMovName="%"+movName+"%";
			return analysisDao.selectListMovie(likeMovName);		
		}
		
	//-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/ 지점 통계 관련 /-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/
	// 지점 정보 가져오기
	public List<Branch> searchOneBranchInfo(){
		logger.debug("		selectOneBranchInfo() 진입");
		return analysisDao.selectOneBranchInfo();
	}
	
	// 지점별 영화 예매.매출 정보 가져오기
	public List<HashMap<String, Object>> selectListBrcDayCount(Map<String, String> map){
		logger.debug("		selectListBrcDayCount() 진입");
		return analysisDao.selectListBrcDayCount(map);
	}
}

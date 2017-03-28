package kr.co.cinema.branch;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
	private static final Logger logger = LoggerFactory.getLogger(BranchService.class);

	@Autowired
	private BranchDao branchDao;
	
	// 지점 지역 이름 가져오기
	public List<String> searchBranchLocal(){
		logger.debug("	searchBranchLocal 진입");
		return branchDao.selectBrnchLocal();
	}
	
	// 지점 이름 가져오기
	public List<String> searchBranchName(String brnchLocal){
		logger.debug("	searchBranchName 진입 brnchLocal : "+brnchLocal);
		return branchDao.selectBrnchName(brnchLocal);
	}
	
	// 지점 정보 가져오기
	public Map<String,String> searchBranchInfo(String branchName){
		logger.debug("	searchBranchInfo 진입 branchName : "+branchName);
		return branchDao.selectBrnchInfo(branchName);
	}
	
}

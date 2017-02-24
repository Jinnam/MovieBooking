package kr.co.cinema.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.dto.Branch;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	//지점리스트 조회
	public List<Branch> selectBranchList() {
		logger.debug(" Service selectBranchList");
		List<Branch> branchList = adminDao.selectBranchList();
		logger.debug(" Service selectBranchList"+branchList.toString());
		return branchList;
	}

}

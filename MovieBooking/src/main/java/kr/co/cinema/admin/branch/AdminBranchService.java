package kr.co.cinema.admin.branch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminBranchService {

	private static final Logger logger = LoggerFactory.getLogger(AdminBranchService.class);
	
	@Autowired
	private AdminBranchDao adminBranchDao;
}

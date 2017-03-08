package kr.co.cinema.admin.branch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminBranchController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminBranchController.class);
	
	@Autowired
	private AdminBranchService adminBranchService;
}

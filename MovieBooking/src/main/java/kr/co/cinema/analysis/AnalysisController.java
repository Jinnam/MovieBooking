package kr.co.cinema.analysis;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.cinema.dto.Branch;

@Controller
public class AnalysisController {
	private static final Logger logger = LoggerFactory.getLogger(AnalysisController.class);

	@Autowired
	private AnalysisService analysisService;
	
	// 영화별 예매/매출조회 : 페이지이동
	@RequestMapping(value="analisysByMovie", method=RequestMethod.GET)
	public String selectAnalisysByMovie() {
		logger.debug(" selectAnalisysByMovie get실행");
		
		return "analisys/analisysByMovie";
	}
	
	// 지점별 예매/매출 : 페이지이동
	@RequestMapping(value="analisysByBranch", method=RequestMethod.GET)
	public String selectAnalisysByBranch(Model model) {
		logger.debug(" Controller selectAnalisysByMovie get실행");
		List<Branch> branchInfo = analysisService.searchOneBranchInfo();
		logger.debug("branchInfo : "+branchInfo.toString());
		model.addAttribute("branchInfo",branchInfo);
		return "analisys/analisysByBranch";
	}
	
	// 날짜별 예매,매출 : 페이지이동
	@RequestMapping(value="analisysByDate", method=RequestMethod.GET)
	public String selectAnalisysByDate() {
		logger.debug(" Controller selectAnalisysByDate get실행");
		return "analisys/analisysByDate";
	}
	
}

package kr.co.cinema.analysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.cinema.dto.Branch;

@Controller
public class AnalysisController {
	private static final Logger logger = LoggerFactory.getLogger(AnalysisController.class);

	@Autowired
	private AnalysisService analysisService;
	
	// 영화별 예매/매출조회 
	@RequestMapping(value="analisysByMovie", method=RequestMethod.GET)
	public String selectAnalisysByMovie() {
		System.out.println("왜 안되지???");
		logger.debug(" selectAnalisysByMovie get실행");
		
		return "analisys/analisysByMovie";
	}
	
	// 지점별 예매/매출 GET
	@RequestMapping(value="analisysByBranch", method=RequestMethod.GET)
	public String selectAnalisysByBranch(Model model) {
		logger.debug(" Controller selectAnalisysByMovie get실행");
		List<Branch> branchInfo = analysisService.searchOneBranchInfo();
		logger.debug("branchInfo : "+branchInfo.toString());
		model.addAttribute("branchInfo",branchInfo);
		return "analisys/analisysByBranch";
	}
	
	// 지점별 예매/매출 POST
	@RequestMapping(value="analisysByBranch", method=RequestMethod.POST)
	public @ResponseBody List<HashMap<String, Object>> selectAnalisysByBranch(@RequestParam("brcName") String brcName, 
																			@RequestParam("brcCntDate1") String brcCntDate1,
																			@RequestParam("brcCntDate2") String brcCntDate2){
		logger.debug(" selectAnalisysByBranch post 진입 : brcName : "+brcName+" brcCntDate1 : "+brcCntDate1+" brcCntDate2 : "+brcCntDate2);
		Map<String, String> map = new HashMap<String, String>();
		map.put("brcName", brcName);
		map.put("brcCntDate1", brcCntDate1);
		map.put("brcCntDate2", brcCntDate2);
		List<HashMap<String, Object>> returnList = analysisService.selectListBrcDayCount(map);
		logger.debug("selectAnalisysByBranch returnList : "+returnList.toString());
		return returnList; 
	}
	
	
	// 날짜별 예매,매출
	@RequestMapping(value="analisysByDate", method=RequestMethod.GET)
	public String selectAnalisysByDate() {
		logger.debug(" Controller selectAnalisysByDate get실행");
		return "analisys/analisysByDate";
	}
	
}

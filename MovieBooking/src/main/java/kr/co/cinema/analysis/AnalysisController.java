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
	
	
	//-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/ 영화 통계 관련 /-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/
	// 영화별 예매/매출조회 
	@RequestMapping(value="analisysByMovie", method=RequestMethod.GET)
	public String selectAnalisysByMovie(Model model) {
		logger.debug(" selectAnalisysByMovie get 진입");

		// 지점 목록 가져오기
		List<Branch> branchInfo = analysisService.searchOneBranchInfo();
		logger.debug("branchInfo : "+branchInfo.toString());
		model.addAttribute("branchInfo",branchInfo);
		
		return "analisys/analisysByMovie";
	}
	// ajax 영화 정보 가져오기
	@RequestMapping(value="selectMovInfo", method=RequestMethod.POST)
	public @ResponseBody List<HashMap<String, Object>> selectMovInfo(@RequestParam String movName){
		logger.debug("selectMovInfo ajax 진입 movName : "+movName);
		List<HashMap<String, Object>> movieNameList=analysisService.searchListMovie(movName);
		logger.debug("selectMovInfo ajax 가져온 movieNameList"+movieNameList.toString());
		return movieNameList;
	}
	
	// 예매/매출 정보 가져오기
	@RequestMapping(value="analisysByMovie", method=RequestMethod.POST)
	public @ResponseBody List<HashMap<String, Object>> selectAnaysisByMovie(@RequestParam String brcName,@RequestParam String cntKind,@RequestParam String selectedMovie){
		logger.debug(" selectAnalisysByMovie() Post 진입");
		Map<String, String> map = new HashMap<String, String>();
		map.put("brcName", brcName);
		map.put("cntKind", cntKind);
		map.put("movKorName", selectedMovie);
		List<HashMap<String, Object>> resultMap = analysisService.findOneSaleCnt(map);
		logger.debug("selectAnalisysByMovie() resultMap: "+resultMap);
		return resultMap;
	}
	
	//-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/ 지점 통계 관련 /-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/
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
	public @ResponseBody List<HashMap<String, Object>> selectAnalisysByBranch(@RequestParam String brcName,
																			@RequestParam String movKind,
																			@RequestParam String brcCntDate1,
																			@RequestParam String brcCntDate2){
		logger.debug(" selectAnalisysByBranch post 진입 : brcName : "+brcName+
				" brcCntDate1 : "+brcCntDate1+" brcCntDate2 : "+brcCntDate2);
		Map<String, String> map = new HashMap<String, String>();
		map.put("brcName", brcName);
		map.put("movKorName", movKind);
		map.put("brcCntDate1", brcCntDate1);
		map.put("brcCntDate2", brcCntDate2);
		List<HashMap<String, Object>> returnList = analysisService.findListBrcDayCount(map);
		logger.debug("selectAnalisysByBranch returnList : "+returnList.toString());
		return returnList; 
	}
	
	
	//-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/ 날짜별 통계 관련 /-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/
	// 날짜별 예매,매출
	@RequestMapping(value="analisysByDate", method=RequestMethod.GET)
	public String selectAnalisysByDate(Model model) {
		logger.debug(" selectAnalisysByDate get 진입");
		List<Branch> branchInfo = analysisService.searchOneBranchInfo();
		logger.debug("	selectAnalisysByDate() get branchInfo : "+branchInfo.toString());
		model.addAttribute("branchInfo",branchInfo);
		return "analisys/analisysByDate";
	}
	
	// 날짜별 예매,매출 ajax post
	@RequestMapping(value="analisysByDate", method=RequestMethod.POST)
	public @ResponseBody List<HashMap<String, Object>> selectAnalysisBydate(@RequestParam String brcName,
																			@RequestParam String brcCntDate1,
																			@RequestParam String brcCntDate2){
		logger.debug(" selectAnalisysByDate post 진입 brcName : "+brcName+" brcCntDate : "+brcCntDate1+", "+brcCntDate2);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("brcName", brcName);
		map.put("brcCntDate1", brcCntDate1);
		map.put("brcCntDate2", brcCntDate2);
		
		List<HashMap<String, Object>> resultMap = analysisService.findListDateCnt(map);
		
		return resultMap;
	}
}

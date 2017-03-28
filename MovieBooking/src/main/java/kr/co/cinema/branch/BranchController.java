package kr.co.cinema.branch;

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

@Controller
public class BranchController {
	private static final Logger logger = LoggerFactory.getLogger(BranchController.class);

	@Autowired
	private BranchService BranchService;
	
	// 지점 이름 가져오는 Ajax
    @RequestMapping(value = "/clientMovieAddr", method = RequestMethod.POST)
    public @ResponseBody List<String> addrsClientMovieAddr(@RequestParam String branchLocal) {
        logger.debug("addrClientMovieAddr Ajax branchLocal : "+branchLocal);
    	List<String> branchName = BranchService.searchBranchName(branchLocal);
    	
        return branchName;
    }
    
    // 지점 정보 가져오는 Ajax
    @RequestMapping(value="/clientBranchInfo", method=RequestMethod.POST)
    public @ResponseBody Map<String, String> addrBranchInfo(@RequestParam String branchName){
    	logger.debug("addrClientMovieAddr Ajax branchName : "+branchName);
    	Map<String,String> resultMap = BranchService.searchBranchInfo(branchName);
    	logger.debug("addrBranchInfo resultMap: "+resultMap);
    	return resultMap;
    }
    
    // 극장 페이지 이동 (지역 이름 가져옴)
    @RequestMapping(value = "/clientMovieAddr", method = RequestMethod.GET)
    public String addrClientMovieAddr(Model model) {
    	List<String> branchLocal = BranchService.searchBranchLocal();
    	model.addAttribute("branchLocal", branchLocal);
        logger.debug("addrClientMovieAddr 극장 ***********");
        return "movie/clientMovieAddr";
    }
    
    

	
}

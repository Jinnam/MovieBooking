package kr.co.cinema.admin.branch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.cinema.dto.BranchAndScreen;
import kr.co.cinema.dto.Screen;

@Controller
public class AdminBranchController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminBranchController.class);
	
	@Autowired
	private AdminBranchService adminBranchService;
	
		//상영관등록 : 페이지이동
		@RequestMapping(value="screenInsert", method=RequestMethod.GET)
		public String insertScreenView() {
			logger.debug(" Controller insertScreen get실행");
			return "screen/screenInsert";
		}
		
		//상영관 등록 : 상영관 등록에 필요한 지점 코드 조회하기
		@RequestMapping(value="selectBrcCode", method=RequestMethod.POST)
		public @ResponseBody String selectBrcCodeForInsertScreen(@RequestParam("brcName")String brcName) {
			logger.debug(" Controller selectBrcCodeForInsertScreen post실행");
			String selectBrcCode = adminBranchService.selectBrcCode(brcName);
			return selectBrcCode;
		}
		
		//상영관등록
		@RequestMapping(value="screenInsert", method=RequestMethod.POST)
		public String insertScreen(Screen screen) {
			logger.debug(" Controller insertScreen post실행");
			adminBranchService.insertScreen(screen);
			logger.debug(screen.toString());
			return "redirect:screenList";
		}
		
		//상영관리스트조회 : 페이지이동
		@RequestMapping(value="screenList", method=RequestMethod.GET)
		public String selectScreenList(Model model) {
			logger.debug(" Controller selectScreenList get실행");
			//상영관리스트 조회
			List<Screen> selectScreenList = adminBranchService.selectScreenList();
			model.addAttribute("selectScreenList", selectScreenList);
			return "screen/screenList";
		}
		
		//***상영관수정 : 페이지이동
		@RequestMapping(value="screenModify", method=RequestMethod.GET)
		public String updateScreen() {
			logger.debug(" Controller updateScreen get실행");
			return "screen/screenModify";
		}
		
		//***상영관삭제 : 페이지이동
		@RequestMapping(value="screenDelete", method=RequestMethod.GET)
		public String deleteScreen() {
			logger.debug(" Controller deleteScreen get실행");
			return "screen/screenDelete";
		}
		
		/************************************************************************************************************
		상영일정 관리 메서드
		************************************************************************************************************/	
		
		//상영일정등록 : 페이지이동
		@RequestMapping(value="screenScheduleInsert", method=RequestMethod.GET)
		public String insertScreenSchedule() {
			logger.debug(" Controller insertScreenSchedule get실행");
			return "screen/screenScheduleInsert";
		}
		
		//상영일정 등록 : 영화한글이름으로 영화 코드조회하기 AJAX
		@RequestMapping(value="selectMovieCode", method=RequestMethod.POST)
		public @ResponseBody String selectMovieCodeforInsertScrSchedule(@RequestParam("movKorName")String movKorName) {
			logger.debug(" Controller selectMovieCodeforInsertScrSchedule post실행");
			String selectMovieCode = adminBranchService.selectMovieCode(movKorName);
			return selectMovieCode;
		}
		
		//상영일정 등록 : 지점이름으로 지점코드, 상영관리스트 조회하기
		@RequestMapping(value="selectmovieAndScreens", method=RequestMethod.POST)
		public @ResponseBody List<BranchAndScreen> selectMovCodeAndScrNameList(@RequestParam("brcName")List<BranchAndScreen> movieAndScreens) {
			logger.debug(" Controller selectMovCodeAndScrNameList post실행");
			List<BranchAndScreen> selectmovieAndScreens = adminBranchService.selectmovieAndScreens(movieAndScreens);
			logger.debug(selectmovieAndScreens.toString());
			return selectmovieAndScreens;
		}
		
		//***상영일정리스트조회 : 페이지이동
		@RequestMapping(value="screenScheduleList", method=RequestMethod.GET)
		public String selectScreenScheduleList() {
			logger.debug(" Controller selectScreenScheduleList get실행");
			return "screen/screenScheduleList";
		}
		
		//***상영일정수정 : 페이지이동
		@RequestMapping(value="screenScheduleModify", method=RequestMethod.GET)
		public String updateScreenScheduleList() {
			logger.debug(" Controller updateScreenScheduleList get실행");
			return "screen/screenScheduleModify";
		}
}

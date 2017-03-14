package kr.co.cinema.screen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.cinema.dto.Screen;
import kr.co.cinema.dto.ScreenSchedule;

@SessionAttributes({"brcName","brcCode"})
@Controller
public class ScreenController {

private static final Logger logger = LoggerFactory.getLogger(ScreenController.class);
	
	@Autowired
	private ScreenService screenService;
	
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
			String selectBrcCode = screenService.selectBrcCode(brcName);
			return selectBrcCode;
		}
		
		//상영관등록
		@RequestMapping(value="screenInsert", method=RequestMethod.POST)
		public String insertScreen(Screen screen) {
			logger.debug(" Controller insertScreen post실행");
			screenService.insertScreen(screen);
			logger.debug(screen.toString());
			return "redirect:screenList";
		}
		
		//상영관리스트조회 : 페이지이동
		@RequestMapping(value="screenList", method=RequestMethod.GET)
		public String selectScreenList(Model model) {
			logger.debug(" Controller selectScreenList get실행");
			//상영관리스트 조회
			List<Screen> selectScreenList = screenService.selectScreenList();
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
		public String insertScreenSchedule(Model model,@ModelAttribute(value="brcCode") String brcCode) {
			logger.debug(" Controller insertScreenSchedule get실행 brcCode : "+brcCode);
			int brcCode1 =Integer.parseInt(brcCode);
			List<String> screenCost = screenService.searchListScreenCost();
			List<HashMap<String, Object>> screenInfo = screenService.findScreenInfo(brcCode1);
			logger.debug("screenInfo : "+screenInfo.toString());
			model.addAttribute("screenCost",screenCost);
			model.addAttribute("screenInfo",screenInfo);

			return "screen/screenScheduleInsert";
		}
		
		// 상영일정 등록 : 영화한글이름으로 영화 코드조회하기 AJAX
		@RequestMapping(value="selectMovieCode", method=RequestMethod.POST)
		public @ResponseBody Map<String, Object> selectMovieCodeforInsertScrSchedule(@RequestParam("movKorName")String movKorName) {
			logger.debug(" Controller selectMovieCodeforInsertScrSchedule post실행");
			Map<String, Object> selectMovieCode = screenService.selectMovieCode(movKorName);
			return selectMovieCode;
		}
		
		// 상영 일정 등록
		@RequestMapping(value="screenScheduleInsert", method=RequestMethod.POST)
		public String screenScheduleInsert(ScreenSchedule screenSchedule){
			logger.debug("screenScheduleInsert post 진입 screenSchedule: "+screenSchedule.toString());
			
			// 상영일정, 좌석 등록
			screenService.insertScs(screenSchedule);
			
			return "redirect:/screenScheduleInsert";
		}
		
		
		//***상영일정리스트조회 : 페이지이동
		@RequestMapping(value="screenScheduleList", method=RequestMethod.GET)
		public String selectScreenScheduleList(Model model) {
			logger.debug(" selectScreenScheduleList get 진입");
			
			List<HashMap<String, Object>> screenSchedule = screenService.searchScreenSchedule();
			model.addAttribute("screenSchedule",screenSchedule);
			return "screen/screenScheduleList";
		}
		
		//***상영일정수정 : 페이지이동
		@RequestMapping(value="screenScheduleModify", method=RequestMethod.GET)
		public String updateScreenScheduleList() {
			logger.debug(" Controller updateScreenScheduleList get실행");
			return "screen/screenScheduleModify";
		}
}

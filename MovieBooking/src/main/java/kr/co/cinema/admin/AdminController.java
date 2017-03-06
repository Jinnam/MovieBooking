package kr.co.cinema.admin;

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

import kr.co.cinema.dto.Admin;
import kr.co.cinema.dto.Branch;
import kr.co.cinema.dto.BranchAndScreen;
import kr.co.cinema.dto.BranchDayCount;
import kr.co.cinema.dto.Character;
import kr.co.cinema.dto.Member;
import kr.co.cinema.dto.Movie;
import kr.co.cinema.dto.MovieAndBranchDayCount;
import kr.co.cinema.dto.Screen;
import kr.co.cinema.dto.ScreenCost;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/************************************************************************************************************
	메인페이지 메서드
	************************************************************************************************************/
	
	//관리자 메인 페이지 : 메인으로 이동
	@RequestMapping(value="adminMain", method=RequestMethod.GET)
	public String adminMain(Model model) {
		logger.debug(" Controller adminMain get실행");
		//하단우측 표 데이터
		List<Movie> selectClientCount = adminService.selectClientCount();
		model.addAttribute("selectClientCount", selectClientCount);
		//바 그래프 데이터 상위5지점조회
		List<Branch> selectBranchForBarGraph = adminService.selectBranchForBarGraph();
		model.addAttribute("selectBranchForBarGraph", selectBranchForBarGraph);
		//원 그래프 데이터 상위3지점조회
		List<MovieAndBranchDayCount> MovieCodeForCircleGraph = adminService.selectMovieCodeForCircleGraph();
		model.addAttribute("MovieCodeForCircleGraph", MovieCodeForCircleGraph);
		//선그래프 매출 총 합계
		int selectBranchCount = adminService.selectBranchCount();
		model.addAttribute("selectBranchCount", selectBranchCount);
		//선그래프 월별 합계
		List<BranchDayCount> selectMonthBranchCount = adminService.selectMonthBranchCount();
		model.addAttribute("selectMonthBranchCount", selectMonthBranchCount);
		//집에서 log4j안됨 일단 이렇게 출력 log4j바꿀것
		logger.debug("컨트롤러 바그래프 :"+selectBranchForBarGraph);
		logger.debug("컨트롤러 우측하단표 : " + selectClientCount);
		logger.debug("컨트롤러 선그래프 매출 총 합계 : "+selectBranchCount);
		logger.debug("컨트롤러 선그래프 매출 월 합계 : "+selectMonthBranchCount);
		logger.debug("컨트롤러 원그래프 매출 월 합계 : "+MovieCodeForCircleGraph);
		return "admin/adminMain";
	}
	
	/************************************************************************************************************
	지점관리 메서드 : 지점등록/지점조회/지점수정/지점탈퇴
	************************************************************************************************************/
	
	//지점 등록 페이지(페이지이동)
	@RequestMapping(value="branchInsert", method=RequestMethod.GET)
	public String insertBranchView() {
		logger.debug(" Controller insertBranch get실행");
		return "admin/branchInsert";
	}
	
	//지점 등록 페이지(폼이동)
	@RequestMapping(value="branchInsert", method=RequestMethod.POST)
	public String insertBranch(Branch branch) {
		logger.debug(" Controller insertBranch post실행");
		adminService.insertBranch(branch);
		return "redirect:branchList";
	}
	
	//지점리스트 조회
	@RequestMapping(value="branchList", method=RequestMethod.GET)
	public String selectBranchList(Model model) {
		logger.debug(" Controller selectBranchList get실행");
		List<Branch> selectBranchList = adminService.selectBranchList();
		model.addAttribute("selectBranchList", selectBranchList);
		return "admin/branchList";
	}
	
	//지점 수정하기 위한 조회 페이지 하나의 지점 코드 값으로 지점의 내용을 조회
	@RequestMapping(value="branchModify", method=RequestMethod.GET)
	public String updateBranchList(Model model, int brcCode) {
		logger.debug(" Controller updateBranchList get실행");
		Branch selectBranchForUpdate = adminService.selectBranchForUpdate(brcCode);
		model.addAttribute("selectBranchForUpdate", selectBranchForUpdate);
		return "admin/branchModify";
	}
	
	//지점 수정 페이지
	@RequestMapping(value="branchModify", method=RequestMethod.POST)
	public String updateBranch(Branch branch) {
		logger.debug(" Controller updateBranch post실행");
		adminService.updateBranch(branch);
		return "redirect:branchList";
	}
	
	//지점 탈퇴 페이지
	@RequestMapping(value="branchDelete", method=RequestMethod.GET)
	public String deleteBranch(Model model, int brcCode) {
		logger.debug(" Controller deleteBranch get실행");
		adminService.deleteBranch(brcCode);
		return "redirect:branchList";
	}
	
	/************************************************************************************************************
	지점관리자 메서드 : 지점관리자등록/지점관리자조회/지점관리자수정/지점관리자삭제
	************************************************************************************************************/	
	
	//지점관리자 등록 페이지 등록 전 지점이름 및 지점코드조회
	@RequestMapping(value="adminInsert", method=RequestMethod.GET)
	public String selectBranchForAdminInsert(Model model) {
		logger.debug(" Controller selectBranchForAdminInsert get실행");
		List<Branch> selectBranchList = adminService.selectBranchList();
		model.addAttribute("selectBranchList", selectBranchList);
		return "admin/adminInsert";
	}
	
	//지점관리자 등록 페이지
	@RequestMapping(value="adminInsert", method=RequestMethod.POST)
	public String insertAdmin(Admin admin) {
		logger.debug(" Controller selectBranchForAdminInsert post실행");
		adminService.insertAdmin(admin);
		return "redirect:adminList";
	}
	
	//지점관리자 리스트 페이지 조회
	@RequestMapping(value="adminList", method=RequestMethod.GET)
	public String selectAdminList(Model model) {
		logger.debug(" Controller adminList get실행");
		List<Admin> selectAdminList = adminService.selectAdminList();
		model.addAttribute("selectAdminList", selectAdminList);
		return "admin/adminList";
	}
	
	//지점관리자 수정 전 페이지 권한, 지점이름 및 지점코드조회
	@RequestMapping(value="adminModify", method=RequestMethod.GET)
	public String selectBranchForUpdateAdmin(Model model, Admin admin) {
		logger.debug(" Controller selectBranchForUpdateAdmin get실행");
		List<Branch> selectBranchList = adminService.selectBranchList();
		Admin selectAdminAuthAndId = adminService.selectAdminAuthAndId(admin);
		model.addAttribute("selectBranchList", selectBranchList);
		model.addAttribute("selectAdminAuthAndId", selectAdminAuthAndId);
		return "admin/adminModify";
	}
	
	//지점관리자 수정 페이지
	@RequestMapping(value="adminModify", method=RequestMethod.POST)
	public String updateAdmin(Admin admin) {
		logger.debug(" Controller updateAdmin post실행");
		adminService.updateAdmin(admin);
		logger.debug(admin.toString());
		return "redirect:adminList";
	}
	
	//지점관리자 삭제 페이지 연결만 해놓음
	@RequestMapping(value="adminDelete", method=RequestMethod.GET)
	public String deleteAdmin(Admin admId) {
		logger.debug(" Controller deleteAdmin get실행");
		adminService.deleteAdmin(admId);
		return "redirect:adminList";
	}
	
	/************************************************************************************************************
	회원 관리 메서드 : 회원리스트조회
	************************************************************************************************************/
	
	//관리자 회원조회 페이지 조건부 조회 아직안됨
	@RequestMapping(value="memberList", method=RequestMethod.GET)
	public String selectMemberList(Model model) {
		logger.debug(" Controller selectMemberList get실행");
		List<Member> selectMemberList = adminService.selectMemberList();
		model.addAttribute("selectMemberList", selectMemberList);
		return "admin/memberList";
	}
	
	/************************************************************************************************************
	영화 관리 메서드 : 영화등록/영화리스트/영화상세/영화수정
	************************************************************************************************************/	

	//관리자 영화등록 페이지
	@RequestMapping(value="movieInsert", method=RequestMethod.GET)
	public String insertMovieView() {
		logger.debug(" Controller insertMovieView get실행");
		return "management/movieInsert";
	}
	
	//관리자 영화 등록전 감독이름으로 감독 코드 조회하기 리스트형식 아니라 하나의 코드만 조회
	@RequestMapping(value="selectCharcode", method=RequestMethod.POST)
	public @ResponseBody String selectCharcodeForInsertMovie(@RequestParam("charKorName")String charKorName) {
		logger.debug(" Controller selectCharcodeForInsertMovie post실행");
		String selectCharCodeForInsertMovie = adminService.selectCharCodeForInsertMovie(charKorName);
		return selectCharCodeForInsertMovie;
	}
	
	//관리자 영화등록 페이지
	@RequestMapping(value="movieInsert", method=RequestMethod.POST)
	public String insertMovie(Model model, Movie movie) {
		logger.debug(" Controller insertMovie post실행");
		adminService.insertMovie(movie);
		return "redirect:adminMovieList";
	}
	
	//관리자 영화조회 페이지 연결만 해놓음
	@RequestMapping(value="adminMovieList", method=RequestMethod.GET)
	public String selectMovieList(Model model) {
		logger.debug(" Controller selectMovieList get실행");
		//영화리스트 조회
		List<Movie> selectMovieList =  adminService.selectMovieList();
		model.addAttribute("selectMovieList", selectMovieList);
		logger.debug(selectMovieList.toString());
		return "management/adminMovieList";
	}
	
	//***관리자 영화상세조회 페이지 연결만 해놓음
	@RequestMapping(value="movieDetail", method=RequestMethod.GET)
	public String selectDetailMovie() {
		logger.debug(" Controller selectDetailMovie get실행");
		return "management/movieDetail";
	}
	
	//***관리자 영화상세조회 페이지 연결만 해놓음
	@RequestMapping(value="movieModify", method=RequestMethod.GET)
	public String updateMovie() {
		logger.debug(" Controller updateMovie get실행");
		return "management/movieModify";
	}
	
	/************************************************************************************************************
	인물 관리 메서드 : 인물등록/인물리스트/인물상세/인물수정
	************************************************************************************************************/	
	
	//관리자 인물등록 페이지
	@RequestMapping(value="characterInsert", method=RequestMethod.GET)
	public String insertCharacterView() {
		logger.debug(" Controller insertCharacterView get실행");
		return "management/characterInsert";
	}
	
	//인물등록
	@RequestMapping(value="characterInsert", method=RequestMethod.POST)
	public String insertCharacter(Character character) {
		logger.debug(" Controller insertCharacter post실행");
		adminService.insertChar(character);
		return "redirect:characterList";
	}
	
	//***관리자 인물조회리스트 페이지 연결만 해놓음
	@RequestMapping(value="characterList", method=RequestMethod.GET)
	public String selectCharacterList() {
		logger.debug(" Controller selectCharacterList get실행");
		return "management/characterList";
	}
	
	//***관리자 인물상세조회 페이지 연결만 해놓음
	@RequestMapping(value="characterDetail", method=RequestMethod.GET)
	public String selectCharacterDetail() {
		logger.debug(" Controller selectCharacterDetail get실행");
		return "management/characterDetail";
	}
	
	//***관리자 인물수정 페이지 연결만 해놓음
	@RequestMapping(value="characterModify", method=RequestMethod.GET)
	public String updateCharacter() {
		logger.debug(" Controller updateCharacter get실행");
		return "management/characterModify";
	}
	
	/************************************************************************************************************
	상영관 관리 메서드 : 상영관등록/상영관리스트/상영관수정/상영관삭제
	************************************************************************************************************/	
	
	//관리자 상영관등록 페이지
	@RequestMapping(value="screenInsert", method=RequestMethod.GET)
	public String insertScreenView() {
		logger.debug(" Controller insertScreen get실행");
		return "screen/screenInsert";
	}
	
	//상영관 등록 전 상영관 등록에 필요한 지점 코드 조회하기
	@RequestMapping(value="selectBrcCode", method=RequestMethod.POST)
	public @ResponseBody String selectBrcCodeForInsertScreen(@RequestParam("brcName")String brcName) {
		logger.debug(" Controller selectBrcCodeForInsertScreen post실행");
		String selectBrcCode = adminService.selectBrcCode(brcName);
		return selectBrcCode;
	}
	
	//상영관등록
	@RequestMapping(value="screenInsert", method=RequestMethod.POST)
	public String insertScreen(Screen screen) {
		logger.debug(" Controller insertScreen post실행");
		adminService.insertScreen(screen);
		logger.debug(screen.toString());
		return "redirect:screenList";
	}
	
	//***관리자 상영관리스트 페이지 연결만 해놓음
	@RequestMapping(value="screenList", method=RequestMethod.GET)
	public String selectScreenList() {
		logger.debug(" Controller selectScreenList get실행");
		return "screen/screenList";
	}
	
	//***관리자 상영관수정 페이지 연결만 해놓음
	@RequestMapping(value="screenModify", method=RequestMethod.GET)
	public String updateScreen() {
		logger.debug(" Controller updateScreen get실행");
		return "screen/screenModify";
	}
	
	//***관리자 상영관삭제 페이지 연결만 해놓음
	@RequestMapping(value="screenDelete", method=RequestMethod.GET)
	public String deleteScreen() {
		logger.debug(" Controller deleteScreen get실행");
		return "screen/screenDelete";
	}
	
	/************************************************************************************************************
	상영일정 관리 메서드 : 상영일정등록/상영일정리스트/상영일정수정
	************************************************************************************************************/	
	
	//***관리자 상영일정등록 페이지 연결만 해놓음
	@RequestMapping(value="screenScheduleInsert", method=RequestMethod.GET)
	public String insertScreenSchedule() {
		logger.debug(" Controller insertScreenSchedule get실행");
		return "screen/screenScheduleInsert";
	}
	
	//상영일정 등록 : 영화한글이름으로 영화 코드조회하기 AJAX
	@RequestMapping(value="selectMovieCode", method=RequestMethod.POST)
	public @ResponseBody String selectMovieCodeforInsertScrSchedule(@RequestParam("movKorName")String movKorName) {
		logger.debug(" Controller selectMovieCodeforInsertScrSchedule post실행");
		String selectMovieCode = adminService.selectMovieCode(movKorName);
		return selectMovieCode;
	}
	
	//상영일정 등록 : 지점이름으로 지점코드, 상영관리스트 조회하기
	@RequestMapping(value="selectmovieAndScreens", method=RequestMethod.POST)
	public @ResponseBody List<BranchAndScreen> selectMovCodeAndScrNameList(@RequestParam("brcName")List<BranchAndScreen> movieAndScreens) {
		logger.debug(" Controller selectMovCodeAndScrNameList post실행");
		List<BranchAndScreen> selectmovieAndScreens = adminService.selectmovieAndScreens(movieAndScreens);
		logger.debug(selectmovieAndScreens.toString());
		return selectmovieAndScreens;
	}
	
	//***관리자 상영일정리스트 페이지 연결만 해놓음
	@RequestMapping(value="screenScheduleList", method=RequestMethod.GET)
	public String selectScreenScheduleList() {
		logger.debug(" Controller selectScreenScheduleList get실행");
		return "screen/screenScheduleList";
	}
	
	//***관리자 상영일정리스트 페이지 연결만 해놓음
	@RequestMapping(value="screenScheduleModify", method=RequestMethod.GET)
	public String updateScreenScheduleList() {
		logger.debug(" Controller updateScreenScheduleList get실행");
		return "screen/screenScheduleModify";
	}
	
	/************************************************************************************************************
	단가 관리 메서드 : 단가등록/단가수정
	************************************************************************************************************/	
	
	//관리자 단가등록 페이지
	@RequestMapping(value="costInsert", method=RequestMethod.GET)
	public String insertCostView() {
		logger.debug(" Controller insertCostView get실행");
		return "management/costInsert";
	}
	
	//단가등록
	@RequestMapping(value="costInsert", method=RequestMethod.POST)
	public String insertCost(ScreenCost screenCost) {
		logger.debug(" Controller insertCost post실행");
		adminService.insertCost(screenCost);
		return "redirect:costInsert";
	}
	
	//***관리자 단가수정 페이지 연결만 해놓음
	@RequestMapping(value="costModify", method=RequestMethod.GET)
	public String updateCost() {
		logger.debug(" Controller updateCost get실행");
		return "management/costModify";
	}
	/************************************************************************************************************
	통계 관리 메서드 : 영화별 예매,매출/지점별 예매,매출/날짜별 예매,매출
	************************************************************************************************************/	
	
	//***관리자 영화별 예매,매출 페이지 연결만 해놓음
	@RequestMapping(value="analisysByMovie", method=RequestMethod.GET)
	public String selectAnalisysByMovie() {
		logger.debug(" Controller selectAnalisysByMovie get실행");
		return "analisys/analisysByMovie";
	}
	
	//***관리자 지점별 예매,매출 페이지 연결만 해놓음
	@RequestMapping(value="analisysByBranch", method=RequestMethod.GET)
	public String selectAnalisysByBranch() {
		logger.debug(" Controller selectAnalisysByMovie get실행");
		return "analisys/analisysByBranch";
	}
	
	//***관리자 날짜별 예매,매출 페이지 연결만 해놓음
	@RequestMapping(value="analisysByDate", method=RequestMethod.GET)
	public String selectAnalisysByDate() {
		logger.debug(" Controller selectAnalisysByDate get실행");
		return "analisys/analisysByDate";
	}
}

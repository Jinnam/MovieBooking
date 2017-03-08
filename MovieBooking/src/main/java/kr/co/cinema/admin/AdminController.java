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
		//집에서 log4j안됨 일단 이렇게 출력 log4j바꿀것 //System.out.println //logger.debug
		logger.debug("컨트롤러 바그래프 :"+selectBranchForBarGraph);
		logger.debug("컨트롤러 우측하단표 : " + selectClientCount);
		logger.debug("컨트롤러 선그래프 매출 총 합계 : "+selectBranchCount);
		logger.debug("컨트롤러 선그래프 매출 월 합계 : "+selectMonthBranchCount);
		logger.debug("컨트롤러 원그래프 매출 월 합계 : "+MovieCodeForCircleGraph);
		return "admin/adminMain";
	}
	
	/************************************************************************************************************
	지점관리 메서드
	************************************************************************************************************/
	
	//지점 등록 페이지이동
	@RequestMapping(value="branchInsert", method=RequestMethod.GET)
	public String insertBranchView() {
		logger.debug(" Controller insertBranch get실행");
		return "admin/branchInsert";
	}
	
	//지점 등록
	@RequestMapping(value="branchInsert", method=RequestMethod.POST)
	public String insertBranch(Branch branch) {
		logger.debug(" Controller insertBranch post실행");
		//지점 등록
		adminService.insertBranch(branch);
		return "redirect:branchList";
	}
	
	//지점 리스트 페이지이동
	@RequestMapping(value="branchList", method=RequestMethod.GET)
	public String selectBranchList(Model model) {
		logger.debug(" Controller selectBranchList get실행");
		//지점 리스트 조회
		List<Branch> selectBranchList = adminService.selectBranchList();
		model.addAttribute("selectBranchList", selectBranchList);
		return "admin/branchList";
	}
	
	//지점 수정하기 위한 조회 페이지이동
	@RequestMapping(value="branchModify", method=RequestMethod.GET)
	public String updateBranchList(Model model, int brcCode) {
		logger.debug(" Controller updateBranchList get실행");
		//하나의 지점 코드 값으로 지점의 내용을 조회
		Branch selectBranchForUpdate = adminService.selectBranchForUpdate(brcCode);
		model.addAttribute("selectBranchForUpdate", selectBranchForUpdate);
		return "admin/branchModify";
	}
	
	//지점 수정
	@RequestMapping(value="branchModify", method=RequestMethod.POST)
	public String updateBranch(Branch branch) {
		logger.debug(" Controller updateBranch post실행");
		//지점 수정
		adminService.updateBranch(branch);
		return "redirect:branchList";
	}
	
	//지점 탈퇴 페이지이동
	@RequestMapping(value="branchDelete", method=RequestMethod.GET)
	public String deleteBranch(Model model, int brcCode) {
		logger.debug(" Controller deleteBranch get실행");
		//지점 삭제 목록에서 지점 코드로 해당 행 삭제
		adminService.deleteBranch(brcCode);
		return "redirect:branchList";
	}
	
	/************************************************************************************************************
	지점관리자 메서드
	************************************************************************************************************/	
	
	//지점관리자 등록 페이지이동
	@RequestMapping(value="adminInsert", method=RequestMethod.GET)
	public String selectBranchForAdminInsert(Model model) {
		logger.debug(" Controller selectBranchForAdminInsert get실행");
		//등록 전 지점이름 및 지점코드조회 지점관리자 아이디 중복조회 아직 미구현
		List<Branch> selectBranchList = adminService.selectBranchList();
		model.addAttribute("selectBranchList", selectBranchList);
		return "admin/adminInsert";
	}
	
	//지점관리자 등록
	@RequestMapping(value="adminInsert", method=RequestMethod.POST)
	public String insertAdmin(Admin admin) {
		logger.debug(" Controller selectBranchForAdminInsert post실행");
		//지점관리자 등록
		adminService.insertAdmin(admin);
		return "redirect:adminList";
	}
	
	//지점관리자 리스트 페이지이동
	@RequestMapping(value="adminList", method=RequestMethod.GET)
	public String selectAdminList(Model model) {
		logger.debug(" Controller adminList get실행");
		//지점관리자 리스트조회
		List<Admin> selectAdminList = adminService.selectAdminList();
		model.addAttribute("selectAdminList", selectAdminList);
		return "admin/adminList";
	}
	
	//지점관리자 수정 전 페이지 권한, 지점이름 및 지점코드조회
	@RequestMapping(value="adminModify", method=RequestMethod.GET)
	public String selectBranchForUpdateAdmin(Model model, Admin admin) {
		logger.debug(" Controller selectBranchForUpdateAdmin get실행");
		//선택수정하기 위한 전체지점의 리스트조회
		List<Branch> selectBranchList = adminService.selectBranchList();
		model.addAttribute("selectBranchList", selectBranchList);
		//리스트에서 가져온 관리자 아이디값으로 관리자의 권한과 아이디조회
		Admin selectAdminAuthAndId = adminService.selectAdminAuthAndId(admin);
		model.addAttribute("selectAdminAuthAndId", selectAdminAuthAndId);
		return "admin/adminModify";
	}
	
	//지점관리자 수정
	@RequestMapping(value="adminModify", method=RequestMethod.POST)
	public String updateAdmin(Admin admin) {
		logger.debug(" Controller updateAdmin post실행");
		//지점관리자 수정
		adminService.updateAdmin(admin);
		return "redirect:adminList";
	}
	
	//지점관리자 삭제
	@RequestMapping(value="adminDelete", method=RequestMethod.GET)
	public String deleteAdmin(Admin admId) {
		logger.debug(" Controller deleteAdmin get실행");
		//지점관리자 삭제
		adminService.deleteAdmin(admId);
		return "redirect:adminList";
	}
	
	/************************************************************************************************************
	회원 관리 메서드
	************************************************************************************************************/
	
	//관리자 회원조회 페이지 조건부 조회 아직안됨
	@RequestMapping(value="memberList", method=RequestMethod.GET)
	public String selectMemberList(Model model) {
		logger.debug(" Controller selectMemberList get실행");
		//관리자 회원조회
		List<Member> selectMemberList = adminService.selectMemberList();
		model.addAttribute("selectMemberList", selectMemberList);
		return "admin/memberList";
	}
	
	/************************************************************************************************************
	영화 관리 메서드
	************************************************************************************************************/	

	//영화 등록 : 페이지이동
	@RequestMapping(value="movieInsert", method=RequestMethod.GET)
	public String insertMovieView() {
		logger.debug(" Controller insertMovieView get실행");
		return "management/movieInsert";
	}
	
	//영화 등록 : 모달을 사용해서 인물이름으로 등록할 감독코드와 감독정보 조회
	@RequestMapping(value="selectCharcodeUseModal", method=RequestMethod.POST)
	public @ResponseBody List<Character> selectCharCodeForAddMovie(@RequestParam("charKorName")String charKorName) {
		logger.debug(" Controller selectCharCodeForAddMovie post실행");
		List<Character> selectCharCodeForAddMovie = adminService.selectCharCodeForAddMovie(charKorName);
		return selectCharCodeForAddMovie;
	}
	
	//영화 등록 : 모달에서 조회한 인물정보중 인물 코드로 폼에 넣을 선택한 인물코드조회//수정중
	@RequestMapping(value="choiceCharCode", method=RequestMethod.POST)
	public @ResponseBody String choiceCharCode(@RequestParam("charKorName")String charKorName) {
		logger.debug(" Controller choiceCharCode post실행");
		String choiceCharCode = adminService.choiceCharCode(charKorName);
		return choiceCharCode;
	}
	
	//영화등록 : 감독이름으로 감독 코드 조회하기 리스트형식 아니라 하나의 코드만 조회
	@RequestMapping(value="selectCharCode", method=RequestMethod.POST)
	public @ResponseBody String selectCharcodeForInsertMovie(@RequestParam("charKorName")String charKorName) {
		logger.debug(" Controller selectCharcodeForInsertMovie post실행");
		String selectCharCodeForInsertMovie = adminService.selectCharCodeForInsertMovie(charKorName);
		return selectCharCodeForInsertMovie;
	}
	
	//영화등록
	@RequestMapping(value="movieInsert", method=RequestMethod.POST)
	public String insertMovie(Model model, Movie movie) {
		logger.debug(" Controller insertMovie post실행");
		adminService.insertMovie(movie);
		return "redirect:adminMovieList";
	}
	
	//영화조회
	@RequestMapping(value="adminMovieList", method=RequestMethod.GET)
	public String selectMovieList(Model model) {
		logger.debug(" Controller selectMovieList get실행");
		//영화리스트 조회
		List<Movie> selectMovieList =  adminService.selectMovieList();
		model.addAttribute("selectMovieList", selectMovieList);
		logger.debug(selectMovieList.toString());
		return "management/adminMovieList";
	}
	
	//***영화상세조회 페이지이동
	@RequestMapping(value="movieDetail", method=RequestMethod.GET)
	public String selectDetailMovie() {
		logger.debug(" Controller selectDetailMovie get실행");
		return "management/movieDetail";
	}
	
	//***영화수정 페이지이동
	@RequestMapping(value="movieModify", method=RequestMethod.GET)
	public String updateMovie() {
		logger.debug(" Controller updateMovie get실행");
		return "management/movieModify";
	}
	
	/************************************************************************************************************
	인물 관리 메서드
	************************************************************************************************************/	
	
	//인물등록 : 페이지 이동
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
	
	//인물리스트조회 : 페이지이동
	@RequestMapping(value="characterList", method=RequestMethod.GET)
	public String selectCharacterList(Model model) {
		logger.debug(" Controller selectCharacterList get실행");
		//인물리스트 조회
		List<Character> selectCharacterList = adminService.selectCharacterList();
		model.addAttribute("selectCharacterList", selectCharacterList);
		return "management/characterList";
	}
	
	//***인물상세조회 : 페이지이동
	@RequestMapping(value="characterDetail", method=RequestMethod.GET)
	public String selectCharacterDetail() {
		logger.debug(" Controller selectCharacterDetail get실행");
		return "management/characterDetail";
	}
	
	//***인물수정 : 페이지이동
	@RequestMapping(value="characterModify", method=RequestMethod.GET)
	public String updateCharacter() {
		logger.debug(" Controller updateCharacter get실행");
		return "management/characterModify";
	}
	
	/************************************************************************************************************
	단가 관리 메서드
	************************************************************************************************************/	
	
	//단가등록 : 페이지이동
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
	//단가등록 : 페이지이동
	@RequestMapping(value="costList", method=RequestMethod.GET)
	public String selectCostList() {
		logger.debug(" Controller insertCost get실행");
		return "management/costList";
	}
	//단가수정 : 페이지이동
	@RequestMapping(value="costModify", method=RequestMethod.GET)
	public String updateCost() {
		logger.debug(" Controller updateCost get실행");
		return "management/costModify";
	}
	/************************************************************************************************************
	통계 관리 메서드
	************************************************************************************************************/	
	
	//***영화별 예매/매출조회 : 페이지이동
	@RequestMapping(value="analisysByMovie", method=RequestMethod.GET)
	public String selectAnalisysByMovie() {
		logger.debug(" Controller selectAnalisysByMovie get실행");
		return "analisys/analisysByMovie";
	}
	
	//***지점별 예매/매출 : 페이지이동
	@RequestMapping(value="analisysByBranch", method=RequestMethod.GET)
	public String selectAnalisysByBranch() {
		logger.debug(" Controller selectAnalisysByMovie get실행");
		return "analisys/analisysByBranch";
	}
	
	//***날짜별 예매,매출 : 페이지이동
	@RequestMapping(value="analisysByDate", method=RequestMethod.GET)
	public String selectAnalisysByDate() {
		logger.debug(" Controller selectAnalisysByDate get실행");
		return "analisys/analisysByDate";
	}
}

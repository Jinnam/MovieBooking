package kr.co.cinema.admin;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import kr.co.cinema.dto.Admin;
import kr.co.cinema.dto.Branch;
import kr.co.cinema.dto.BranchDayCount;
import kr.co.cinema.dto.Character;
import kr.co.cinema.dto.Member;
import kr.co.cinema.dto.Movie;
import kr.co.cinema.dto.MovieAndBranchDayCount;
import kr.co.cinema.dto.ScreenCost;

@SessionAttributes({"brcName","brcCode"})
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
	
	//바그래프 바데이터(매출)조회
	@RequestMapping(value="selectBranchCntSaleTatal", method=RequestMethod.GET)
	public @ResponseBody Map<Integer,List<Integer>> mainGraph(@RequestParam int[] movCode) {
		
		logger.debug("mainGraph : movCode: "+movCode.toString());
		//바그래프 바데이터(매출)조회
		Map<Integer,List<Integer>> resultMap = adminService.selectBranchCntSaleTatal(movCode);
		logger.debug("매출데이터 : "+resultMap);
		return resultMap;
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
	
	//지점관리자 등록 전 중복 체크
	@RequestMapping(value="selectOverLapCheck", method=RequestMethod.POST)
	public @ResponseBody String selectOverLapCheck(@RequestParam("admId")String admId) {
		logger.debug(" Controller selectOverLapCheck post실행");
		//중복아이디 조회
		String selectOverLapCheck = adminService.selectOverLapCheck(admId);
		if(selectOverLapCheck != null) {
			logger.debug(" 나갈 id값 : "+selectOverLapCheck.toString());
			//넘어갈때 공백
		}
		return selectOverLapCheck;
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
		//인물이름으로 인물코드와 인물이름 조회
		List<Character> selectCharCodeForAddMovie = adminService.selectCharCodeForAddMovie(charKorName);
		logger.debug(selectCharCodeForAddMovie.toString());
		return selectCharCodeForAddMovie;
	}
	
	//영화 등록 : 모달에서 조회한 인물정보 중 인물 코드로 폼에 넣을 선택한 인물코드조회//쓰는메서드인지 체크해볼것
	@RequestMapping(value="choiceCharCode", method=RequestMethod.POST)
	public @ResponseBody int choiceCharCode(@RequestParam("charKorName")int charCode) {
		logger.debug(" Controller choiceCharCode post실행");
		//모달에 띄운 리스트중 한의 인물이름 선택한 인물코드조회
		int choiceCharCode = adminService.choiceCharCode(charCode);
		return choiceCharCode;
	}
	
	//영화 등록 : 감독이름으로 감독 코드 조회하기 리스트형식 아니라 하나의 코드만 조회
	@RequestMapping(value="selectCharCode", method=RequestMethod.POST)
	public @ResponseBody String selectCharcodeForInsertMovie(@RequestParam("charKorName")String charKorName) {
		logger.debug(" Controller selectCharcodeForInsertMovie post실행");
		String selectCharCodeForInsertMovie = adminService.selectCharCodeForInsertMovie(charKorName);
		return selectCharCodeForInsertMovie;
	}
	
	//영화 등록
	@RequestMapping(value="movieInsert", method=RequestMethod.POST)
	public String insertMovie(Movie movie) {
		logger.debug(" Controller insertMovie post실행 movie : "+movie);
		//영화등록
		adminService.insertMovie(movie);
		//인물(배우)등록 등록된 영화 코드가져오기
		adminService.insertCharacters(movie, movie.getMovCode());
		//스틸컷추가 등록된 영화 코드가져오기
		adminService.insertSteelCut(movie, movie.getMovCode());
		//통계초기화 등록된 영화 코드가져오기
		adminService.analisysReset(movie.getMovCode());
		//평점초가화 등록된 영화 코드가져오기
		adminService.gradeReset(movie.getMovCode());
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
	
	//단가조회 : 페이지이동
	@RequestMapping(value="costList", method=RequestMethod.GET)
	public String selectCostList(Model model) {
		logger.debug(" Controller insertCost get실행");
		List<ScreenCost> selectCostList = adminService.selectCostList();
		model.addAttribute("selectCostList", selectCostList);
		return "management/costList";
	}
	
	//단가수정 : 페이지이동
	@RequestMapping(value="costModify", method=RequestMethod.GET)
	public String updateCost() {
		logger.debug(" Controller updateCost get실행");
		return "management/costModify";
	}
	
	/************************************************************************************************************
	로그인 관리 메서드
	************************************************************************************************************/	
	
	// 로그인 페이지 이동
	@RequestMapping(value="/adminLogin", method=RequestMethod.GET)
	public String adminLogin(){
		logger.debug("	adminLogin() get 진입");
		return "login/adminLogin";
	}
	
	// 로그인 가입 여부 판단
	@RequestMapping(value="/adminLogin", method=RequestMethod.POST)
	public @ResponseBody String adminLogin(Model model,@RequestParam String adminId, @RequestParam String adminPw){
		logger.debug("	adminLogin() post 진입 adminId : "+adminId+" adminPw : "+adminPw);
		
		String loginResult = "";		// 로그인결과 반환할 변수선언 & 초기화
		
		Map<String, Object> adminInfo = adminService.findOneAdminInfo(adminId);		// 입력한 id 값으로 admin정보 가져오기
		if(adminInfo != null){									// 아이디가 존재할 경우
			logger.debug("adminInfo"+adminInfo.toString());
			String dbPw = (String)adminInfo.get("admPw");		// 가져온 정보에서 비밀번호 가져오기
			String brcName = (String)adminInfo.get("brcName");	// 가져온 정보에서 지점이름 가져오기
			int brcCode =  (int) adminInfo.get("brcCode"); 		// 가져온 정보에서 지점코드 가져오기
			if(adminPw.equals(dbPw)){							// 비밀번호 비교
				model.addAttribute("brcName",brcName);			// @SessionAttributes 이용하기 위해 모델에 값 셋팅
				model.addAttribute("brcCode",brcCode);			// @SessionAttributes 이용하기 위해 모델에 값 셋팅
				loginResult="success";							// 로그인 성공시 반환 값
			}else{
				loginResult="noPw";								// 비밀번호가 다를 경우 반환 할 값
			}
		}else{
			loginResult="noId";									// 아이디가 다를 경우 반환 할 값
		}
		
		return loginResult;
	}
	
	// 로그아웃
	@RequestMapping(value="adminLogout")
	public String adminLogout(SessionStatus session){
		session.setComplete();				// 세션 만료시키기
		return "redirect:adminLogin";
		
	}
}

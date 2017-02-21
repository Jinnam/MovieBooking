package kr.co.cinema;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.cinema.dto.BranchDayCount;
import kr.co.cinema.dto.Screen;

@Service
public class HomeService {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeService.class);
	
	@Autowired
	private HomeDao homeDao;
	
	//******코드(PK) 생성 시작******
	
	static private String resultCode = "";							// 반환할 코드 초기화
	// 코드 생성하는 메서드(비회원,마일리지,한줄평/평점,좌석(다:다))
	public String makeCode(String kind){
		logger.debug("HomeService makeCode() 진입");
		
		System.out.println("HomeService makeCode() kind : "+kind);
		String getCode = homeDao.selectOneCode(kind);		// db에서 마지막으로 입력된 코드 값 가져오기
		logger.debug("HomeService makeCode() getCode : "+getCode);
		String getFirst= getCode.substring(0,2);			// 코드에서 고유번호 추출
		String getDate = getCode.substring(2, 8);			// 코드에서 날짜 추출
		String getNum= getCode.substring(8);				// 코드에서 숫자 추출
		
		System.out.println("getCode : "+getCode);
		System.out.println("getFirst : "+getFirst);
		System.out.println("getDate : "+getDate);
		System.out.println("getNum : "+getNum);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");		// yyMMdd 형식으로  포맷지정
		Date currentDate = new Date();								// 현재 날짜
		String dDay=sdf.format(currentDate);						// 현재 날자를 yyMMdd로 바꿈
		System.out.println("오늘 날짜 : "+dDay);
		
		if(getDate.equals(dDay)){									// 코드에서 추출한 날짜와 현재 날짜 비교 후 같으면
			System.out.println("날짜 값이 같음");
			int intNum = Integer.parseInt(getNum);					// 코드에서 추출한 숫자를 int형으로 변환
			System.out.println("intNum : "+intNum);
			resultCode =getDate + Integer.toString(intNum+1);		// 숫자 1 증가
			System.out.println("같을때 resultCode : "+resultCode);
		}else{														// 코드에서 추출한 날짜와 현재 날짜 가 다르면
			System.out.println("날짜 값이 다름");
			switch(kind){											// 입력값에 따른 스위치 문
				case "nonMember" :									// 입력값이 nonMember이면
					resultCode = "13"+dDay+"10001";					// 고유번호 +현재날짜+숫자 초기화
					break;
				case "mileage" :
					resultCode = "14"+dDay+"10001";
					break;
				case "reply" :
					resultCode = "31"+dDay+"100001";
					break;
				case "replyRecommend" :
					resultCode = "32"+dDay+"100001";
					break;
				case "seats" :
					resultCode = "45"+dDay+"1000001";
					break;
				default : break;
				}
		
		}
		System.out.println("최종 resultCode : "+resultCode);
		return resultCode;
	}
	// screen code 만들기
	public String madeCode(Screen screen){
		
		int getBrcCode=screen.getBrcCode();											// 입력값에서 brcCode 가져오기
		String getScreenCode = homeDao.selectOneScreenCode(screen.getBrcCode());	// brcCode에 해당하는 최신의 screenCode 가져오기  42+101+101
		String screenNum = getScreenCode.substring(5);								// screenCode에서 번호 추출
		int resultNum = Integer.parseInt(screenNum)+1;								// 추출한 번호에 +1로 다음번호 생성
		System.out.println("resultNum : "+resultNum);
		String brcCode = Integer.toString(getBrcCode);								// brcCode String형으로 변환
		String brcNum= brcCode.substring(2);										// brcCode에서 지점 번호만 추출
		System.out.println("brcNum : "+brcNum);

		resultCode = "42"+brcNum+resultNum;											// 반환 코드 생성
		System.out.println(resultCode);

		return resultCode;
	}
	
	public String madeCode(BranchDayCount branchDayCount){
		
		return null;
	}

}

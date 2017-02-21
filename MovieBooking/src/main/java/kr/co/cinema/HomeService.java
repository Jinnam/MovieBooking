package kr.co.cinema;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HomeService {
	@Autowired
	private HomeDao homeDao;
	
	
	String resultCode = "";									// 반환할 코드 초기화
	// 코드 생성하는 메서드(비회원,마일리지,한줄평/평점
	public String makeCode(String kind){
		
		String getCode = homeDao.selectOneCode(kind);		// db에서 마지막으로 입력된 코드 값 가져오기
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
					
				default : break;
				}
		
		}
		System.out.println("최종 resultCode : "+resultCode);
		return resultCode;
	}


}

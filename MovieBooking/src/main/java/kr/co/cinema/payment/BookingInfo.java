package kr.co.cinema.payment;

// 영화 결제 정보 담은 dto
public class BookingInfo {
	
	private String scsCode;				// 상영코드
	private String movKorName;			// 영화 한글 제목
	private String movGrade;			// 영화 등급
	private String movRunningTime;		// 상영 시간
	private String movImgPath;			// 섬네일 경로
	private String scsStartTime;		// 상영 시작시간
	private String scsFinishTime;		// 상영 종료 시간
	private String scsDate;				// 상영 날짜
	private String sccoCode;			// 상영 단가 코드
	private String scsScreen;			// 스크린 정보(2d,3d,imax,일반)
	private String dcinfCode;			// 할인 정보 코드
	private String scsTimeDiscount;		// 시간별 할인(조조, 심야, 일반)
	private String brcLocal;			// 지점위치
	private String brcName;				// 지점 이름
	private String personNum;			// 예매 인원 수
	private int finalCost;				// 최종 금액
	private String seatCode1;			// 첫번째 좌석
	private String seatCode2;			// 두번째 좌석
	private String seatCode3;			// 세번째 좌석
	private String seatCode4;			// 네번째 좌석
	

	public String getScsFinishTime() {
		return scsFinishTime;
	}
	public void setScsFinishTime(String scsFinishTime) {
		this.scsFinishTime = scsFinishTime;
	}
	public String getDcinfCode() {
		return dcinfCode;
	}
	public void setDcinfCode(String dcinfCode) {
		this.dcinfCode = dcinfCode;
	}
	public String getSccoCode() {
		return sccoCode;
	}
	public void setSccoCode(String sccoCode) {
		this.sccoCode = sccoCode;
	}
	public String getSeatCode1() {
		return seatCode1;
	}
	public void setSeatCode1(String seatCode1) {
		this.seatCode1 = seatCode1;
	}
	public String getSeatCode2() {
		return seatCode2;
	}
	public void setSeatCode2(String seatCode2) {
		this.seatCode2 = seatCode2;
	}
	public String getSeatCode3() {
		return seatCode3;
	}
	public void setSeatCode3(String seatCode3) {
		this.seatCode3 = seatCode3;
	}
	public String getSeatCode4() {
		return seatCode4;
	}
	public void setSeatCode4(String seatCode4) {
		this.seatCode4 = seatCode4;
	}
	public int getFinalCost() {
		return finalCost;
	}
	public void setFinalCost(int finalCost) {
		this.finalCost = finalCost;
	}
	public String getScsScreen() {
		return scsScreen;
	}
	public void setScsScreen(String scsScreen) {
		this.scsScreen = scsScreen;
	}
	public String getPersonNum() {
		return personNum;
	}
	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}
	public String getScsCode() {
		return scsCode;
	}
	public void setScsCode(String scsCode) {
		this.scsCode = scsCode;
	}
	public String getMovKorName() {
		return movKorName;
	}
	public void setMovKorName(String movKorName) {
		this.movKorName = movKorName;
	}
	public String getMovGrade() {
		return movGrade;
	}
	public void setMovGrade(String movGrade) {
		this.movGrade = movGrade;
	}
	public String getMovRunningTime() {
		return movRunningTime;
	}
	public void setMovRunningTime(String movRunningTime) {
		this.movRunningTime = movRunningTime;
	}
	public String getMovImgPath() {
		return movImgPath;
	}
	public void setMovImgPath(String movImgPath) {
		this.movImgPath = movImgPath;
	}
	public String getScsStartTime() {
		return scsStartTime;
	}
	public void setScsStartTime(String scsStartTime) {
		this.scsStartTime = scsStartTime;
	}
	public String getScsDate() {
		return scsDate;
	}
	public void setScsDate(String scsDate) {
		this.scsDate = scsDate;
	}
	public String getScsTimeDiscount() {
		return scsTimeDiscount;
	}
	public void setScsTimeDiscount(String scsTimeDiscount) {
		this.scsTimeDiscount = scsTimeDiscount;
	}
	public String getBrcLocal() {
		return brcLocal;
	}
	public void setBrcLocal(String brcLocal) {
		this.brcLocal = brcLocal;
	}
	public String getBrcName() {
		return brcName;
	}
	public void setBrcName(String brcName) {
		this.brcName = brcName;
	}
	@Override
	public String toString() {
		return "BookingInfo [scsCode=" + scsCode + ", movKorName=" + movKorName + ", movGrade=" + movGrade
				+ ", movRunningTime=" + movRunningTime + ", movImgPath=" + movImgPath + ", scsStartTime=" + scsStartTime
				+ ", scsFinishTime=" + scsFinishTime + ", scsDate=" + scsDate + ", sccoCode=" + sccoCode
				+ ", scsScreen=" + scsScreen + ", dcinfCode=" + dcinfCode + ", scsTimeDiscount=" + scsTimeDiscount
				+ ", brcLocal=" + brcLocal + ", brcName=" + brcName + ", personNum=" + personNum + ", finalCost="
				+ finalCost + ", seatCode1=" + seatCode1 + ", seatCode2=" + seatCode2 + ", seatCode3=" + seatCode3
				+ ", seatCode4=" + seatCode4 + "]";
	}
	
	
}

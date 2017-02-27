package kr.co.cinema.payment;

// 영화 결제 정보 담은 dto
public class BookingInfo {
	
	private String scsCode;				// 상영코드
	private String movKorName;			// 영화 한글 제목
	private String movGrade;			// 영화 등급
	private String movRunningTime;		// 상영 시간
	private String movImgPath;			// 섬네일 경로
	private String scsStartTime;		// 상영 시작시간
	private String scsDate;				// 상영 날짜
	private String scsScreen;			// 스크린 정보(2d,3d,imax,일반)
	private String scsTimeDiscount;		// 시간별 할인(조조, 심야, 일반)
	private String brcLocal;			// 지점위치
	private String brcName;				// 지점 이름
	private String personNum;			// 예매 인원 수
	private int finalCost;				// 최종 금액
	

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
				+ ", scsDate=" + scsDate + ", scsScreen=" + scsScreen + ", scsTimeDiscount=" + scsTimeDiscount
				+ ", brcLocal=" + brcLocal + ", brcName=" + brcName + ", personNum=" + personNum + ", finalCost="
				+ finalCost + "]";
	}
	
	
}

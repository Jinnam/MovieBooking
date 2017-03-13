package kr.co.cinema.dto;

// 상영 일정 dto
public class ScreenSchedule {

	private String scsCode;				// 상영 코드
	private int movCode;				// 영화 코드
	private int brcCode;				// 지점 코드
	private String scrCode;				// 상영관 코드
	private String scsDate;				// 상영 일자
	private String scsStartTime;		// 영화 시작 시간
	private String scsFinishTime;		// 영화 종료 시간
	private String scsScreen;			// 스크린 종류
	private String scsTimeDiscount;		// 할인 정보
	private String scsInsertDate;		// 등록일
	private String seatCol;				// 좌석 열
	private String seatRow;				// 좌석 행
	
	public String getSeatCol() {
		return seatCol;
	}
	public void setSeatCol(String seatCol) {
		this.seatCol = seatCol;
	}
	public String getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(String seatRow) {
		this.seatRow = seatRow;
	}
	public String getScrCode() {
		return scrCode;
	}
	public void setScrCode(String scrCode) {
		this.scrCode = scrCode;
	}
	public String getScsCode() {
		return scsCode;
	}
	public void setScsCode(String scsCode) {
		this.scsCode = scsCode;
	}
	public int getMovCode() {
		return movCode;
	}
	public void setMovCode(int movCode) {
		this.movCode = movCode;
	}
	public int getBrcCode() {
		return brcCode;
	}
	public void setBrcCode(int brcCode) {
		this.brcCode = brcCode;
	}
	public String getScsDate() {
		return scsDate;
	}
	public void setScsDate(String scsDate) {
		this.scsDate = scsDate;
	}
	public String getScsStartTime() {
		return scsStartTime;
	}
	public void setScsStartTime(String scsStartTime) {
		this.scsStartTime = scsStartTime;
	}
	public String getScsFinishTime() {
		return scsFinishTime;
	}
	public void setScsFinishTime(String scsFinishTime) {
		this.scsFinishTime = scsFinishTime;
	}
	public String getScsScreen() {
		return scsScreen;
	}
	public void setScsScreen(String scsScreen) {
		this.scsScreen = scsScreen;
	}
	public String getScsTimeDiscount() {
		return scsTimeDiscount;
	}
	public void setScsTimeDiscount(String scsTimeDiscount) {
		this.scsTimeDiscount = scsTimeDiscount;
	}
	public String getScsInsertDate() {
		return scsInsertDate;
	}
	public void setScsInsertDate(String scsInsertDate) {
		this.scsInsertDate = scsInsertDate;
	}
	
	@Override
	public String toString() {
		return "ScreenSchedule [scsCode=" + scsCode + ", movCode=" + movCode + ", brcCode=" + brcCode + ", scrCode="
				+ scrCode + ", scsDate=" + scsDate + ", scsStartTime=" + scsStartTime + ", scsFinishTime="
				+ scsFinishTime + ", scsScreen=" + scsScreen + ", scsTimeDiscount=" + scsTimeDiscount
				+ ", scsInsertDate=" + scsInsertDate + ", seatCol=" + seatCol + ", seatRow=" + seatRow + "]";
	}
	
	
}

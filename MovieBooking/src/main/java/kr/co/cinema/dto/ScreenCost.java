package kr.co.cinema.dto;

// 스크린별 단가
public class ScreenCost {

	private int sccoCode;			// 스크린별 단가 코드
	private String sccoScreen;		// 스크린 종류
	private int sccoPrice;			// 단가
	private int sccoApplyYear;		// 적용년
	private String sccoStatus;		// 현재 적용 유무
	private String sccoDate;		// 시스템 등록 일자
	
	public int getSccoCode() {
		return sccoCode;
	}
	public void setSccoCode(int sccoCode) {
		this.sccoCode = sccoCode;
	}
	public String getSccoScreen() {
		return sccoScreen;
	}
	public void setSccoScreen(String sccoScreen) {
		this.sccoScreen = sccoScreen;
	}
	public int getSccoPrice() {
		return sccoPrice;
	}
	public void setSccoPrice(int sccoPrice) {
		this.sccoPrice = sccoPrice;
	}
	public int getSccoApplyYear() {
		return sccoApplyYear;
	}
	public void setSccoApplyYear(int sccoApplyYear) {
		this.sccoApplyYear = sccoApplyYear;
	}
	public String getSccoStatus() {
		return sccoStatus;
	}
	public void setSccoStatus(String sccoStatus) {
		this.sccoStatus = sccoStatus;
	}
	public String getSccoDate() {
		return sccoDate;
	}
	public void setSccoDate(String sccoDate) {
		this.sccoDate = sccoDate;
	}
	
	@Override
	public String toString() {
		return "ScreenCost [sccoCode=" + sccoCode + ", sccoScreen=" + sccoScreen + ", sccoPrice=" + sccoPrice
				+ ", sccoApplyYear=" + sccoApplyYear + ", sccoStatus=" + sccoStatus + ", sccoDate=" + sccoDate + "]";
	}
	
	
}

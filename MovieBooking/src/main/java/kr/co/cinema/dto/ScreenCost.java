package kr.co.cinema.dto;

// ��ũ���� �ܰ�
public class ScreenCost {

	private int sccoCode;			// ��ũ���� �ܰ� �ڵ�
	private String sccoScreen;		// ��ũ�� ����
	private int sccoPrice;			// �ܰ�
	private int sccoApplyYear;		// �����
	private String sccoStatus;		// ���� ���� ����
	private String sccoDate;		// �ý��� ��� ����
	
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

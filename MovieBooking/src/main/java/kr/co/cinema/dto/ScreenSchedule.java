package kr.co.cinema.dto;

// �� ���� dto
public class ScreenSchedule {

	private int scsCode;				// �� �ڵ�
	private int movCode;				// ��ȭ �ڵ�
	private int brcCode;				// ���� �ڵ�
	private int scrCode;				// �󿵰� �ڵ�
	private String scsDate;				// �� ����
	private String scsStartTime;		// ��ȭ ���� �ð�
	private String scsFinishTime;		// ��ȭ ���� �ð�
	private String scsScreen;			// ��ũ�� ����
	private String scsTimeDiscount;		// ���� ����
	private String scsInsertDate;		// �����
	
	public int getScsCode() {
		return scsCode;
	}
	public void setScsCode(int scsCode) {
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
	public int getScrCode() {
		return scrCode;
	}
	public void setScrCode(int scrCode) {
		this.scrCode = scrCode;
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
				+ ", scsInsertDate=" + scsInsertDate + "]";
	}
	
	
}

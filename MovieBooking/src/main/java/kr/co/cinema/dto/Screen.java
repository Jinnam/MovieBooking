package kr.co.cinema.dto;

// �󿵰� dto
public class Screen {

	private int scrCode;		// �󿵰� �ڵ�
	private int brcCode;		// ���� �ڵ�
	private String scrName;		// �󿵰� �̸�
	private int scrRowSize;		// �� ũ��
	private int scrColSize;		// �� ũ��
	
	public int getScrCode() {
		return scrCode;
	}
	public void setScrCode(int scrCode) {
		this.scrCode = scrCode;
	}
	public int getBrcCode() {
		return brcCode;
	}
	public void setBrcCode(int brcCode) {
		this.brcCode = brcCode;
	}
	public String getScrName() {
		return scrName;
	}
	public void setScrName(String scrName) {
		this.scrName = scrName;
	}
	public int getScrRowSize() {
		return scrRowSize;
	}
	public void setScrRowSize(int scrRowSize) {
		this.scrRowSize = scrRowSize;
	}
	public int getScrColSize() {
		return scrColSize;
	}
	public void setScrColSize(int scrColSize) {
		this.scrColSize = scrColSize;
	}
	
	@Override
	public String toString() {
		return "Screen [scrCode=" + scrCode + ", brcCode=" + brcCode + ", scrName=" + scrName + ", scrRowSize="
				+ scrRowSize + ", scrColSize=" + scrColSize + "]";
	}
	
	
}

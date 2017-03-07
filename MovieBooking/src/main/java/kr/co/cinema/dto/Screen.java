package kr.co.cinema.dto;

// 상영관 dto
public class Screen {

	private String scrCode;		// 상영관 코드
	private int brcCode;		// 지점 코드
	private String scrName;		// 상영관 이름
	private int scrRowSize;		// 행 크기
	private int scrColSize;		// 열 크기
	private String brcName;		// 지점 이름
	
	public String getScrCode() {
		return scrCode;
	}
	public void setScrCode(String scrCode) {
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
	public String getBrcName() {
		return brcName;
	}
	public void setBrcName(String brcName) {
		this.brcName = brcName;
	}
	
	
}

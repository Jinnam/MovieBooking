package kr.co.cinema.dto;

public class BranchAndScreen {
	private String brcName;
	private int brcCode;
	private String scrName;
	public String getBrcName() {
		return brcName;
	}
	public void setBrcName(String brcName) {
		this.brcName = brcName;
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
	@Override
	public String toString() {
		return "BranchAndScreen [brcName=" + brcName + ", brcCode=" + brcCode + ", scrName=" + scrName + "]";
	}
	
}

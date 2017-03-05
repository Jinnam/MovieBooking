package kr.co.cinema.dto;

public class BranchAndBranchDayCount {
	private String brcName;
	private int brcCode;
	private int brcCntSaleTotal;
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
	public int getBrcCntSaleTotal() {
		return brcCntSaleTotal;
	}
	public void setBrcCntSaleTotal(int brcCntSaleTotal) {
		this.brcCntSaleTotal = brcCntSaleTotal;
	}
	@Override
	public String toString() {
		return "BranchAndBranchDayCount [brcName=" + brcName + ", brcCode=" + brcCode + ", brcCntSaleTotal="
				+ brcCntSaleTotal + "]";
	}
	
}

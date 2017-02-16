package kr.co.cinema.dto;

// 지점별 일일예매,매출 dto
public class BranchDayCount {

	private int brcCntCode;			// 지점별 예매,매출코드
	private int brcCode;			// 지점코드
	private int movCode;			// 영화코드
	private int brcCntClientCount;	// 일일관객수
	private int brcCntSaleTotal;	// 매출액
	private String brcCntDate;		// 날짜(일,월 매출의 기준이 됨)
	
	public int getBrcCntCode() {
		return brcCntCode;
	}
	public void setBrcCntCode(int brcCntCode) {
		this.brcCntCode = brcCntCode;
	}
	public int getBrcCode() {
		return brcCode;
	}
	public void setBrcCode(int brcCode) {
		this.brcCode = brcCode;
	}
	public int getMovCode() {
		return movCode;
	}
	public void setMovCode(int movCode) {
		this.movCode = movCode;
	}
	public int getBrcCntClientCount() {
		return brcCntClientCount;
	}
	public void setBrcCntClientCount(int brcCntClientCount) {
		this.brcCntClientCount = brcCntClientCount;
	}
	public int getBrcCntSaleTotal() {
		return brcCntSaleTotal;
	}
	public void setBrcCntSaleTotal(int brcCntSaleTotal) {
		this.brcCntSaleTotal = brcCntSaleTotal;
	}
	public String getBrcCntDate() {
		return brcCntDate;
	}
	public void setBrcCntDate(String brcCntDate) {
		this.brcCntDate = brcCntDate;
	}
	
	@Override
	public String toString() {
		return "BranchDayCount [brcCntCode=" + brcCntCode + ", brcCode=" + brcCode + ", movCode=" + movCode
				+ ", brcCntClientCount=" + brcCntClientCount + ", brcCntSaleTotal=" + brcCntSaleTotal + ", brcCntDate="
				+ brcCntDate + "]";
	}
	
	
}

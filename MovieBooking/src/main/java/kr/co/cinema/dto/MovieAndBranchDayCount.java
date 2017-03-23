package kr.co.cinema.dto;

//메인화면 영화 매출표 dto
public class MovieAndBranchDayCount {

	private String movKorName;
	private String movOpenDate;
	private int brcCntClientCount;
	private int brcCntSaleTotal;
	private int movCode;
	private int brcCode;
	
	public String getMovKorName() {
		return movKorName;
	}
	public void setMovKorName(String movKorName) {
		this.movKorName = movKorName;
	}
	public String getMovOpenDate() {
		return movOpenDate;
	}
	public void setMovOpenDate(String movOpenDate) {
		this.movOpenDate = movOpenDate;
	}
	public int getBrcCntClientCount() {
		return brcCntClientCount;
	}
	public void setBrcCntClientCount(int brcCntClientCount) {
		this.brcCntClientCount = brcCntClientCount;
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
	public int getBrcCntSaleTotal() {
		return brcCntSaleTotal;
	}
	public void setBrcCntSaleTotal(int brcCntSaleTotal) {
		this.brcCntSaleTotal = brcCntSaleTotal;
	}
	@Override
	public String toString() {
		return "MovieAndBranchDayCount [movKorName=" + movKorName + ", movOpenDate=" + movOpenDate
				+ ", brcCntClientCount=" + brcCntClientCount + ", brcCntSaleTotal=" + brcCntSaleTotal + ", movCode="
				+ movCode + ", brcCode=" + brcCode + "]";
	}

}

package kr.co.cinema.dto;

//메인화면 영화 매출표 dto
public class MovieAndBranchDayCount {

	private String movKorName;
	private String movOpenDate;
	private int brcCntClientCount;
	private int movCode;
	
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
	@Override
	public String toString() {
		return "MovieAndBranchDayCount [movKorName=" + movKorName + ", movOpenDate=" + movOpenDate
				+ ", brcCntClientCount=" + brcCntClientCount + "]";
	}
	public int getMovCode() {
		return movCode;
	}
	public void setMovCode(int movCode) {
		this.movCode = movCode;
	}

}

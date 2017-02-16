package kr.co.cinema.dto;

//한줄평,평점
public class Reply {

	private int rpCode;				// 한줄평 코드
	private String memId;			// 아이디
	private int movCode;			// 영화코드
	private String rpTitle;			// 제목
	private String rpDetail;		// 내용
	private int rpRecomend;			// 추천수
	private int rpGrade;			// 평점
	private String rpInsertDate;	// 등록일자
	
	public int getRpCode() {
		return rpCode;
	}
	public void setRpCode(int rpCode) {
		this.rpCode = rpCode;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public int getMovCode() {
		return movCode;
	}
	public void setMovCode(int movCode) {
		this.movCode = movCode;
	}
	public String getRpTitle() {
		return rpTitle;
	}
	public void setRpTitle(String rpTitle) {
		this.rpTitle = rpTitle;
	}
	public String getRpDetail() {
		return rpDetail;
	}
	public void setRpDetail(String rpDetail) {
		this.rpDetail = rpDetail;
	}
	public int getRpRecomend() {
		return rpRecomend;
	}
	public void setRpRecomend(int rpRecomend) {
		this.rpRecomend = rpRecomend;
	}
	public int getRpGrade() {
		return rpGrade;
	}
	public void setRpGrade(int rpGrade) {
		this.rpGrade = rpGrade;
	}
	public String getRpInsertDate() {
		return rpInsertDate;
	}
	public void setRpInsertDate(String rpInsertDate) {
		this.rpInsertDate = rpInsertDate;
	}
	
	@Override
	public String toString() {
		return "Reply [rpCode=" + rpCode + ", memId=" + memId + ", movCode=" + movCode + ", rpTitle=" + rpTitle
				+ ", rpDetail=" + rpDetail + ", rpRecomend=" + rpRecomend + ", rpGrade=" + rpGrade + ", rpInsertDate="
				+ rpInsertDate + "]";
	}
	
	
}

package kr.co.cinema.movie;

public class ReplyInputDto {
	String rpCode;
	String movCode ;
	String memId;
	int rpGrade;
	String rpDetail;
	@Override
	public String toString() {
		return "ReplyInputDto [movCode=" + movCode + ", memId=" + memId + ", rpGrade=" + rpGrade + ", rpDetail="
				+ rpDetail + "]";
	}
	public String getMovCode() {
		return movCode;
	}
	public void setMovCode(String movCode) {
		this.movCode = movCode;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public int getRpGrade() {
		return rpGrade;
	}
	public void setRpGrade(int rpGrade) {
		this.rpGrade = rpGrade;
	}
	public String getRpDetail() {
		return rpDetail;
	}
	public void setRpDetail(String rpDetail) {
		this.rpDetail = rpDetail;
	}
	public String getRpCode() {
		return rpCode;
	}
	public void setRpCode(String rpCode) {
		this.rpCode = rpCode;
	}
}

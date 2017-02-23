package kr.co.cinema.dto;

//한줄평 추천수 dto
public class ReplyRecommend {

	private String recoCode;	// 한줄평추천코드
	private String rpCode;		// 한줄평 코드
	private String memId;		// 아이디(추천한 회원)
	private String recoDate;	// 추천 일자
	
	
	public String getRpCode() {
		return rpCode;
	}
	public void setRpCode(String rpCode) {
		this.rpCode = rpCode;
	}
	public String getRecoCode() {
		return recoCode;
	}
	public void setRecoCode(String recoCode) {
		this.recoCode = recoCode;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getRecoDate() {
		return recoDate;
	}
	public void setRecoDate(String recoDate) {
		this.recoDate = recoDate;
	}
	
	@Override
	public String toString() {
		return "Screen [recoCode=" + recoCode + ", rpCode=" + rpCode + ", memId=" + memId + ", recoDate=" + recoDate
				+ "]";
	}
	
}

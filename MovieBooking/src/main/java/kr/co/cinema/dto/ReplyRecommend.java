package kr.co.cinema.dto;

//한줄평 추천수 dto
public class ReplyRecommend {

	private int recoCode;		// 한줄평추천코드
	private int rpCode;			// 한줄평 코드
	private String memId;		// 아이디(추천한 회원)
	private String recoDate;	// 추천 일자
	
	public int getRecoCode() {
		return recoCode;
	}
	public void setRecoCode(int recoCode) {
		this.recoCode = recoCode;
	}
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

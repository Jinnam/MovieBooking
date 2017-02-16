package kr.co.cinema.dto;

// 관리자 정보 dto
public class Admin {
	
	private String admId;		// 관리자 아이디
	private String admPw;		// 관리자 비밀번호
	private int brcCode;		// 지점 코드
	private String admAuth;		// 관리자 권한
	private String admDate;		// 관리자 승일 일자
	
	public String getAdmId() {
		return admId;
	}
	public void setAdmId(String admId) {
		this.admId = admId;
	}
	public String getAdmPw() {
		return admPw;
	}
	public void setAdmPw(String admPw) {
		this.admPw = admPw;
	}
	public int getBrcCode() {
		return brcCode;
	}
	public void setBrcCode(int brcCode) {
		this.brcCode = brcCode;
	}
	public String getAdmAuth() {
		return admAuth;
	}
	public void setAdmAuth(String admAuth) {
		this.admAuth = admAuth;
	}
	public String getAdmDate() {
		return admDate;
	}
	public void setAdmDate(String admDate) {
		this.admDate = admDate;
	}
	
	@Override
	public String toString() {
		return "Admin [admId=" + admId + ", admPw=" + admPw + ", brcCode=" + brcCode + ", admAuth=" + admAuth
				+ ", admDate=" + admDate + "]";
	}
	
}

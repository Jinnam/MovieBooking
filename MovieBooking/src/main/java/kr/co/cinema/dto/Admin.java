package kr.co.cinema.dto;

// ������ ���� dto
public class Admin {
	
	private String admId;		// ������ ���̵�
	private String admPw;		// ������ ��й�ȣ
	private int brcCode;		// ���� �ڵ�
	private String admAuth;		// ������ ����
	private String admDate;		// ������ ���� ����
	
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

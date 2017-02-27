package kr.co.cinema.dto;

public class AdminAndBranch {
	private String admId;
	private String admDate;
	private String brcName;
	private String brcLocal;
	private int brcCode;
	public String getAdmId() {
		return admId;
	}
	public void setAdmId(String admId) {
		this.admId = admId;
	}
	public String getAdmDate() {
		return admDate;
	}
	public void setAdmDate(String admDate) {
		this.admDate = admDate;
	}
	public String getBrcName() {
		return brcName;
	}
	public void setBrcName(String brcName) {
		this.brcName = brcName;
	}
	public String getBrcLocal() {
		return brcLocal;
	}
	public void setBrcLocal(String brcLocal) {
		this.brcLocal = brcLocal;
	}
	public int getBrcCode() {
		return brcCode;
	}
	public void setBrcCode(int brcCode) {
		this.brcCode = brcCode;
	}
	@Override
	public String toString() {
		return "AdminAndBranch [admId=" + admId + ", admDate=" + admDate + ", brcName=" + brcName + ", brcLocal="
				+ brcLocal + ", brcCode=" + brcCode + "]";
	}
	
	
}

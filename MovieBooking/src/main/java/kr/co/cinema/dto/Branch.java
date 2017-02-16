package kr.co.cinema.dto;

// 지점 dto
public class Branch {
	
	private int brcCode;			// 지점 코드
	private String brcName;			// 지점 이름
	private String brcLocal;		// 지점 위치
	private String brcAddr;			// 지점 주소
	private String brcInfoDetail;	// 지점소개
	private String brcImgPath;		// 이미지 경로
	
	public int getBrcCode() {
		return brcCode;
	}
	public void setBrcCode(int brcCode) {
		this.brcCode = brcCode;
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
	public String getBrcAddr() {
		return brcAddr;
	}
	public void setBrcAddr(String brcAddr) {
		this.brcAddr = brcAddr;
	}
	public String getBrcInfoDetail() {
		return brcInfoDetail;
	}
	public void setBrcInfoDetail(String brcInfoDetail) {
		this.brcInfoDetail = brcInfoDetail;
	}
	public String getBrcImgPath() {
		return brcImgPath;
	}
	public void setBrcImgPath(String brcImgPath) {
		this.brcImgPath = brcImgPath;
	}
	
	@Override
	public String toString() {
		return "Branch [brcCode=" + brcCode + ", brcName=" + brcName + ", brcLocal=" + brcLocal + ", brcAddr=" + brcAddr
				+ ", brcInfoDetail=" + brcInfoDetail + ", brcImgPath=" + brcImgPath + "]";
	}
	
	
}

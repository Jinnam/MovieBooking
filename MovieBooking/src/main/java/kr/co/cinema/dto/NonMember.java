package kr.co.cinema.dto;

// 비회원 dto
public class NonMember {
	
	private int nmemCode;			// 비회원 코드
	private int nmemPhone;			// 휴대폰 번호
	private String nmemName;		// 이름
	private String nmemBirth;		// 생년월일
	private String nmemPw;			// 비밀번호
	
	public int getNmemCode() {
		return nmemCode;
	}
	public void setNmemCode(int nmemCode) {
		this.nmemCode = nmemCode;
	}
	public int getNmemPhone() {
		return nmemPhone;
	}
	public void setNmemPhone(int nmemPhone) {
		this.nmemPhone = nmemPhone;
	}
	public String getNmemName() {
		return nmemName;
	}
	public void setNmemName(String nmemName) {
		this.nmemName = nmemName;
	}
	public String getNmemBirth() {
		return nmemBirth;
	}
	public void setNmemBirth(String nmemBirth) {
		this.nmemBirth = nmemBirth;
	}
	public String getNmemPw() {
		return nmemPw;
	}
	public void setNmemPw(String nmemPw) {
		this.nmemPw = nmemPw;
	}
	
	@Override
	public String toString() {
		return "NonMember [nmemCode=" + nmemCode + ", nmemPhone=" + nmemPhone + ", nmemName=" + nmemName
				+ ", nmemBirth=" + nmemBirth + ", nmemPw=" + nmemPw + "]";
	}
	
}

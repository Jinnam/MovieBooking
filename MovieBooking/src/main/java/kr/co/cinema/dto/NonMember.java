package kr.co.cinema.dto;

// ��ȸ�� dto
public class NonMember {
	
	private int nmemCode;			// ��ȸ�� �ڵ�
	private int nmemPhone;			// �޴��� ��ȣ
	private String nmemName;		// �̸�
	private String nmemBirth;		// �������
	private String nmemPw;			// ��й�ȣ
	
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

package kr.co.cinema.dto;

// ȸ�� dto
public class Member {

	private String memId;			// ȸ�� ���̵�
	private String memPw;			// ȸ�� ��й�ȣ
	private String memPhone;		// �޴��� ��ȣ
	private String memName;			// �̸�
	private String memGender;		// ����
	private String memBirth;		// �������
	private int memPostNo;			// �����ȣ
	private String memAddr;			// �ּ�
	private String memMail;			// �̸���
	private int memMileage;			// ���ϸ���
	private String memJoinDay;		// ������
	private String memStatus;		// ȸ������(�Ϲ�,Ż��)
	private String memLeaveDay;		// Ż����
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemGender() {
		return memGender;
	}
	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}
	public String getMemBirth() {
		return memBirth;
	}
	public void setMemBirth(String memBirth) {
		this.memBirth = memBirth;
	}
	public int getMemPostNo() {
		return memPostNo;
	}
	public void setMemPostNo(int memPostNo) {
		this.memPostNo = memPostNo;
	}
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public int getMemMileage() {
		return memMileage;
	}
	public void setMemMileage(int memMileage) {
		this.memMileage = memMileage;
	}
	public String getMemJoinDay() {
		return memJoinDay;
	}
	public void setMemJoinDay(String memJoinDay) {
		this.memJoinDay = memJoinDay;
	}
	public String getMemStatus() {
		return memStatus;
	}
	public void setMemStatus(String memStatus) {
		this.memStatus = memStatus;
	}
	public String getMemLeaveDay() {
		return memLeaveDay;
	}
	public void setMemLeaveDay(String memLeaveDay) {
		this.memLeaveDay = memLeaveDay;
	}
	
	@Override
	public String toString() {
		return "Member [memId=" + memId + ", memPw=" + memPw + ", memPhone=" + memPhone + ", memName=" + memName
				+ ", memGender=" + memGender + ", memBirth=" + memBirth + ", memPostNo=" + memPostNo + ", memAddr="
				+ memAddr + ", memMail=" + memMail + ", memMileage=" + memMileage + ", memJoinDay=" + memJoinDay
				+ ", memStatus=" + memStatus + ", memLeaveDay=" + memLeaveDay + "]";
	}
	
	
}

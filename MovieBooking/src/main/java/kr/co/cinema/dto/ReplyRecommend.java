package kr.co.cinema.dto;

//������ ��õ�� dto
public class ReplyRecommend {

	private int recoCode;		// ��������õ�ڵ�
	private int rpCode;			// ������ �ڵ�
	private String memId;		// ���̵�(��õ�� ȸ��)
	private String recoDate;	// ��õ ����
	
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

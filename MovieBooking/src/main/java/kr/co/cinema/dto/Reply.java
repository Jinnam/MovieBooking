package kr.co.cinema.dto;

//������,����
public class Reply {

	private int rpCode;				// ������ �ڵ�
	private String memId;			// ���̵�
	private int movCode;			// ��ȭ�ڵ�
	private String rpTitle;			// ����
	private String rpDetail;		// ����
	private int rpRecomend;			// ��õ��
	private int rpGrade;			// ����
	private String rpInsertDate;	// �������
	
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
	public int getMovCode() {
		return movCode;
	}
	public void setMovCode(int movCode) {
		this.movCode = movCode;
	}
	public String getRpTitle() {
		return rpTitle;
	}
	public void setRpTitle(String rpTitle) {
		this.rpTitle = rpTitle;
	}
	public String getRpDetail() {
		return rpDetail;
	}
	public void setRpDetail(String rpDetail) {
		this.rpDetail = rpDetail;
	}
	public int getRpRecomend() {
		return rpRecomend;
	}
	public void setRpRecomend(int rpRecomend) {
		this.rpRecomend = rpRecomend;
	}
	public int getRpGrade() {
		return rpGrade;
	}
	public void setRpGrade(int rpGrade) {
		this.rpGrade = rpGrade;
	}
	public String getRpInsertDate() {
		return rpInsertDate;
	}
	public void setRpInsertDate(String rpInsertDate) {
		this.rpInsertDate = rpInsertDate;
	}
	
	@Override
	public String toString() {
		return "Reply [rpCode=" + rpCode + ", memId=" + memId + ", movCode=" + movCode + ", rpTitle=" + rpTitle
				+ ", rpDetail=" + rpDetail + ", rpRecomend=" + rpRecomend + ", rpGrade=" + rpGrade + ", rpInsertDate="
				+ rpInsertDate + "]";
	}
	
	
}

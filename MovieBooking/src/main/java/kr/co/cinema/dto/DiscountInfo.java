package kr.co.cinema.dto;

// �������� dto
public class DiscountInfo {
	
	private int dcinfCode;			// �������� �ڵ�
	private String dcinfInfo;		// ��������
	private int dcinfPrice;			// ���� ����
	private int dcinfApplyYear;		// ���� �⵵
	private String dcinfStatus;		// ���� ���� ����
	private String dcinfDate;		// �ý��� �������
	
	public int getDcinfCode() {
		return dcinfCode;
	}
	public void setDcinfCode(int dcinfCode) {
		this.dcinfCode = dcinfCode;
	}
	public String getDcinfInfo() {
		return dcinfInfo;
	}
	public void setDcinfInfo(String dcinfInfo) {
		this.dcinfInfo = dcinfInfo;
	}
	public int getDcinfPrice() {
		return dcinfPrice;
	}
	public void setDcinfPrice(int dcinfPrice) {
		this.dcinfPrice = dcinfPrice;
	}
	public int getDcinfApplyYear() {
		return dcinfApplyYear;
	}
	public void setDcinfApplyYear(int dcinfApplyYear) {
		this.dcinfApplyYear = dcinfApplyYear;
	}
	public String getDcinfStatus() {
		return dcinfStatus;
	}
	public void setDcinfStatus(String dcinfStatus) {
		this.dcinfStatus = dcinfStatus;
	}
	public String getDcinfDate() {
		return dcinfDate;
	}
	public void setDcinfDate(String dcinfDate) {
		this.dcinfDate = dcinfDate;
	}
	
	@Override
	public String toString() {
		return "DiscountInfo [dcinfCode=" + dcinfCode + ", dcinfInfo=" + dcinfInfo + ", dcinfPrice=" + dcinfPrice
				+ ", dcinfApplyYear=" + dcinfApplyYear + ", dcinfStatus=" + dcinfStatus + ", dcinfDate=" + dcinfDate
				+ "]";
	}
	
	
}

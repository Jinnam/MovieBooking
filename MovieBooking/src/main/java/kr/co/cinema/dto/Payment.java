package kr.co.cinema.dto;

// ���� dto
public class Payment {

	private int pmtCode;			// ���� �ڵ�
	private int scsCode;			// �� �ڵ�
	private String memIdd;			// ���̵�(ȸ��)
	private int nmemCode;			// ��ȸ�� �ڵ�(��ȸ��)
	private int sccoCode;			// �� �ܰ� �ڵ�
	private int dcinfCode;			// ���� �ڵ�
	private int pmtTicketNum;		// �ο�
	private int pmtPrice;			// ���� �ݾ�
	private String pmtDate;			// ���� ��¥
	
	public int getPmtCode() {
		return pmtCode;
	}
	public void setPmtCode(int pmtCode) {
		this.pmtCode = pmtCode;
	}
	public int getScsCode() {
		return scsCode;
	}
	public void setScsCode(int scsCode) {
		this.scsCode = scsCode;
	}
	public String getMemIdd() {
		return memIdd;
	}
	public void setMemIdd(String memIdd) {
		this.memIdd = memIdd;
	}
	public int getNmemCode() {
		return nmemCode;
	}
	public void setNmemCode(int nmemCode) {
		this.nmemCode = nmemCode;
	}
	public int getSccoCode() {
		return sccoCode;
	}
	public void setSccoCode(int sccoCode) {
		this.sccoCode = sccoCode;
	}
	public int getDcinfCode() {
		return dcinfCode;
	}
	public void setDcinfCode(int dcinfCode) {
		this.dcinfCode = dcinfCode;
	}
	public int getPmtTicketNum() {
		return pmtTicketNum;
	}
	public void setPmtTicketNum(int pmtTicketNum) {
		this.pmtTicketNum = pmtTicketNum;
	}
	public int getPmtPrice() {
		return pmtPrice;
	}
	public void setPmtPrice(int pmtPrice) {
		this.pmtPrice = pmtPrice;
	}
	public String getPmtDate() {
		return pmtDate;
	}
	public void setPmtDate(String pmtDate) {
		this.pmtDate = pmtDate;
	}
	
	@Override
	public String toString() {
		return "Payment [pmtCode=" + pmtCode + ", scsCode=" + scsCode + ", memIdd=" + memIdd + ", nmemCode=" + nmemCode
				+ ", sccoCode=" + sccoCode + ", dcinfCode=" + dcinfCode + ", pmtTicketNum=" + pmtTicketNum
				+ ", pmtPrice=" + pmtPrice + ", pmtDate=" + pmtDate + "]";
	}
	
	
}

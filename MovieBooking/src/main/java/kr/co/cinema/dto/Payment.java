package kr.co.cinema.dto;

// 결제 dto
public class Payment {

	private int pmtCode;			// 결제 코드
	private int scsCode;			// 상영 코드
	private String memIdd;			// 아이디(회원)
	private int nmemCode;			// 비회원 코드(비회원)
	private int sccoCode;			// 상영 단가 코드
	private int dcinfCode;			// 할인 코드
	private int pmtTicketNum;		// 인원
	private int pmtPrice;			// 결제 금액
	private String pmtDate;			// 결제 날짜
	
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

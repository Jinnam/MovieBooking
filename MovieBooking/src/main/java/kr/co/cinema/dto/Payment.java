package kr.co.cinema.dto;

// 결제 dto
public class Payment {

	private String pmtCode;			// 결제 코드
	private String scsCode;			// 상영 코드
	private String memIdd;			// 아이디(회원)
	private String nmemCode;			// 비회원 코드(비회원)
	private int sccoCode;			// 상영 단가 코드
	private int dcinfCode;			// 할인 코드
	private int pmtTicketNum;		// 인원
	private int pmtPrice;			// 결제 금액
	private String pmtDate;			// 결제 날짜
	
	public String getScsCode() {
		return scsCode;
	}
	public void setScsCode(String scsCode) {
		this.scsCode = scsCode;
	}
	public String getNmemCode() {
		return nmemCode;
	}
	public void setNmemCode(String nmemCode) {
		this.nmemCode = nmemCode;
	}
	public String getPmtCode() {
		return pmtCode;
	}
	public void setPmtCode(String pmtCode) {
		this.pmtCode = pmtCode;
	}
	public String getMemIdd() {
		return memIdd;
	}
	public void setMemIdd(String memIdd) {
		this.memIdd = memIdd;
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

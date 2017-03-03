package kr.co.cinema.dto;

import java.util.Arrays;

// 결제 dto
public class Payment {

	private String pmtCode;			// 결제 코드
	private String paymentWay;		// 결제 방법
	private String scsCode;			// 상영 일정 코드
	private String memId;			// 아이디(회원)
	private String nmemCode;		// 비회원 코드(비회원)
	private int sccoCode;			// 상영 단가 코드
	private int dcinfCode;			// 할인 코드
	private int useMileage;			// 사용 마일리지
	private String seatCode1;		// 첫번째 좌석 코드
	private String seatCode2;		// 두번째 좌석 코드
	private String seatCode3;		// 세번째 좌석 코드
	private String seatCode4;		// 네번째 좌석 코드
	private String[] seatCode;		// 좌석 코드 배열
	private int pmtTicketNum;		// 인원
	private int pmtPrice;			// 결제 금액
	private String pmtDate;			// 결제 날짜
	
	
	public String[] getSeatCode() {
		return seatCode;
	}
	public void setSeatCode(String[] seatCode) {
		this.seatCode = seatCode;
	}
	public String getPaymentWay() {
		return paymentWay;
	}
	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}
	public int getUseMileage() {
		return useMileage;
	}
	public void setUseMileage(int useMileage) {
		this.useMileage = useMileage;
	}
	public String getSeatCode1() {
		return seatCode1;
	}
	public void setSeatCode1(String seatCode1) {
		this.seatCode1 = seatCode1;
	}
	public String getSeatCode2() {
		return seatCode2;
	}
	public void setSeatCode2(String seatCode2) {
		this.seatCode2 = seatCode2;
	}
	public String getSeatCode3() {
		return seatCode3;
	}
	public void setSeatCode3(String seatCode3) {
		this.seatCode3 = seatCode3;
	}
	public String getSeatCode4() {
		return seatCode4;
	}
	public void setSeatCode4(String seatCode4) {
		this.seatCode4 = seatCode4;
	}
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
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
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
		return "Payment [pmtCode=" + pmtCode + ", paymentWay=" + paymentWay + ", scsCode=" + scsCode + ", memId="
				+ memId + ", nmemCode=" + nmemCode + ", sccoCode=" + sccoCode + ", dcinfCode=" + dcinfCode
				+ ", useMileage=" + useMileage + ", seatCode1=" + seatCode1 + ", seatCode2=" + seatCode2
				+ ", seatCode3=" + seatCode3 + ", seatCode4=" + seatCode4 + ", seatCode=" + Arrays.toString(seatCode)
				+ ", pmtTicketNum=" + pmtTicketNum + ", pmtPrice=" + pmtPrice + ", pmtDate=" + pmtDate + "]";
	}
	
	
}

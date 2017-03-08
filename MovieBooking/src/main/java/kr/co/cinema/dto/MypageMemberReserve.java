package kr.co.cinema.dto;

public class MypageMemberReserve {
	private String pmtCode;			//결제코드
	private String scsDate;			//상영날짜
	private String movKorName;		//영화한글제목
	private String brcName;			//지점명
	private String pmtDate;			//결제날짜	
	
	
	public String getPmtDate() {
		return pmtDate;
	}
	public void setPmtDate(String pmtDate) {
		this.pmtDate = pmtDate;
	}
	public String getPmtCode() {
		return pmtCode;
	}
	public String getBrcName() {
		return brcName;
	}
	public void setBrcName(String brcName) {
		this.brcName = brcName;
	}
	public void setPmtCode(String pmtCode) {
		this.pmtCode = pmtCode;
	}
	public String getScsDate() {
		return scsDate;
	}
	public void setScsDate(String scsDate) {
		this.scsDate = scsDate;
	}
	public String getMovKorName() {
		return movKorName;
	}
	public void setMovKorName(String movKorName) {
		this.movKorName = movKorName;
	}
	@Override
	public String toString() {
		return "MypageMemberReserve [pmtCode=" + pmtCode + ", scsDate=" + scsDate + ", movKorName=" + movKorName
				+ ", brcName=" + brcName + ", pmtDate=" + pmtDate + "]";
	}
	
	
}

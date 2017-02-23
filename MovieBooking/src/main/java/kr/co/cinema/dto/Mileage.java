package kr.co.cinema.dto;

// 마일리지 dto
public class Mileage {

	private String milCode;		// 마일리지 코드
	private String pmtCode;		// 결제코드
	private String memId;		// 아이디
	private int milUse;			// 사용 마일리지
	private int milSave;		// 적립 마일리지
	private String milDate;		// 마일리지 사용,적립 날짜
	
	public String getPmtCode() {
		return pmtCode;
	}
	public void setPmtCode(String pmtCode) {
		this.pmtCode = pmtCode;
	}
	public String getMilCode() {
		return milCode;
	}
	public void setMilCode(String milCode) {
		this.milCode = milCode;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public int getMilUse() {
		return milUse;
	}
	public void setMilUse(int milUse) {
		this.milUse = milUse;
	}
	public int getMilSave() {
		return milSave;
	}
	public void setMilSave(int milSave) {
		this.milSave = milSave;
	}
	public String getMilDate() {
		return milDate;
	}
	public void setMilDate(String milDate) {
		this.milDate = milDate;
	}
	
	@Override
	public String toString() {
		return "Mileage [milCode=" + milCode + ", pmtCode=" + pmtCode + ", memId=" + memId + ", milUse=" + milUse
				+ ", milSave=" + milSave + ", milDate=" + milDate + "]";
	}
	
	
	
}

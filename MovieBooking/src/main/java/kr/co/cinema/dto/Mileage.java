package kr.co.cinema.dto;

// ���ϸ��� dto
public class Mileage {

	private int milCode;		// ���ϸ��� �ڵ�
	private int pmtCode;		// �����ڵ�
	private String memId;		// ���̵�
	private int milUse;			// ��� ���ϸ���
	private int milSave;		// ���� ���ϸ���
	private String milDate;		// ���ϸ��� ���,���� ��¥
	
	public int getMilCode() {
		return milCode;
	}
	public void setMilCode(int milCode) {
		this.milCode = milCode;
	}
	public int getPmtCode() {
		return pmtCode;
	}
	public void setPmtCode(int pmtCode) {
		this.pmtCode = pmtCode;
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

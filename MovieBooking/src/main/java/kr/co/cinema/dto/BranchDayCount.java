package kr.co.cinema.dto;

// ������ ���Ͽ���,���� dto
public class BranchDayCount {

	private int brcCntCode;			// ������ ����,�����ڵ�
	private int brcCode;			// �����ڵ�
	private int movCode;			// ��ȭ�ڵ�
	private int brcCntClientCount;	// ���ϰ�����
	private int brcCntSaleTotal;	// �����
	private String brcCntDate;		// ��¥(��,�� ������ ������ ��)
	
	public int getBrcCntCode() {
		return brcCntCode;
	}
	public void setBrcCntCode(int brcCntCode) {
		this.brcCntCode = brcCntCode;
	}
	public int getBrcCode() {
		return brcCode;
	}
	public void setBrcCode(int brcCode) {
		this.brcCode = brcCode;
	}
	public int getMovCode() {
		return movCode;
	}
	public void setMovCode(int movCode) {
		this.movCode = movCode;
	}
	public int getBrcCntClientCount() {
		return brcCntClientCount;
	}
	public void setBrcCntClientCount(int brcCntClientCount) {
		this.brcCntClientCount = brcCntClientCount;
	}
	public int getBrcCntSaleTotal() {
		return brcCntSaleTotal;
	}
	public void setBrcCntSaleTotal(int brcCntSaleTotal) {
		this.brcCntSaleTotal = brcCntSaleTotal;
	}
	public String getBrcCntDate() {
		return brcCntDate;
	}
	public void setBrcCntDate(String brcCntDate) {
		this.brcCntDate = brcCntDate;
	}
	
	@Override
	public String toString() {
		return "BranchDayCount [brcCntCode=" + brcCntCode + ", brcCode=" + brcCode + ", movCode=" + movCode
				+ ", brcCntClientCount=" + brcCntClientCount + ", brcCntSaleTotal=" + brcCntSaleTotal + ", brcCntDate="
				+ brcCntDate + "]";
	}
	
	
}

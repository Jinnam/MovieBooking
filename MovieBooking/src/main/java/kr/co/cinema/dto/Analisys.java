package kr.co.cinema.dto;

// ��踦 ���� dto
public class Analisys {
	
	private int movCode;					// ��ȭ�ڵ�
	private int anlTotalTicketCount;		// ��ü �����ο���
	private int anl10sTicketCount;			// 10�� ���� �ο���
	private int anl20sTicketCount;			// 20�� ���� �ο���
	private int anl30sTicketCount;			// 30�� ���� �ο���
	private int anl40sTicketCount;			// 40�� ���� �ο���
	private int anl50sTicketCount;			// 50�� ���� �ο���
	private int anlOver50sTicketCount;		// 50�� �̻󿹸� �ο���
	private int anlManTicketCount;			// ���� ���� �ο���
	private int anlWomanTicketCount;		// ���� ���� �ο���
	private int anlAcSales;					// ���� �����
	private String anlFinalModifyDate;		// ���� ��������
	
	public int getMovCode() {
		return movCode;
	}
	public void setMovCode(int movCode) {
		this.movCode = movCode;
	}
	public int getAnlTotalTicketCount() {
		return anlTotalTicketCount;
	}
	public void setAnlTotalTicketCount(int anlTotalTicketCount) {
		this.anlTotalTicketCount = anlTotalTicketCount;
	}
	public int getAnl10sTicketCount() {
		return anl10sTicketCount;
	}
	public void setAnl10sTicketCount(int anl10sTicketCount) {
		this.anl10sTicketCount = anl10sTicketCount;
	}
	public int getAnl20sTicketCount() {
		return anl20sTicketCount;
	}
	public void setAnl20sTicketCount(int anl20sTicketCount) {
		this.anl20sTicketCount = anl20sTicketCount;
	}
	public int getAnl30sTicketCount() {
		return anl30sTicketCount;
	}
	public void setAnl30sTicketCount(int anl30sTicketCount) {
		this.anl30sTicketCount = anl30sTicketCount;
	}
	public int getAnl40sTicketCount() {
		return anl40sTicketCount;
	}
	public void setAnl40sTicketCount(int anl40sTicketCount) {
		this.anl40sTicketCount = anl40sTicketCount;
	}
	public int getAnl50sTicketCount() {
		return anl50sTicketCount;
	}
	public void setAnl50sTicketCount(int anl50sTicketCount) {
		this.anl50sTicketCount = anl50sTicketCount;
	}
	public int getAnlOver50sTicketCount() {
		return anlOver50sTicketCount;
	}
	public void setAnlOver50sTicketCount(int anlOver50sTicketCount) {
		this.anlOver50sTicketCount = anlOver50sTicketCount;
	}
	public int getAnlManTicketCount() {
		return anlManTicketCount;
	}
	public void setAnlManTicketCount(int anlManTicketCount) {
		this.anlManTicketCount = anlManTicketCount;
	}
	public int getAnlWomanTicketCount() {
		return anlWomanTicketCount;
	}
	public void setAnlWomanTicketCount(int anlWomanTicketCount) {
		this.anlWomanTicketCount = anlWomanTicketCount;
	}
	public int getAnlAcSales() {
		return anlAcSales;
	}
	public void setAnlAcSales(int anlAcSales) {
		this.anlAcSales = anlAcSales;
	}
	public String getAnlFinalModifyDate() {
		return anlFinalModifyDate;
	}
	public void setAnlFinalModifyDate(String anlFinalModifyDate) {
		this.anlFinalModifyDate = anlFinalModifyDate;
	}
	@Override
	public String toString() {
		return "Analisys [movCode=" + movCode + ", anlTotalTicketCount=" + anlTotalTicketCount + ", anl10sTicketCount="
				+ anl10sTicketCount + ", anl20sTicketCount=" + anl20sTicketCount + ", anl30sTicketCount="
				+ anl30sTicketCount + ", anl40sTicketCount=" + anl40sTicketCount + ", anl50sTicketCount="
				+ anl50sTicketCount + ", anlOver50sTicketCount=" + anlOver50sTicketCount + ", anlManTicketCount="
				+ anlManTicketCount + ", anlWomanTicketCount=" + anlWomanTicketCount + ", anlAcSales=" + anlAcSales
				+ ", anlFinalModifyDate=" + anlFinalModifyDate + "]";
	}
	
	
	
}

package kr.co.cinema.dto;

// �¼� ���� dto
public class Seat {

	private int seatCode;			// �¼� �ڵ�
	private int scsCode;			// �� �ڵ�
	private int scrCode;			// �󿵰� �ڵ�
	private String setaRow;			// ��
	private int seatCol;			// ��
	private String seatUseStatus;	// ��� ����
	
	public int getSeatCode() {
		return seatCode;
	}
	public void setSeatCode(int seatCode) {
		this.seatCode = seatCode;
	}
	public int getScsCode() {
		return scsCode;
	}
	public void setScsCode(int scsCode) {
		this.scsCode = scsCode;
	}
	public int getScrCode() {
		return scrCode;
	}
	public void setScrCode(int scrCode) {
		this.scrCode = scrCode;
	}
	public String getSetaRow() {
		return setaRow;
	}
	public void setSetaRow(String setaRow) {
		this.setaRow = setaRow;
	}
	public int getSeatCol() {
		return seatCol;
	}
	public void setSeatCol(int seatCol) {
		this.seatCol = seatCol;
	}
	public String getSeatUseStatus() {
		return seatUseStatus;
	}
	public void setSeatUseStatus(String seatUseStatus) {
		this.seatUseStatus = seatUseStatus;
	}
	
	@Override
	public String toString() {
		return "Seat [seatCode=" + seatCode + ", scsCode=" + scsCode + ", scrCode=" + scrCode + ", setaRow=" + setaRow
				+ ", seatCol=" + seatCol + ", seatUseStatus=" + seatUseStatus + "]";
	}
	
	
}

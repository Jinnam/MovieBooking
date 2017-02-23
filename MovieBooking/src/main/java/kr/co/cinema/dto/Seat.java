package kr.co.cinema.dto;

// 좌석 정보 dto
public class Seat {

	private String seatCode;			// 좌석 코드
	private String scsCode;			// 상영 코드
	private String scrCode;			// 상영관 코드
	private String setaRow;			// 행
	private int seatCol;			// 열
	private String seatUseStatus;	// 사용 여부
	
	
	public String getSeatCode() {
		return seatCode;
	}
	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}
	public String getScsCode() {
		return scsCode;
	}
	public void setScsCode(String scsCode) {
		this.scsCode = scsCode;
	}
	public String getScrCode() {
		return scrCode;
	}
	public void setScrCode(String scrCode) {
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

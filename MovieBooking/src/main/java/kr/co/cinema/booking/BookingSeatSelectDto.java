package kr.co.cinema.booking;

//결제전 최종 상영일정 / 좌석 / 인원 정보 
public class BookingSeatSelectDto {
	String scsCode;
	String personNum;
	String seatCode1;
	String seatCode2;
	String seatCode3;
	String seatCode4;
	@Override
	public String toString() {
		return "BookingSeatSelectDto [scsCode=" + scsCode + ", personNum=" + personNum + ", seatCode1=" + seatCode1
				+ ", seatCode2=" + seatCode2 + ", seatCode3=" + seatCode3 + ", seatCode4=" + seatCode4 + "]";
	}
	public String getScsCode() {
		return scsCode;
	}
	public void setScsCode(String scsCode) {
		this.scsCode = scsCode;
	}
	public String getPersonNum() {
		return personNum;
	}
	public void setPersonNum(String personNum) {
		this.personNum = personNum;
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
}

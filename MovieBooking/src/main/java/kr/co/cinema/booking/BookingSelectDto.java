package kr.co.cinema.booking;

//예매시 조건을 입력하는 dto
public class BookingSelectDto {
	int brcCode;		//지점코드
	int movCode;		//영화코드
	String Date;		//날짜
	@Override
	public String toString() {
		return "BookingSelect [brcCode=" + brcCode + ", movCode=" + movCode + ", Date=" + Date + "]";
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
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
}

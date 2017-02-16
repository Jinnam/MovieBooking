package kr.co.cinema.dto;

// 할인정보 dto
public class DiscountInfo {
	
	private int dcinfCode;			// 할인정보 코드
	private String dcinfInfo;		// 할인정보
	private int dcinfPrice;			// 할인 가격
	private int dcinfApplyYear;		// 적용 년도
	private String dcinfStatus;		// 현재 적용 유무
	private String dcinfDate;		// 시스템 등록일자
	
	public int getDcinfCode() {
		return dcinfCode;
	}
	public void setDcinfCode(int dcinfCode) {
		this.dcinfCode = dcinfCode;
	}
	public String getDcinfInfo() {
		return dcinfInfo;
	}
	public void setDcinfInfo(String dcinfInfo) {
		this.dcinfInfo = dcinfInfo;
	}
	public int getDcinfPrice() {
		return dcinfPrice;
	}
	public void setDcinfPrice(int dcinfPrice) {
		this.dcinfPrice = dcinfPrice;
	}
	public int getDcinfApplyYear() {
		return dcinfApplyYear;
	}
	public void setDcinfApplyYear(int dcinfApplyYear) {
		this.dcinfApplyYear = dcinfApplyYear;
	}
	public String getDcinfStatus() {
		return dcinfStatus;
	}
	public void setDcinfStatus(String dcinfStatus) {
		this.dcinfStatus = dcinfStatus;
	}
	public String getDcinfDate() {
		return dcinfDate;
	}
	public void setDcinfDate(String dcinfDate) {
		this.dcinfDate = dcinfDate;
	}
	
	@Override
	public String toString() {
		return "DiscountInfo [dcinfCode=" + dcinfCode + ", dcinfInfo=" + dcinfInfo + ", dcinfPrice=" + dcinfPrice
				+ ", dcinfApplyYear=" + dcinfApplyYear + ", dcinfStatus=" + dcinfStatus + ", dcinfDate=" + dcinfDate
				+ "]";
	}
	
	
}

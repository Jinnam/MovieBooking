package kr.co.cinema.dto;

// 인물 관련 dto
public class Character {

	private int charCode;					// 인물 코드
	private String charKorName;				// 한글 이름
	private String charEngName;				// 영문 이름
	private String charBirth;				// 생년월일
	private String charGender;				// 성별
	private String charFrofileImgPath;		// 프로필 사진 경로
	private String charNation;				// 국적
	private String charBioGraphy;			// 바이오 그래피(소개)
	private String charFinalModifyDate;		// 최종 수정 일자
	
	public int getCharCode() {
		return charCode;
	}
	public void setCharCode(int charCode) {
		this.charCode = charCode;
	}
	public String getCharKorName() {
		return charKorName;
	}
	public void setCharKorName(String charKorName) {
		this.charKorName = charKorName;
	}
	public String getCharEngName() {
		return charEngName;
	}
	public void setCharEngName(String charEngName) {
		this.charEngName = charEngName;
	}
	public String getCharBirth() {
		return charBirth;
	}
	public void setCharBirth(String charBirth) {
		this.charBirth = charBirth;
	}
	public String getCharGender() {
		return charGender;
	}
	public void setCharGender(String charGender) {
		this.charGender = charGender;
	}
	public String getCharFrofileImgPath() {
		return charFrofileImgPath;
	}
	public void setCharFrofileImgPath(String charFrofileImgPath) {
		this.charFrofileImgPath = charFrofileImgPath;
	}
	public String getCharNation() {
		return charNation;
	}
	public void setCharNation(String charNation) {
		this.charNation = charNation;
	}
	public String getCharBioGraphy() {
		return charBioGraphy;
	}
	public void setCharBioGraphy(String charBioGraphy) {
		this.charBioGraphy = charBioGraphy;
	}
	public String getCharFinalModifyDate() {
		return charFinalModifyDate;
	}
	public void setCharFinalModifyDate(String charFinalModifyDate) {
		this.charFinalModifyDate = charFinalModifyDate;
	}
	
	@Override
	public String toString() {
		return "Character [charCode=" + charCode + ", charKorName=" + charKorName + ", charEngName=" + charEngName
				+ ", charBirth=" + charBirth + ", charGender=" + charGender + ", charFrofileImgPath="
				+ charFrofileImgPath + ", charNation=" + charNation + ", charBioGraphy=" + charBioGraphy
				+ ", charFinalModifyDate=" + charFinalModifyDate + "]";
	}

	
}

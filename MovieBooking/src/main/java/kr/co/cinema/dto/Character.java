package kr.co.cinema.dto;

// �ι� ���� dto
public class Character {

	private int charCode;					// �ι� �ڵ�
	private String charKorName;				// �ѱ� �̸�
	private String charEngName;				// ���� �̸�
	private String charBirth;				// �������
	private String charGender;				// ����
	private String charFrofileImgPath;		// ������ ���� ���
	private String charNation;				// ����
	private String charBioGraphy;			// ���̿� �׷���(�Ұ�)
	private String charFinalModifyDate;		// ���� ���� ����
	
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

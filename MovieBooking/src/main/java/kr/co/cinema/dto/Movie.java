package kr.co.cinema.dto;

// ��ȭ  dto
public class Movie {

	private int mov_code;				// ��ȭ �ڵ�
	private String movKorName;			// ��ȭ �ѱ� ����
	private String movEngName;			// ��ȭ ���� ����
	private String movNation;			// ����
	private String movGrade;			// ���
	private String movGenre;			// �帣
	private String movMaker;			// ���ۻ�
	private String movRunningTime;		// ����Ÿ��
	private String movOpenDate;			// ������
	private String movInfoDetail;		// �󼼼���
	private String movImgPath;			// ����� �̹��� ���
	private String movVideoPath;		// ����(������) ���
	private String movStatus;			// ���� �� ����
	private String movFinalModifyDate;	// ���� ���� ����
	
	public int getMov_code() {
		return mov_code;
	}
	public void setMov_code(int mov_code) {
		this.mov_code = mov_code;
	}
	public String getMovKorName() {
		return movKorName;
	}
	public void setMovKorName(String movKorName) {
		this.movKorName = movKorName;
	}
	public String getMovEngName() {
		return movEngName;
	}
	public void setMovEngName(String movEngName) {
		this.movEngName = movEngName;
	}
	public String getMovNation() {
		return movNation;
	}
	public void setMovNation(String movNation) {
		this.movNation = movNation;
	}
	public String getMovGrade() {
		return movGrade;
	}
	public void setMovGrade(String movGrade) {
		this.movGrade = movGrade;
	}
	public String getMovGenre() {
		return movGenre;
	}
	public void setMovGenre(String movGenre) {
		this.movGenre = movGenre;
	}
	public String getMovMaker() {
		return movMaker;
	}
	public void setMovMaker(String movMaker) {
		this.movMaker = movMaker;
	}
	public String getMovRunningTime() {
		return movRunningTime;
	}
	public void setMovRunningTime(String movRunningTime) {
		this.movRunningTime = movRunningTime;
	}
	public String getMovOpenDate() {
		return movOpenDate;
	}
	public void setMovOpenDate(String movOpenDate) {
		this.movOpenDate = movOpenDate;
	}
	public String getMovInfoDetail() {
		return movInfoDetail;
	}
	public void setMovInfoDetail(String movInfoDetail) {
		this.movInfoDetail = movInfoDetail;
	}
	public String getMovImgPath() {
		return movImgPath;
	}
	public void setMovImgPath(String movImgPath) {
		this.movImgPath = movImgPath;
	}
	public String getMovVideoPath() {
		return movVideoPath;
	}
	public void setMovVideoPath(String movVideoPath) {
		this.movVideoPath = movVideoPath;
	}
	public String getMovStatus() {
		return movStatus;
	}
	public void setMovStatus(String movStatus) {
		this.movStatus = movStatus;
	}
	public String getMovFinalModifyDate() {
		return movFinalModifyDate;
	}
	public void setMovFinalModifyDate(String movFinalModifyDate) {
		this.movFinalModifyDate = movFinalModifyDate;
	}
	
	@Override
	public String toString() {
		return "Movie [mov_code=" + mov_code + ", movKorName=" + movKorName + ", movEngName=" + movEngName
				+ ", movNation=" + movNation + ", movGrade=" + movGrade + ", movGenre=" + movGenre + ", movMaker="
				+ movMaker + ", movRunningTime=" + movRunningTime + ", movOpenDate=" + movOpenDate + ", movInfoDetail="
				+ movInfoDetail + ", movImgPath=" + movImgPath + ", movVideoPath=" + movVideoPath + ", movStatus="
				+ movStatus + ", movFinalModifyDate=" + movFinalModifyDate + "]";
	}
	
	
}

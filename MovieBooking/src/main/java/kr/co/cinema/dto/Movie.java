package kr.co.cinema.dto;

// 영화  dto
public class Movie {

	private int mov_code;				// 영화 코드
	private String movKorName;			// 영화 한글 제목
	private String movEngName;			// 영화 영문 제목
	private String movNation;			// 국가
	private String movGrade;			// 등급
	private String movGenre;			// 장르
	private String movMaker;			// 제작사
	private String movRunningTime;		// 러닝타임
	private String movOpenDate;			// 개봉일
	private String movInfoDetail;		// 상세설명
	private String movImgPath;			// 썸네일 이미지 경로
	private String movVideoPath;		// 영상(예고편) 경로
	private String movStatus;			// 현재 상영 여부
	private String movFinalModifyDate;	// 최총 수정 일자
	
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

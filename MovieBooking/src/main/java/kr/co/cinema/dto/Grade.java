package kr.co.cinema.dto;

// 평점분석 dto
public class Grade {

	private int movCode;				// 영화코드
	private int graAcGrade;				// 총 누적 평점
	private int graTotalNum;			// 총 평가 인원 수
	private int graBeforeOpenGrade;		// 개봉 전 누적 평점
	private int graBeforeOpenNum;		// 개봉 전 평가 인원 수
	private int graVistorGrade;			// 관람객 누적 평점
	private int graVistorGradeNum;		// 관람객 평가 인원
	
	public int getMovCode() {
		return movCode;
	}
	public void setMovCode(int movCode) {
		this.movCode = movCode;
	}
	public int getGraAcGrade() {
		return graAcGrade;
	}
	public void setGraAcGrade(int graAcGrade) {
		this.graAcGrade = graAcGrade;
	}
	public int getGraTotalNum() {
		return graTotalNum;
	}
	public void setGraTotalNum(int graTotalNum) {
		this.graTotalNum = graTotalNum;
	}
	public int getGraBeforeOpenGrade() {
		return graBeforeOpenGrade;
	}
	public void setGraBeforeOpenGrade(int graBeforeOpenGrade) {
		this.graBeforeOpenGrade = graBeforeOpenGrade;
	}
	public int getGraBeforeOpenNum() {
		return graBeforeOpenNum;
	}
	public void setGraBeforeOpenNum(int graBeforeOpenNum) {
		this.graBeforeOpenNum = graBeforeOpenNum;
	}
	public int getGraVistorGrade() {
		return graVistorGrade;
	}
	public void setGraVistorGrade(int graVistorGrade) {
		this.graVistorGrade = graVistorGrade;
	}
	public int getGraVistorGradeNum() {
		return graVistorGradeNum;
	}
	public void setGraVistorGradeNum(int graVistorGradeNum) {
		this.graVistorGradeNum = graVistorGradeNum;
	}
	
	@Override
	public String toString() {
		return "Grade [movCode=" + movCode + ", graAcGrade=" + graAcGrade + ", graTotalNum=" + graTotalNum
				+ ", graBeforeOpenGrade=" + graBeforeOpenGrade + ", graBeforeOpenNum=" + graBeforeOpenNum
				+ ", graVistorGrade=" + graVistorGrade + ", graVistorGradeNum=" + graVistorGradeNum + "]";
	}
	
	

}

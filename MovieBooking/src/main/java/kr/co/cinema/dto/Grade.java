package kr.co.cinema.dto;

// �����м� dto
public class Grade {

	private int movCode;				// ��ȭ�ڵ�
	private int graAcGrade;				// �� ���� ����
	private int graTotalNum;			// �� �� �ο� ��
	private int graBeforeOpenGrade;		// ���� �� ���� ����
	private int graBeforeOpenNum;		// ���� �� �� �ο� ��
	private int graVistorGrade;			// ������ ���� ����
	private int graVistorGradeNum;		// ������ �� �ο�
	
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

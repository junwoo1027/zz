package com.company.domain;

public class Ticket {

	private int tno;
	private String onwer;
	private String grade;
	
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getOnwer() {
		return onwer;
	}
	public void setOnwer(String onwer) {
		this.onwer = onwer;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Ticket [tno=" + tno + ", onwer=" + onwer + ", grade=" + grade + "]";
	}
}

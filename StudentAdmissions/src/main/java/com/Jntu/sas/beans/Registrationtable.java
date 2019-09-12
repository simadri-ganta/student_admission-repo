package com.Jntu.sas.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Registrationtable {
	private int serial_no;
	@Id
	private String name;
	private String board;
	private String marks;
	private String gpa;
	private int percentage;
	private String school;
	private String department;
	private String college;
	private String college_choice2;
	private java.util.Date joindate = new java.util.Date();
	private String Status_application;
	public int getSerial_no() {
		return serial_no;
	}
	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getGpa() {
		return gpa;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCollege_choice2() {
		return college_choice2;
	}
	public void setCollege_choice2(String college_choice2) {
		this.college_choice2 = college_choice2;
	}
	public java.util.Date getJoindate() {
		return joindate;
	}
	public void setJoindate(java.util.Date joindate) {
		this.joindate = joindate;
	}
	public String getStatus_application() {
		return Status_application;
	}
	public void setStatus_application(String status_application) {
		Status_application = status_application;
	}
	@Override
	public String toString() {
		return Messages.getString("Registration_table.0") + serial_no + Messages.getString("Registration_table.1") + name + Messages.getString("Registration_table.2") + board + Messages.getString("Registration_table.3") + marks //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ Messages.getString("Registration_table.4") + gpa + Messages.getString("Registration_table.5") + percentage + Messages.getString("Registration_table.6") + school + Messages.getString("Registration_table.7") + department //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ Messages.getString("Registration_table.8") + college + Messages.getString("Registration_table.9") + college_choice2 + Messages.getString("Registration_table.10") + joindate //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ Messages.getString("Registration_table.11") + Status_application + Messages.getString("Registration_table.12"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	
	

}

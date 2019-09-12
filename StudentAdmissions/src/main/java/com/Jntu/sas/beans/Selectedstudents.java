package com.Jntu.sas.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Selectedstudents {
	@Id
	private String name;
	private String board;
	private String marks;
	private String gpa;
	private int percentage;
	private String school;
	private String department;
	private String alloteddepartment;
	private String collegename;
	private String collegecode;
	private Date joineddate;

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

	public String getAlloteddepartment() {
		return alloteddepartment;
	}

	public void setAlloteddepartment(String alloteddepartment) {
		this.alloteddepartment = alloteddepartment;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getCollegecode() {
		return collegecode;
	}

	public void setCollegecode(String collegecode) {
		this.collegecode = collegecode;
	}

	public Date getJoineddate() {
		return joineddate;
	}

	public void setJoineddate(Date joineddate) {
		this.joineddate = joineddate;
	}

	@Override
	public String toString() {
		return Messages.getString("Selected_students.0") + name + Messages.getString("Selected_students.1") + board + Messages.getString("Selected_students.2") + marks + Messages.getString("Selected_students.3") + gpa //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ Messages.getString("Selected_students.4") + percentage + Messages.getString("Selected_students.5") + school + Messages.getString("Selected_students.6") + department //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ Messages.getString("Selected_students.7") + alloteddepartment + Messages.getString("Selected_students.8") + collegename + Messages.getString("Selected_students.9") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ collegecode + Messages.getString("Selected_students.10") + joineddate + Messages.getString("Selected_students.11"); //$NON-NLS-1$ //$NON-NLS-2$
	}

}

package com.jntu.sas.beans;

import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Registration {
	@Id
	private String name;
	private String board;
	private String marks;
	private String gpa;
	private int percentage;
	private String school;
	private String department;
	private String firstCollege;
	private String secondCollege;
	private Date joinDate = new Date();
	private String applicationStatus;

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

	public String getFirstCollege() {
		return firstCollege;
	}

	public void setFirstCollege(String firstCollege) {
		this.firstCollege = firstCollege;
	}

	public String getSecondCollege() {
		return secondCollege;
	}

	public void setSecondCollege(String secondCollege) {
		this.secondCollege = secondCollege;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

}

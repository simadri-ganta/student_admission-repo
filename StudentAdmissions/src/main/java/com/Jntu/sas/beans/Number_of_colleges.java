package com.Jntu.sas.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Number_of_colleges {
	private String college_name;
	@Id
	private String college_code;
	private String college_rank;
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public String getCollege_code() {
		return college_code;
	}
	public void setCollege_code(String college_code) {
		this.college_code = college_code;
	}
	public String getCollege_rank() {
		return college_rank;
	}
	public void setCollege_rank(String college_rank) {
		this.college_rank = college_rank;
	}
	@Override
	public String toString() {
		return "Number_of_colleges [college_name=" + college_name + ", college_code=" + college_code + ", college_rank="
				+ college_rank + "]";
	}

}

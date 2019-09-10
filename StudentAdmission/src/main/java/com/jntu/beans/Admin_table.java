package com.jntu.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "admin_table")
public class Admin_table { 
	@Id
	private String id;
	private String pass;
	@OneToOne
	private Number_of_colleges admin;
	
	
	public Number_of_colleges getAdmin() {
		return admin;
	}
	public void setAdmin(Number_of_colleges admin) {
		this.admin = admin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Admin_table [id=" + id +" college_code ="+ admin +", pass=" + pass + "]";
	}





}

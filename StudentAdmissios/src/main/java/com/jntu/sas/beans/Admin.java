package com.jntu.sas.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Admin {
	@Id
	private String userId;
	private String Password;
	@OneToOne
	private College admin;

	public College getAdmin() {
		return admin;
	}

	public void setAdmin(College admin) {
		this.admin = admin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}

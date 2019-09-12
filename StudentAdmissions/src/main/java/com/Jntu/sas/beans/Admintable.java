package com.Jntu.sas.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "admin_table")
public class Admintable {
	@Id
	private String id;
	private String pass;
	@OneToOne
	private Numberofcolleges admin;

	public Numberofcolleges getAdmin() {
		return admin;
	}

	public void setAdmin(Numberofcolleges admin) {
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
		return Messages.getString("Admin_table.0") + id + Messages.getString("Admin_table.1") + admin + Messages.getString("Admin_table.2") + pass + Messages.getString("Admin_table.3"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

}

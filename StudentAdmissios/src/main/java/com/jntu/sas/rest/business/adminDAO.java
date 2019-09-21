package com.jntu.sas.rest.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jntu.sas.beans.Admin;
import com.jntu.sas.beans.College;
import com.jntu.sas.repositories.AdminRepo;

public class adminDAO {
	@Autowired
	AdminRepo adminRepo;
	@Autowired 
	Admin admin;
	@SuppressWarnings("unused") void extract(College college_entity) {
		admin.setUserId(college_entity.getName() + college_entity.getCode());
		admin.setPassword(college_entity.getRank() + college_entity.getCode() + college_entity.getCode());
		admin.setAdmin(college_entity);
		adminRepo.save(admin);
	}
	public Optional<Admin> extracted(Admin list) {
		return adminRepo.findById(list.getUserId());
	}

}

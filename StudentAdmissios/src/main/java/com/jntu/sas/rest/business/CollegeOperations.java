package com.jntu.sas.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jntu.sas.beans.College;
import com.jntu.sas.repositories.CollegeRepo;

@Component
public class CollegeOperations {
	@Autowired
	CollegeRepo collegeRepo;
	@Autowired
	adminDAO admin;

	public void extracted(College college_entity) {
		collegeRepo.save(college_entity);
		admin.extract(college_entity);
	}

}

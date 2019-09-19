package com.jntu.sas.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.sas.beans.Admin;
import com.jntu.sas.beans.College;
import com.jntu.sas.repositories.Admintablerepo;
import com.jntu.sas.repositories.NumberOfCollegesRepo;

@RestController
@RequestMapping("/adcollege")
public class AddCollege {
	@Autowired
	Admintablerepo adminRepo;
	@Autowired
	NumberOfCollegesRepo collegeRepo;
	@Autowired
	Admin admin;

	@PutMapping(value = "/")
	public ArrayList<String> meth(@RequestBody College college_entity) {
		ArrayList<String> list1 = new ArrayList<>();
		collegeRepo.save(college_entity);
		admin.setUserId(college_entity.getName() + college_entity.getCode());
		admin.setPassword(
				college_entity.getRank() + college_entity.getCode() + college_entity.getCode());
		admin.setAdmin(college_entity);
		adminRepo.save(admin);
		list1.add("done"); //$NON-NLS-1$
		return list1;

	}

}
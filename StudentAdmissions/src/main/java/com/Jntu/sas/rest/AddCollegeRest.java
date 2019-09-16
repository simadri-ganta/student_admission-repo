package com.Jntu.sas.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Admintable;
import com.Jntu.sas.beans.Numberofcolleges;
import com.Jntu.sas.repositories.Admintablerepo;
import com.Jntu.sas.repositories.NumberOfCollegesRepo;

@RestController
@RequestMapping("/adcollege")
public class AddCollegeRest {
	@Autowired
	Admintablerepo admin_repo;
	@Autowired
	NumberOfCollegesRepo college_repo;
	@Autowired
	Admintable admin_entity;

	@PutMapping(value = "/")
	public ArrayList<String> meth(@RequestBody Numberofcolleges college_entity) {
		ArrayList<String> list1 = new ArrayList<>();
		college_repo.save(college_entity);
		admin_entity.setId(college_entity.getCollege_name() + college_entity.getCollege_code());
		admin_entity.setPass(
				college_entity.getCollege_rank() + college_entity.getCollege_code() + college_entity.getCollege_code());
		admin_entity.setAdmin(college_entity);
		admin_repo.save(admin_entity);
		list1.add(Messages.getString("AddCollege_rest.0")); //$NON-NLS-1$
		return list1;

	}

}
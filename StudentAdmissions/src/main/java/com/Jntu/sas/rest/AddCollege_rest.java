package com.Jntu.sas.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Admin_table;
import com.Jntu.sas.beans.Number_of_colleges;
import com.Jntu.sas.repositories.Admin_table_repo;
import com.Jntu.sas.repositories.Number_of_colleges_repo;

@RestController
@RequestMapping("/adcollege")
public class AddCollege_rest {
	@Autowired
	Admin_table_repo admin_repo;
	@Autowired
	Number_of_colleges_repo college_repo;
	@Autowired
	Admin_table admin_entity;
	@Autowired
	Number_of_colleges college_entity;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ArrayList<String> meth(@RequestBody ArrayList<String> list) {
		System.out.println(" ciming" + list.toString());
		ArrayList<String> list1 = new ArrayList<>();
		college_entity.setCollege_name(list.get(0));
		college_entity.setCollege_code(list.get(1));
		college_entity.setCollege_rank(list.get(2));
		college_repo.save(college_entity);
		admin_entity.setId(list.get(0) + list.get(1));
		admin_entity.setPass(list.get(2) + list.get(0) + list.get(1));
		admin_entity.setAdmin(college_entity);
		admin_repo.save(admin_entity);
		list1.add("done");
		return list1;

	}

}
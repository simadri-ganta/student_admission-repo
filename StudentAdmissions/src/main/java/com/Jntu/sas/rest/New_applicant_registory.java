package com.Jntu.sas.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Registration_table;
import com.Jntu.sas.repositories.Registration_table_repo;

@RestController
@RequestMapping("/new_applicantion")
public class New_applicant_registory {
	@Autowired
	Registration_table_repo registeration_repo;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ArrayList<String> meth(@RequestBody Registration_table registeration_entity) {
		registeration_entity.setStatus_application("pending");
		registeration_repo.save(registeration_entity);
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("done");
		return list1;
	}
}
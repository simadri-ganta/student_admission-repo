package com.jntu.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.beans.Registration_table;
import com.jntu.repositories.Registration_table_repo;

@RestController
@RequestMapping("/new_applicantion")
public class New_applicant_registory {
	@Autowired
	Registration_table registeration_entity;
	@Autowired
	Registration_table_repo registeration_repo;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ArrayList<String> meth(@RequestBody ArrayList<String> list) {
		System.out.println(" ciming" + list.toString());
		registeration_entity.setName(list.get(0));
		registeration_entity.setBoard(list.get(1));
		registeration_entity.setMarks(list.get(2));
		registeration_entity.setGpa(list.get(3));
		registeration_entity.setPercentage(Integer.valueOf(list.get(4)));
		registeration_entity.setSchool(list.get(5));
		registeration_entity.setDepartment(list.get(6));
		registeration_entity.setCollege(list.get(7));
		registeration_entity.setCollege_choice2(list.get(8));
		registeration_entity.setStatus_application("pending");
		registeration_repo.save(registeration_entity);
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("done");
		return list1;
	}
}
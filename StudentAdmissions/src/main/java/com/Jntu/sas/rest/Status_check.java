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
@RequestMapping("/Status_check")
public class Status_check {
	@Autowired
	Registration_table registeration_entity;
	@Autowired
	Registration_table_repo registeration_repo;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ArrayList<String> meth(@RequestBody Registration_table studentdetails) {
		ArrayList<String> list1 = new ArrayList<>();
		if (registeration_repo.findById(studentdetails.getName()) != null) {
			Registration_table databasedetails = registeration_repo.findById(studentdetails.getName()).get();
			if (databasedetails.getBoard().equals(studentdetails.getBoard()) && databasedetails.getGpa().equals(studentdetails.getGpa())
					&& databasedetails.getPercentage() == studentdetails.getPercentage()) {
				list1.add(databasedetails.getStatus_application());
				list1.add(databasedetails.getCollege_choice2());
			} else {
				list1.add("pass_wrong");
			}
		} else {
			list1.add("user_invalid");
		}
		return list1;
	}

}
package com.Jntu.sas.rest;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Registration_table;
import com.Jntu.sas.repositories.Registration_table_repo;

@RestController
@RequestMapping("changeapplication")
public class Secondchoice {

	@Autowired
	Registration_table registeration_entity;
	@Autowired
	Registration_table_repo registeration_repo;

	@RequestMapping(value = "/{name}/{code}/", method = RequestMethod.GET)
	public ArrayList<String> meth(@PathVariable String name,@PathVariable String code) {
		registeration_entity=registeration_repo.findById(name).get();
		registeration_entity.setCollege(code);
		registeration_entity.setStatus_application("pending");
		registeration_entity.setCollege_choice2(null);
		registeration_repo.save(registeration_entity);
		ArrayList<String> list =new ArrayList<String>();
		list.add("done");
		
		return list;

	}
}

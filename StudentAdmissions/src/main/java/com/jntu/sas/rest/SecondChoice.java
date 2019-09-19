package com.jntu.sas.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.sas.beans.Registration;
import com.jntu.sas.repositories.RegistrationTableRepo;

@RestController
@RequestMapping("changeapplication")
public class SecondChoice {

	@Autowired
	Registration registeration_entity;
	@Autowired
	RegistrationTableRepo registeration_repo;

	@GetMapping(value = "/{name}/{code}/")
	public ArrayList<String> meth(@PathVariable String name, @PathVariable String code) {
		registeration_entity = registeration_repo.findById(name).get();
		registeration_entity.setFirstCollege(code);
		registeration_entity.setApplicationStatus(Messages.getString("Secondchoice.0")); //$NON-NLS-1$
		registeration_entity.setSecondCollege(null);
		registeration_repo.save(registeration_entity);
		ArrayList<String> list = new ArrayList<String>();
		list.add(Messages.getString("Secondchoice.1")); //$NON-NLS-1$

		return list;

	}
}

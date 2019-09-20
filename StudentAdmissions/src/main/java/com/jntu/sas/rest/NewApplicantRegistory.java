package com.jntu.sas.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.sas.beans.Registration;
import com.jntu.sas.repositories.RegisterationRepo;

@RestController
@RequestMapping("/new_applicantion")
public class NewApplicantRegistory {
	@Autowired
	RegisterationRepo registeration_repo;

	@PostMapping(value = "/")
	public ArrayList<String> meth(@RequestBody Registration registeration_entity) {
		registeration_entity.setApplicationStatus(Messages.getString("New_applicant_registory.0")); //$NON-NLS-1$
		registeration_repo.save(registeration_entity);
		ArrayList<String> list1 = new ArrayList<>();
		list1.add(Messages.getString("New_applicant_registory.1")); //$NON-NLS-1$
		return list1;
	}
}
package com.Jntu.sas.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Registrationtable;
import com.Jntu.sas.repositories.RegistrationTableRepo;

@RestController
@RequestMapping("/new_applicantion")
public class NewApplicantRegistory {
	@Autowired
	RegistrationTableRepo registeration_repo;

	@PostMapping(value = "/")
	public ArrayList<String> meth(@RequestBody Registrationtable registeration_entity) {
		registeration_entity.setStatus_application(Messages.getString("New_applicant_registory.0")); //$NON-NLS-1$
		registeration_repo.save(registeration_entity);
		ArrayList<String> list1 = new ArrayList<>();
		list1.add(Messages.getString("New_applicant_registory.1")); //$NON-NLS-1$
		return list1;
	}
}
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
@RequestMapping("/Status_check")
public class StatusCheck {
	@Autowired
	Registrationtable registeration_entity;
	@Autowired
	RegistrationTableRepo registeration_repo;

	@PostMapping(value = "/")
	public ArrayList<String> meth(@RequestBody Registrationtable studentdetails) {
		ArrayList<String> list1 = new ArrayList<>();
		if (registeration_repo.findById(studentdetails.getName()) != null) {
			Registrationtable databasedetails = registeration_repo.findById(studentdetails.getName()).get();
			if (databasedetails.getBoard().equals(studentdetails.getBoard()) && databasedetails.getGpa().equals(studentdetails.getGpa())
					&& databasedetails.getPercentage() == studentdetails.getPercentage()) {
				list1.add(databasedetails.getStatus_application());
				list1.add(databasedetails.getCollege_choice2());
			} else {
				list1.add(Messages.getString("Status_check.0")); //$NON-NLS-1$
			}
		} else {
			list1.add(Messages.getString("Status_check.1")); //$NON-NLS-1$
		}
		return list1;
	}

}
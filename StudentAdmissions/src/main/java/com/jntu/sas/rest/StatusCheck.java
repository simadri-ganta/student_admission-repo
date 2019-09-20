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
@RequestMapping("/Status_check")
public class StatusCheck {
	@Autowired
	Registration registeration_entity;
	@Autowired
	RegisterationRepo registeration_repo;

	@PostMapping(value = "/")
	public ArrayList<String> meth(@RequestBody Registration studentDetails) {
		ArrayList<String> list1 = new ArrayList<>();
		if (registeration_repo.findById(studentDetails.getName()) != null) {
			Registration databasedetails = registeration_repo.findById(studentDetails.getName()).get();
			if (databasedetails.getBoard().equals(studentDetails.getBoard()) && databasedetails.getGpa().equals(studentDetails.getGpa())
					&& databasedetails.getPercentage() == studentDetails.getPercentage()) {
				list1.add(databasedetails.getApplicationStatus());
				list1.add(databasedetails.getSecondCollege());
			} else {
				list1.add(Messages.getString("Status_check.0")); //$NON-NLS-1$
			}
		} else {
			list1.add(Messages.getString("Status_check.1")); //$NON-NLS-1$
		}
		return list1;
	}

}
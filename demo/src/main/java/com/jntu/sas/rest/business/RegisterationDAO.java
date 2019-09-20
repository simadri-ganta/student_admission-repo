package com.jntu.sas.rest.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jntu.sas.beans.Registration;
import com.jntu.sas.repositories.RegisterationRepo1;

public class RegisterationDAO {
	@Autowired
	Registration registeration;
	@Autowired
	RegisterationRepo1 registerationRepo;

	@SuppressWarnings("unused")
	public List<Registration> studentsList() {
		return registerationRepo.findAllByOrderByJoinDateAsc();
	}

	public List<Registration> StudentsList() {
		return registerationRepo.findAllByOrderByPercentageDesc();
	}

	public Optional<Registration> find(String name) {
		return registerationRepo.findById(name);
	}

	public void insert(Registration registration) {
		registerationRepo.save(registration);
	}

}

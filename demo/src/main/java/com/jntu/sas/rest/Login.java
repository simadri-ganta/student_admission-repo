package com.jntu.sas.rest;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.sas.beans.Admin;
import com.jntu.sas.exceptions.InValidCredentials;
import com.jntu.sas.exceptions.UnAuthorizedException;
import com.jntu.sas.repositories.AdminRepo;
import com.jntu.sas.repositories.RegisterationRepo;
import com.jntu.sas.repositories.StudentsRepo;

@RestController
@RequestMapping("/login")
public class Login {
	@Autowired
	AdminRepo repo;
	@Autowired
	RegisterationRepo regsiteration_repo;
	@Autowired
	StudentsRepo selected_repo;

	@PostMapping(value = "/")
	public ArrayList<String> meth(@RequestBody Admin list) {
		ArrayList<String> list1 = new ArrayList<>();
		Optional<Admin> object = repo.findById(list.getUserId());
		if (object.isEmpty()) {
			throw new UnAuthorizedException("invalid user");
		}
		object.ifPresent(Admin_table -> {
			if (Admin_table.getPassword().equals(list.getPassword())) {
				list1.add(Messages.getString("login.1")); //$NON-NLS-1$
				list1.add(Admin_table.getAdmin().getCode());
				if (!Admin_table.getAdmin().getCode().equals(Messages.getString("login.2"))) { //$NON-NLS-1$
					list1.add(regsiteration_repo.countByCollege(Admin_table.getAdmin().getCode()).get(0)
							.toString());
					list1.add(selected_repo.countByCollegecode(Admin_table.getAdmin().getCode()).get(0)
							.toString());
				}
			} else

				throw new InValidCredentials("wrong pass");

		});
		return list1;

	}

}
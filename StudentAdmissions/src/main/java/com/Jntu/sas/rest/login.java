package com.Jntu.sas.rest;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Admintable;
import com.Jntu.sas.repositories.Admintablerepo;
import com.Jntu.sas.repositories.RegistrationTableRepo;
import com.Jntu.sas.repositories.SelectedStudentsRepo;

@RestController
@RequestMapping("/login")
public class Login{
	@Autowired
	Admintablerepo repo;
	@Autowired
	RegistrationTableRepo regsiteration_repo;
	@Autowired
	SelectedStudentsRepo selected_repo;

	@PostMapping(value = "/")
	public ArrayList<String> meth(@RequestBody Admintable list){
		System.out.println(Messages.getString("login.0") + list.toString()); //$NON-NLS-1$
		ArrayList<String> list1 = new ArrayList<>();
		Optional<Admintable> object = repo.findById(list.getId());
		object.ifPresent(Admin_table -> {
			if (Admin_table.getPass().equals(list.getPass())) {
				list1.add(Messages.getString("login.1")); //$NON-NLS-1$
				list1.add(Admin_table.getAdmin().getCollege_code());
				if (!Admin_table.getAdmin().getCollege_code().equals(Messages.getString("login.2"))) { //$NON-NLS-1$
					list1.add(regsiteration_repo.countByCollege(Admin_table.getAdmin().getCollege_code()).get(0)
							.toString());
					list1.add(selected_repo.countByCollegecode(Admin_table.getAdmin().getCollege_code()).get(0)
							.toString());
				}
			} else
				list1.add(Messages.getString("login.3")); //$NON-NLS-1$

		});
		return list1;

	}

}
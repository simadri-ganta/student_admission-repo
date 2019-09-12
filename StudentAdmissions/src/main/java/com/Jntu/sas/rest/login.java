package com.Jntu.sas.rest;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Admin_table;
import com.Jntu.sas.repositories.Admin_table_repo;
import com.Jntu.sas.repositories.Registration_table_repo;
import com.Jntu.sas.repositories.Selected_students_repo;

@RestController
@RequestMapping("/login")
public class login{
	@Autowired
	Admin_table_repo repo;
	@Autowired
	Registration_table_repo regsiteration_repo;
	@Autowired
	Selected_students_repo selected_repo;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ArrayList<String> meth(@RequestBody Admin_table list){
		System.out.println(" ciming" + list.toString());
		ArrayList<String> list1 = new ArrayList<>();
		Optional<Admin_table> object = repo.findById(list.getId());
		object.ifPresent(Admin_table -> {
			if (Admin_table.getPass().equals(list.getPass())) {
				list1.add("valid");
				list1.add(Admin_table.getAdmin().getCollege_code());
				if (!Admin_table.getAdmin().getCollege_code().equals("admin")) {
					list1.add(regsiteration_repo.countByCollege(Admin_table.getAdmin().getCollege_code()).get(0)
							.toString());
					list1.add(selected_repo.countByCollegecode(Admin_table.getAdmin().getCollege_code()).get(0)
							.toString());
				}
			} else
				list1.add("invalid");

		});
		return list1;

	}

}
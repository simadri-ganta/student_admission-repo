package com.Jntu.sas.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Selectedstudents;
import com.Jntu.sas.repositories.SelectedStudentsRepo;

@RestController
@RequestMapping("departmentwise_request")
public class DepartmentwiseRequestRepo {
	@Autowired
	SelectedStudentsRepo selected_students_repo;

	@GetMapping(value = "/{code}")
	public ArrayList<List<Selectedstudents>> meth(@PathVariable String code) {
		List<Selectedstudents> cse = selected_students_repo.findAllByCollegecodeAndAlloteddepartment(code, Messages.getString("departmentwise_request_repo.0")); //$NON-NLS-1$
		List<Selectedstudents> ece = selected_students_repo.findAllByCollegecodeAndAlloteddepartment(code, Messages.getString("departmentwise_request_repo.1")); //$NON-NLS-1$
		List<Selectedstudents> it = selected_students_repo.findAllByCollegecodeAndAlloteddepartment(code, Messages.getString("departmentwise_request_repo.2")); //$NON-NLS-1$
		List<Selectedstudents> mech = selected_students_repo.findAllByCollegecodeAndAlloteddepartment(code, Messages.getString("departmentwise_request_repo.3")); //$NON-NLS-1$
		ArrayList<List<Selectedstudents>> list1 = new ArrayList<>();
		list1.add(cse);
		list1.add(ece);
		list1.add(it);
		list1.add(mech);
		return list1;
	}
}

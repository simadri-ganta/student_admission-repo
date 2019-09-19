package com.jntu.sas.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.sas.beans.Student;
import com.jntu.sas.repositories.SelectedStudentsRepo;

@RestController
@RequestMapping("departmentwise_request")
public class DepartmentWiseList {
	@Autowired
	SelectedStudentsRepo selected_students_repo;

	@GetMapping(value = "/{code}")
	public ArrayList<List<Student>> meth(@PathVariable String code) {
		List<Student> cse = selected_students_repo.findAllByCollegecodeAndAlloteddepartment(code, "cse");
		List<Student> ece = selected_students_repo.findAllByCollegecodeAndAlloteddepartment(code, "ece");
		List<Student> it = selected_students_repo.findAllByCollegecodeAndAlloteddepartment(code, "it");
		List<Student> mech = selected_students_repo.findAllByCollegecodeAndAlloteddepartment(code, "mech");
		ArrayList<List<Student>> list1 = new ArrayList<>();
		list1.add(cse);
		list1.add(ece);
		list1.add(it);
		list1.add(mech);
		return list1;
	}
}

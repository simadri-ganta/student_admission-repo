package com.jntu.sas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.sas.beans.Student;
import com.jntu.sas.repositories.StudentsRepo;

@RestController
@RequestMapping("/top10")
public class Topstudents {
	@Autowired
	Student selected_entity;
	@Autowired
	StudentsRepo selected_student_repo;

	@GetMapping(value = "/{code}")
	public List<Student> meth(@PathVariable String code) {

		List<Student> list = selected_student_repo.findTop5ByCollegecode(code,
				new Sort(Sort.Direction.DESC, Messages.getString("Topstudents.0"))); //$NON-NLS-1$

		return list;
	}
}
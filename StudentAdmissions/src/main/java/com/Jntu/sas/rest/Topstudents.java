package com.Jntu.sas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Selectedstudents;
import com.Jntu.sas.repositories.SelectedStudentsRepo;

@RestController
@RequestMapping("/top10")
public class Topstudents {
	@Autowired
	Selectedstudents selected_entity;
	@Autowired
	SelectedStudentsRepo selected_student_repo;

	@GetMapping(value = "/{code}")
	public List<Selectedstudents> meth(@PathVariable String code) {

		List<Selectedstudents> list = selected_student_repo.findTop5ByCollegecode(code,
				new Sort(Sort.Direction.DESC, Messages.getString("Topstudents.0"))); //$NON-NLS-1$

		return list;
	}
}
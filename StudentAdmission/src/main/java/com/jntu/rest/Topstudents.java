package com.jntu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.beans.Selected_students;
import com.jntu.repositories.Selected_students_repo;

@RestController
@RequestMapping("/top10")
public class Topstudents {
	@Autowired
	Selected_students selected_entity;
	@Autowired
	Selected_students_repo selected_student_repo;

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public List<Selected_students> meth(@PathVariable String code) {
		
		List<Selected_students> list = selected_student_repo.findTop5ByCollegecode(code, new Sort(Sort.Direction.DESC, "percentage"));
		
		
		
		
		return list;
	}
}
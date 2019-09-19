package com.jntu.sas.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.sas.beans.College;
import com.jntu.sas.repositories.NumberOfCollegesRepo;

@RestController
@RequestMapping("/getcollegelist")
public class GetCollegeList {
	@Autowired
	College college;
	@Autowired
	NumberOfCollegesRepo collegRepo;

	@GetMapping(value = "/")
	public ArrayList<String> meth() {
		ArrayList<String> list1 = new ArrayList<>();
		List<College> values = collegRepo.findAll();
		Iterator<College> iter = values.iterator();
		iter.next();
		while (iter.hasNext()) {
			College college = iter.next();
			list1.add(college.getCode());
			list1.add(college.getName());
		}
		return list1;

	}

}

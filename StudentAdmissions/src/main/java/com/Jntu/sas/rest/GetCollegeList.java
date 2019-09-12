package com.Jntu.sas.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Numberofcolleges;
import com.Jntu.sas.repositories.NumberOfCollegesRepo;

@RestController
@RequestMapping("/getcollegelist")
public class GetCollegeList {
	@Autowired
	Numberofcolleges college_entity;
	@Autowired
	NumberOfCollegesRepo college_repo;

	@GetMapping(value = "/")
	public ArrayList<String> meth() {
		ArrayList<String> list1 = new ArrayList<>();
		List<Numberofcolleges> values = college_repo.findAll();
		Iterator<Numberofcolleges> iter = values.iterator();
		iter.next();
		while (iter.hasNext()) {
			Numberofcolleges college_record = iter.next();
			list1.add(college_record.getCollege_code());
			list1.add(college_record.getCollege_name());
		}
		return list1;

	}

}

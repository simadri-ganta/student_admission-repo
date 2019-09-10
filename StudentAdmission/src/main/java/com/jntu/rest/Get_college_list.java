package com.jntu.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.beans.Number_of_colleges;
import com.jntu.repositories.Number_of_colleges_repo;

@RestController
@RequestMapping("/getcollegelist")
public class Get_college_list {
	@Autowired
	Number_of_colleges college_entity;
	@Autowired
	Number_of_colleges_repo college_repo;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ArrayList<String> meth() {
		System.out.println(" ciming");
		ArrayList<String> list1 = new ArrayList<>();
		List<Number_of_colleges> values = college_repo.findAll();

		Iterator<Number_of_colleges> iter = values.iterator();
		iter.next();
		while (iter.hasNext()) {
			Number_of_colleges college_record = iter.next();
			list1.add(college_record.getCollege_code());
			list1.add(college_record.getCollege_name());
		}

		System.out.println(list1.toString());
		return list1;

	}

}

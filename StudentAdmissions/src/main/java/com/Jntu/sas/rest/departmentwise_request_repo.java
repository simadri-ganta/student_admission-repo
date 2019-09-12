package com.Jntu.sas.rest;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Selected_students;
import com.Jntu.sas.repositories.Selected_students_repo;

@RestController
@RequestMapping("departmentwise_request")
public class departmentwise_request_repo {
	@Autowired
	Selected_students_repo selected_students_repo;
	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public ArrayList<List<Selected_students>> meth(@PathVariable String code) {
	List<Selected_students> cse = selected_students_repo.findAllByCollegecodeAndAlloteddepartment(code, "cse");
	System.out.println(cse);
	List<Selected_students> ece = selected_students_repo.findAllByCollegecodeAndAlloteddepartment(code, "ece");
	System.out.println(ece);
	List<Selected_students> it = selected_students_repo.findAllByCollegecodeAndAlloteddepartment(code, "it");
	System.out.println(it);
	List<Selected_students> mech = selected_students_repo.findAllByCollegecodeAndAlloteddepartment(code, "mech");
	System.out.println(mech);
	ArrayList<List<Selected_students>> list1=new ArrayList<>(); 
	list1.add(cse);
	list1.add(ece);
	list1.add(it);
	list1.add(mech);
	return list1;
	}
}

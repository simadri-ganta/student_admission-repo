package com.jntu.sas.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.sas.beans.College;
import com.jntu.sas.beans.Registration;
import com.jntu.sas.beans.Student;
import com.jntu.sas.repositories.CollegeRepo;
import com.jntu.sas.repositories.RegisterationRepo;
import com.jntu.sas.repositories.StudentsRepo;

@RestController
@RequestMapping("")
public class StudentOperations {
	@Autowired
	StudentsRepo selected_students_repo;
	@Autowired
	Registration registeration_entity;
	@Autowired
	RegisterationRepo registeration_repo;
	@Autowired
	Registration registeration;
	@Autowired
	RegisterationRepo registerationRepo;
	@Autowired
	College college;
	@Autowired
	CollegeRepo collegRepo;

	@GetMapping(value = "getcollegelist/")
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

	@PostMapping(value = "new_applicantion/")
	public ArrayList<String> method(@RequestBody Registration registeration_entity) {
		registeration_entity.setApplicationStatus(Messages.getString("New_applicant_registory.0")); //$NON-NLS-1$
		registerationRepo.save(registeration_entity);
		ArrayList<String> list1 = new ArrayList<>();
		list1.add(Messages.getString("New_applicant_registory.1"));
		return list1;
	}

	@GetMapping(value = "changeapplication/{name}/{code}/")
	public ArrayList<String> meth(@PathVariable String name, @PathVariable String code) {
		registeration = registerationRepo.findById(name).get();
		registeration.setFirstCollege(code);
		registeration.setApplicationStatus("pending"); //$NON-NLS-1$
		registeration.setSecondCollege(null);
		registerationRepo.save(registeration);
		ArrayList<String> list = new ArrayList<String>();
		list.add("done"); //$NON-NLS-1$

		return list;

	}

	@PostMapping(value = "Status_check/")
	public ArrayList<String> meth(@RequestBody Registration studentDetails) {
		ArrayList<String> list1 = new ArrayList<>();
		if (registeration_repo.findById(studentDetails.getName()) != null) {
			Registration databasedetails = registeration_repo.findById(studentDetails.getName()).get();
			if (databasedetails.getBoard().equals(studentDetails.getBoard())
					&& databasedetails.getGpa().equals(studentDetails.getGpa())
					&& databasedetails.getPercentage() == studentDetails.getPercentage()) {
				list1.add(databasedetails.getApplicationStatus());
				list1.add(databasedetails.getSecondCollege());
			} else {
				list1.add(Messages.getString("Status_check.0")); //$NON-NLS-1$
			}
		} else {
			list1.add(Messages.getString("Status_check.1")); //$NON-NLS-1$
		}
		return list1;
	}

	@GetMapping(value = "departmentwise_request/{code}")
	public ArrayList<List<Student>> meth(@PathVariable String code) {
		List<Student> cse = selected_students_repo.findAllByCollegeCodeAndAllotedDepartment(code, "cse");
		List<Student> ece = selected_students_repo.findAllByCollegeCodeAndAllotedDepartment(code, "ece");
		List<Student> it = selected_students_repo.findAllByCollegeCodeAndAllotedDepartment(code, "it");
		List<Student> mech = selected_students_repo.findAllByCollegeCodeAndAllotedDepartment(code, "mech");
		ArrayList<List<Student>> list1 = new ArrayList<>();
		list1.add(cse);
		list1.add(ece);
		list1.add(it);
		list1.add(mech);
		return list1;
	}
}

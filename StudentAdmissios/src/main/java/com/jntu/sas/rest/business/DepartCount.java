package com.jntu.sas.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.jntu.sas.beans.Student;
import com.jntu.sas.repositories.StudentsRepo;

@Service
@EnableAutoConfiguration
public class DepartCount {
	@Autowired
	StudentsRepo selected_student_repo;
	@Autowired
	Student selected_student_entity;

	public int cse(String code) {
		int count1 = selected_student_repo.countByCollegeCodeAndAllotedDepartment(code, "cse").get(0); 
		System.out.println(count1);
		return count1;

	}

	public int ece(String code) {
		int count2 = selected_student_repo.countByCollegeCodeAndAllotedDepartment(code, "ece").get(0);
		System.out.println(count2);
		return count2;
	}

	public int it(String code) {
		int count3 = selected_student_repo.countByCollegeCodeAndAllotedDepartment(code, "it").get(0); //$NON-NLS-1$
		System.out.println(count3);
		return count3;
	}

	public int mech(String code) {
		int count4 = selected_student_repo.countByCollegeCodeAndAllotedDepartment(code, "mech").get(0); //$NON-NLS-1$
		System.out.println(count4);

		return count4;
	}

}

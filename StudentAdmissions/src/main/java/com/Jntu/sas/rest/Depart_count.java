package com.Jntu.sas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.Jntu.sas.beans.Selected_students;
import com.Jntu.sas.repositories.Selected_students_repo;

@Service
@EnableAutoConfiguration
public class Depart_count {
	@Autowired
	Selected_students_repo selected_student_repo;
	@Autowired
	Selected_students selected_student_entity;

	public int cse(String code) {
		int count1 = selected_student_repo.countByCollegecodeAndAlloteddepartment(code, "cse").get(0);
		System.out.println(count1);
		return count1;

	}

	public int ece(String code) {
		int count2 = selected_student_repo.countByCollegecodeAndAlloteddepartment(code, "ece").get(0);
		System.out.println(count2);
		return count2;
	}

	public int it(String code) {
		int count3 = selected_student_repo.countByCollegecodeAndAlloteddepartment(code, "it").get(0);
		System.out.println(count3);
		return count3;
	}

	public int mech(String code) {
		int count4 = selected_student_repo.countByCollegecodeAndAlloteddepartment(code, "mech").get(0);
		System.out.println(count4);

		return count4;
	}

}

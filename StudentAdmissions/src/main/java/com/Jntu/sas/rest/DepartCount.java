package com.Jntu.sas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.Jntu.sas.beans.Selectedstudents;
import com.Jntu.sas.repositories.SelectedStudentsRepo;

@Service
@EnableAutoConfiguration
public class DepartCount {
	@Autowired
	SelectedStudentsRepo selected_student_repo;
	@Autowired
	Selectedstudents selected_student_entity;

	public int cse(String code) {
		int count1 = selected_student_repo.countByCollegecodeAndAlloteddepartment(code, Messages.getString("Depart_count.0")).get(0); //$NON-NLS-1$
		System.out.println(count1);
		return count1;

	}

	public int ece(String code) {
		int count2 = selected_student_repo.countByCollegecodeAndAlloteddepartment(code, Messages.getString("Depart_count.1")).get(0); //$NON-NLS-1$
		System.out.println(count2);
		return count2;
	}

	public int it(String code) {
		int count3 = selected_student_repo.countByCollegecodeAndAlloteddepartment(code, Messages.getString("Depart_count.2")).get(0); //$NON-NLS-1$
		System.out.println(count3);
		return count3;
	}

	public int mech(String code) {
		int count4 = selected_student_repo.countByCollegecodeAndAlloteddepartment(code, Messages.getString("Depart_count.3")).get(0); //$NON-NLS-1$
		System.out.println(count4);

		return count4;
	}

}

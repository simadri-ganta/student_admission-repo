package com.Jntu.sas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration
public class Alloted_dept_check {
	@Autowired
	Depart_count count;

	public String check_and_allot(String department_choice, String college_code) {
		switch (department_choice) {
		case "cse":
			if (count.cse(college_code) < 5) { // cse count
				return "cse";
			} else {
				return "no_seat";
			}
		case "ece":
			if (count.ece(college_code) < 5) { // ece count
				System.out.println("ece");
				return "ece";

			} else {
				return "no_seat";

			}

		case "it":

			if (count.it(college_code) < 5) { // It count

				return "it";
			} else {
				return "no_seat";
			}

		case "mech":

			if (count.mech(college_code) < 5) { // mechanicalcount
				System.out.println("mech");
				return "mech";
			} else {
				return "no_seat";
			}

		default:
			return "no_department";
		}

	}

}

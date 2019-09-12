package com.Jntu.sas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Jntu.sas.beans.Registration_table;
import com.Jntu.sas.business.NewEntry;

@Controller
public class New_applicant_control {

	@Autowired
	NewEntry register;
	@Autowired
	Registration_table studentdetails;

	@RequestMapping("New_applicant")
	public ModelAndView home1(String name, String board, String marks, String gpa, String percentage, String school,
			String department, String college_choice1, String college_choice2) {
		studentdetails.setBoard(board);
		studentdetails.setCollege(college_choice1);
		studentdetails.setCollege_choice2(college_choice2);
		studentdetails.setName(name);
		studentdetails.setDepartment(department);
		studentdetails.setGpa(gpa);
		studentdetails.setMarks(marks);
		studentdetails.setPercentage(Integer.valueOf(percentage));
		studentdetails.setSchool(school);
		ModelAndView modelview = new ModelAndView("newadmissionform");
		if (register.send(studentdetails))
			modelview.addObject("Status", true);
		else
			modelview.addObject("Status", false);
		return modelview;

	}

}

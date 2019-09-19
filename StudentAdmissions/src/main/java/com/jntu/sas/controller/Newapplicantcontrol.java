package com.jntu.sas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jntu.sas.beans.Registration;
import com.jntu.sas.business.NewEntry;

@Controller
public class Newapplicantcontrol {

	@Autowired
	NewEntry register;
	@Autowired
	Registration studentdetails;

	@RequestMapping("New_applicant")
	public ModelAndView home1(String name, String board, String marks, String gpa, String percentage, String school,
			String department, String FirstCollege, String secondCollege) {
		studentdetails.setBoard(board);
		studentdetails.setFirstCollege(FirstCollege);
		studentdetails.setSecondCollege(secondCollege);
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

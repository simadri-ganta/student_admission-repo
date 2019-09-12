package com.Jntu.sas.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Jntu.sas.business.NewEntry;

@Controller
public class New_applicant_control {

	@Autowired
	NewEntry register;

	@RequestMapping("New_applicant")
	public ModelAndView home1(String name, String board, String marks, String gpa, String percentage, String school,
			String department, String college1, String college2) {
		ModelAndView modelview = new ModelAndView("newadmissionform");
		if (register.send(name, board, marks, gpa, percentage, school, department, college1, college2))
			modelview.addObject("Status", true);
		else
			modelview.addObject("Status", false);
		return modelview;

	}

}

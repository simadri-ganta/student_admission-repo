package com.Jntu.sas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Jntu.sas.beans.Number_of_colleges;
import com.Jntu.sas.business.Addcollege;

@Controller
public class Add_college_control {
	@Autowired
	Addcollege restcall;
@Autowired
Number_of_colleges collegebean;
	@RequestMapping("Main_admin/Addingcollege")
	public ModelAndView home1(String name, String code, String rank) {
		collegebean.setCollege_code(code);
		collegebean.setCollege_name(name);
		collegebean.setCollege_rank(rank);
		ModelAndView modelview = new ModelAndView("Main_admin/addCollege");
		if (restcall.rest(collegebean))
			modelview.addObject("status", true);
		else
			modelview.addObject("status", false);
		return modelview;

	}
}

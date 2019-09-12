package com.Jntu.sas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Jntu.sas.beans.Numberofcolleges;
import com.Jntu.sas.business.Addcollege;

@Controller
public class Addcollegecontrol {
	@Autowired
	Addcollege restcall;
@Autowired
Numberofcolleges collegebean;
	@RequestMapping("Main_admin/Addingcollege")
	public ModelAndView home1(String name, String code, String rank) {
		collegebean.setCollege_code(code);
		collegebean.setCollege_name(name);
		collegebean.setCollege_rank(rank);
		ModelAndView modelview = new ModelAndView(Messages.getString("Add_college_control.0")); //$NON-NLS-1$
		restcall.rest(collegebean);
		return modelview;

	}
}

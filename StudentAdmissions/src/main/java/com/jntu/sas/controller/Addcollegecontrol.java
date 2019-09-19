package com.jntu.sas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jntu.sas.beans.College;
import com.jntu.sas.business.AddCollege;

@Controller
public class Addcollegecontrol {
	@Autowired
	AddCollege restcall;
@Autowired
College collegebean;
	@RequestMapping("Main_admin/Addingcollege")
	public ModelAndView home1(String name, String code, String rank) {
		collegebean.setCode(code);
		collegebean.setName(name);
		collegebean.setRank(rank);
		ModelAndView modelview = new ModelAndView("Main_admin/addCollege"); //$NON-NLS-1$
		restcall.rest(collegebean);
		return modelview;

	}
}

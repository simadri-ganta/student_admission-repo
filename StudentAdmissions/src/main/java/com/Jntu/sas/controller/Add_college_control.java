package com.Jntu.sas.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Jntu.sas.business.Addcollege;

@Controller
public class Add_college_control {
	@Autowired
	Addcollege restcall;
	@RequestMapping("Main_admin/Addingcollege")
	public ModelAndView home1(String name, String code, String rank) {
		ArrayList<String> list = new ArrayList<>();
		list.add(name);
		list.add(code);
		list.add(rank);
		ModelAndView modelview = new ModelAndView("Main_admin/addCollege");
		if(restcall.rest(list))
			modelview.addObject("status",true);
		else
			modelview.addObject("status",false);
		return modelview;

	}
}

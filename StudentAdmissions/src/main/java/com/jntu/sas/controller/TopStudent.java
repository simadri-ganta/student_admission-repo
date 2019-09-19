package com.jntu.sas.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jntu.sas.beans.Student;
import com.jntu.sas.business.TopStudents;

@Controller
public class TopStudent {
	@Autowired
	TopStudents get;

	@RequestMapping("top10")
	public ModelAndView home1(HttpSession session) {
		List<Student> status = get.getlist(session);
		System.out.println(status.toString());
		ModelAndView modelview = new ModelAndView();
		modelview.addObject("details", status);
		modelview.setViewName("college_admin/top10");
		return modelview;

	}
}
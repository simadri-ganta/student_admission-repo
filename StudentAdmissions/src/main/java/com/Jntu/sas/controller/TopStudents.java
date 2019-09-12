package com.Jntu.sas.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Jntu.sas.beans.Selectedstudents;
import com.Jntu.sas.business.Top_Students;

@Controller
public class TopStudents {
	@Autowired
	Top_Students get;

	@RequestMapping("top10")
	public ModelAndView home1(HttpSession session) {
		List<Selectedstudents> status = get.getlist(session);
		System.out.println(status.toString());
		ModelAndView modelview = new ModelAndView();
		modelview.addObject(Messages.getString("TopStudents.0"), status); //$NON-NLS-1$
		modelview.setViewName(Messages.getString("TopStudents.1")); //$NON-NLS-1$
		return modelview;

	}
}
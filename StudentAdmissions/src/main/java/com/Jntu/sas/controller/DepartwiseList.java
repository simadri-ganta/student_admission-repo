package com.Jntu.sas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Jntu.sas.beans.Selectedstudents;
import com.Jntu.sas.business.DepartmentWise;

@Controller
public class DepartwiseList {
	@Autowired
	DepartmentWise departments;

	@RequestMapping("departmentwise")
	public ModelAndView home3(HttpSession session) {

		ArrayList<List<Selectedstudents>> status = departments.getlist(session);
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName(Messages.getString("DepartwiseList.0")); //$NON-NLS-1$
		modelview.addObject(Messages.getString("DepartwiseList.1"), status); //$NON-NLS-1$
		return modelview;
	}
}

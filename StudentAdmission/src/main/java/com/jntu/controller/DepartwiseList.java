package com.jntu.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jntu.beans.Selected_students;
import com.jntu.business.DepartmentWise;

@Controller
public class DepartwiseList {
	@Autowired
	DepartmentWise departments;

	@RequestMapping("departmentwise")
	public ModelAndView home3(HttpSession session) {

		ArrayList<List<Selected_students>> status = departments.getlist(session);
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("college_admin/departmentwise");
		modelview.addObject("values", status);
		return modelview;
	}
}

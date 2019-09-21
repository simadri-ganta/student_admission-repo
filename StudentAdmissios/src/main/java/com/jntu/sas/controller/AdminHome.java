package com.jntu.sas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jntu.sas.beans.College;
import com.jntu.sas.beans.Student;
import com.jntu.sas.business.Adminstrator;

@Controller
public class AdminHome {
	@Autowired
	Adminstrator confirm;

	@RequestMapping("Confirm_allotement")
	public ModelAndView home(HttpSession session) {
		ArrayList<Integer> responsecount = confirm.confirm(session);
		ModelAndView modelview = new ModelAndView("college_admin/confirmationpage"); //$NON-NLS-1$
		modelview.addObject("count", responsecount.toString()); //$NON-NLS-1$
		return modelview;
	}

	

	@RequestMapping("departmentwise")
	public ModelAndView home3(HttpSession session) {

		ArrayList<List<Student>> status = get.getlist(session);
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("college_admin/departmentwise"); //$NON-NLS-1$
		modelview.addObject("values", status); //$NON-NLS-1$
		return modelview;
	}

	@Autowired
	Adminstrator get;

	@RequestMapping("top10")
	public ModelAndView home1(HttpSession session) {
		List<Student> status = get.getList(session);
		System.out.println(status.toString());
		ModelAndView modelview = new ModelAndView();
		modelview.addObject("details", status);
		modelview.setViewName("college_admin/top10");
		return modelview;

	}

	@Autowired
	Adminstrator restcall;
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

	@RequestMapping("home")
	public String home() {
		return "index"; //$NON-NLS-1$
	}

	@RequestMapping("welcome")
	public String home5() {
		return "Main_admin/welcome";
	}

	@RequestMapping("reviewAppliaction")
	public String home1() {
		return "college_admin/reviewAppliaction";
	}

	@RequestMapping("confirmationpage")
	public String home3() {
		return "college_admin/confirmationpage";
	}

	@RequestMapping("newadmissionform")
	public String home7() {
		return "newadmissionform";
	}

}

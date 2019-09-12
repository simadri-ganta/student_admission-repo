package com.Jntu.sas.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Jntu.sas.beans.Admin_table;
import com.Jntu.sas.business.Login_call;

@Controller
public class Login_control {
	@Autowired
	Login_call login;
	@Autowired
	Admin_table loginbean;

	@RequestMapping("login_admin_home")
	public ModelAndView home1(String name, String pass, HttpSession session) {
		System.out.println("coming");
		ModelAndView modelview = new ModelAndView();
		if (name.equals(null) || pass.equals(null)) {
			modelview.addObject("status", "please_values");
			modelview.setViewName("index");
			return modelview;
		} else {
			loginbean.setId(name);
			loginbean.setPass(pass);
			ArrayList<String> status = login.request(loginbean);
			if (!status.isEmpty()) {
				switch (status.get(0)) {
				case "valid":
					if (status.get(1).equals("admin")) {
						modelview.setViewName("Main_admin/admin_left");
						return modelview;
					} else {
						modelview.setViewName("college_admin/admin");
						session.setAttribute("code", status.get(1));
						session.setAttribute("registered", status.get(2));
						session.setAttribute("selected", status.get(3));
						return modelview;
					}
				case "invaldi":
					modelview.addObject("status", "something_went_wrong");
					modelview.setViewName("index");
					return modelview;
				case "no_user":
					modelview.addObject("status", "null");
					modelview.setViewName("index");
					return modelview;
				default:
					modelview.addObject("status", "wrong_pass");
					modelview.setViewName("index");
					return modelview;
				}
			} else {
				modelview.addObject("status", "please_values");
				modelview.setViewName("index");
				return modelview;
			}
		}
	}
}

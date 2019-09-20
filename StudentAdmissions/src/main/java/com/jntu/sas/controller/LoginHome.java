package com.jntu.sas.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

import com.jntu.sas.beans.Admin;
import com.jntu.sas.business.LoginCall;

@Controller
public class LoginHome {
	@Autowired
	LoginCall login;
	@Autowired
	Admin loginbean;

	@RequestMapping("login_admin_home")
	public ModelAndView home1(String name, String pass, HttpSession session) {
		System.out.println("coming");
		ModelAndView modelview = new ModelAndView();

		if (!name.isEmpty() || !pass.isEmpty()) {
			try {
				loginbean.setUserId(name);
				loginbean.setPassword(pass);
				ArrayList<String> status = login.request(loginbean);
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

			} catch (HttpClientErrorException | HttpServerErrorException e) {
				System.out.println(e.toString().toString());
				if (HttpStatus.UNAUTHORIZED.equals(e.getStatusCode())) {
					modelview.addObject("status", "no_user");
					modelview.setViewName("index");
					return modelview;
				} else if (HttpStatus.INTERNAL_SERVER_ERROR.equals(e.getStatusCode())) {
					modelview.addObject("status", "something_went_wrong");
					modelview.setViewName("index");
					return modelview;
				} else if(HttpStatus.PRECONDITION_FAILED.equals(e.getStatusCode())){
					modelview.addObject("status", "wrong_pass");
					modelview.setViewName("index");
					return modelview;
				}
				else
					return null;

			}
		} else {
			modelview.addObject("status", "please_values");
			modelview.setViewName("index");
			return modelview;
		}
	}
}

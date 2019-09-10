package com.jntu.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jntu.business.Status_checking;
@Controller
public class Checking_Status {
	@Autowired
	Status_checking check;

	@RequestMapping("status_check")
	public ModelAndView home4(String name, String password, HttpSession session) {
		ModelAndView modelview = new ModelAndView("application_status");
		try {
			ArrayList<String> status = check.checks(name, password, session);
			switch (status.get(0)) {
			case "user_invalid":
				System.out.println("invalid");
				modelview.addObject("status", "invalid_user");
				return modelview;
			case "pass_wrong":
				System.out.println("wrong");
				modelview.addObject("status", "wrong_pass");
				return modelview;
			case "accepted":
				System.out.println("aceeopted");
				modelview.addObject("status", "accepted");
				return modelview;
			case "pending":
				System.out.println("pendoinh");
				modelview.addObject("status", "pending");
				return modelview;
			case "rejected":
				System.out.println("reject");
				modelview.addObject("status", "rejected");
				modelview.addObject("choice2", status.get(1));
				modelview.addObject("name", name);
				return modelview;
			default:
				return modelview;
			}
		} catch (Exception e) {
			modelview.addObject("status", "wrong_fromat");
			return modelview;
		}

	}
}

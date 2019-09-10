package com.jntu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home_controler {
	
	@RequestMapping("home")
	public String home() {
		return "index";
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

package com.Jntu.sas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Homecontroler {

	@RequestMapping("home")
	public String home() {
		return Messages.getString("Home_controler.0"); //$NON-NLS-1$
	}

	@RequestMapping("welcome")
	public String home5() {
		return Messages.getString("Home_controler.1"); //$NON-NLS-1$
	}

	@RequestMapping("reviewAppliaction")
	public String home1() {
		return Messages.getString("Home_controler.2"); //$NON-NLS-1$
	}

	@RequestMapping("confirmationpage")
	public String home3() {
		return Messages.getString("Home_controler.3"); //$NON-NLS-1$
	}

	@RequestMapping("newadmissionform")
	public String home7() {
		return Messages.getString("Home_controler.4"); //$NON-NLS-1$
	}

}

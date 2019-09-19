package com.jntu.sas.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jntu.sas.business.ComfirmSeats;

@Controller
public class Confirmseats {
	@Autowired
	ComfirmSeats confirm;

	@RequestMapping("Confirm_allotement")
	public ModelAndView home(HttpSession session) {
		ArrayList<Integer> responsecount = confirm.confirm(session);
		ModelAndView modelview = new ModelAndView("college_admin/confirmationpage"); //$NON-NLS-1$
		modelview.addObject("count", responsecount.toString()); //$NON-NLS-1$
		return modelview;
	}
}
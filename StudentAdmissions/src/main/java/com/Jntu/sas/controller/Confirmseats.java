package com.Jntu.sas.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Jntu.sas.business.ComfirmSeats;

@Controller
public class Confirmseats {
	@Autowired
	ComfirmSeats confirm;

	@RequestMapping("Confirm_allotement")
	public ModelAndView home(HttpSession session) {
		ArrayList<Integer> responsecount = confirm.confirm(session);
		ModelAndView modelview = new ModelAndView(Messages.getString("Confirm_seats.0")); //$NON-NLS-1$
		modelview.addObject(Messages.getString("Confirm_seats.1"), responsecount.toString()); //$NON-NLS-1$
		return modelview;
	}
}
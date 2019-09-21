package com.jntu.sas.business;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jntu.sas.beans.Registration;
import com.jntu.sas.constants.MyrestUrl;

@Service
@EnableAutoConfiguration
@Component
public class Students {
	@Autowired
	MyrestUrl resturl;
	
	@Autowired
	Registration studentdetails;

	@SuppressWarnings("unchecked")
	public ArrayList<String> checks(String name, String password, HttpSession session) {
		String[] values = password.split("/", 4); //$NON-NLS-1$
		studentdetails.setName(name);
		studentdetails.setBoard(values[0]);
		studentdetails.setGpa(values[1]);
		studentdetails.setPercentage(Integer.valueOf(values[3]));
		RestTemplate restcall = new RestTemplate();
		String url = resturl.geturl() + "Status_check/";
		return restcall.postForObject(url, studentdetails, ArrayList.class);

	}
	public boolean send(Registration studentdetails) {
		RestTemplate restcall = new RestTemplate();
		if (!restcall.postForObject(resturl.geturl() + "new_applicantion/", studentdetails, ArrayList.class).isEmpty()) //$NON-NLS-1$
			return true;
		else
			return false;
	}

}

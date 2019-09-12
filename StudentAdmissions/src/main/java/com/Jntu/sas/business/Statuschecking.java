package com.Jntu.sas.business;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Jntu.sas.MyrestUrl;
import com.Jntu.sas.beans.Registrationtable;

@Service
@EnableAutoConfiguration
@Component
public class Statuschecking {
	@Autowired
	MyrestUrl resturl;
	@Autowired
	Registrationtable studentdetails;

	@SuppressWarnings("unchecked")
	public ArrayList<String> checks(String name, String password, HttpSession session) {
		String[] values = password.split(Messages.getString("Status_checking.0"), 4); //$NON-NLS-1$
		studentdetails.setName(name);
		studentdetails.setBoard(values[0]);
		studentdetails.setGpa(values[1]);
		studentdetails.setPercentage(Integer.valueOf(values[3]));
		RestTemplate restcall = new RestTemplate();
		String url = resturl.geturl() + Messages.getString("Status_checking.1"); //$NON-NLS-1$
		return restcall.postForObject(url, studentdetails, ArrayList.class);

	}

}

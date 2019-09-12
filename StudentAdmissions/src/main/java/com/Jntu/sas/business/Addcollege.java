package com.Jntu.sas.business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Jntu.sas.MyrestUrl;
import com.Jntu.sas.beans.Number_of_colleges;

@Service
@EnableAutoConfiguration
@Component
public class Addcollege {
	@Autowired
	MyrestUrl resturl;

	@SuppressWarnings("unchecked")
	public boolean rest(Number_of_colleges collegedetails) {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + "adcollege/";
		ArrayList<String> status = temple.postForObject(url, collegedetails, ArrayList.class);
		if (!status.isEmpty()) {
			return true;
		} else
			return false;
	}
}

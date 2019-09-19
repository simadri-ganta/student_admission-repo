package com.jntu.sas.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jntu.sas.beans.College;
import com.jntu.sas.constants.MyrestUrl;

@Service
@EnableAutoConfiguration
@Component
public class AddCollege {
	@Autowired
	MyrestUrl resturl;

	public void rest(College collegedetails) {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + "adcollege/";
		temple.put(url, collegedetails);
	}
}

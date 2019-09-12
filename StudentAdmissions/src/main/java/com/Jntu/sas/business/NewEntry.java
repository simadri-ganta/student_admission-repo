package com.Jntu.sas.business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Jntu.sas.MyrestUrl;
import com.Jntu.sas.beans.Registration_table;

@Service
@EnableAutoConfiguration
@Component
public class NewEntry {
	@Autowired
	MyrestUrl resturl;
    @Autowired
    Registration_table studentdetails;
	public boolean send(Registration_table studentdetails) {
		RestTemplate restcall = new RestTemplate();
		if (!restcall.postForObject(resturl.geturl() + "new_applicantion/", studentdetails, ArrayList.class).isEmpty())
			return true;
		else
			return false;
	}

}

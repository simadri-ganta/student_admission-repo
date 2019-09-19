package com.jntu.sas.business;

import java.util.ArrayList;

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
public class NewEntry {
	@Autowired
	MyrestUrl resturl;
    @Autowired
    Registration studentdetails;
	public boolean send(Registration studentdetails) {
		RestTemplate restcall = new RestTemplate();
		if (!restcall.postForObject(resturl.geturl() + "new_applicantion/", studentdetails, ArrayList.class).isEmpty()) //$NON-NLS-1$
			return true;
		else
			return false;
	}

}

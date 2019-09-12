package com.Jntu.sas.business;

import java.util.ArrayList;

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
public class NewEntry {
	@Autowired
	MyrestUrl resturl;
    @Autowired
    Registrationtable studentdetails;
	public boolean send(Registrationtable studentdetails) {
		RestTemplate restcall = new RestTemplate();
		if (!restcall.postForObject(resturl.geturl() + Messages.getString("NewEntry.0"), studentdetails, ArrayList.class).isEmpty()) //$NON-NLS-1$
			return true;
		else
			return false;
	}

}

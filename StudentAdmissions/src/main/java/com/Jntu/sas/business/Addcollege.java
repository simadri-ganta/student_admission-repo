package com.Jntu.sas.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Jntu.sas.MyrestUrl;
import com.Jntu.sas.beans.Numberofcolleges;

@Service
@EnableAutoConfiguration
@Component
public class Addcollege {
	@Autowired
	MyrestUrl resturl;

	public void rest(Numberofcolleges collegedetails) {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + Messages.getString("Addcollege.0"); //$NON-NLS-1$
		temple.put(url, collegedetails);
	}
}

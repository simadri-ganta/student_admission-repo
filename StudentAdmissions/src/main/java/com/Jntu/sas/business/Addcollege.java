package com.Jntu.sas.business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Jntu.sas.MyrestUrl;

@Service
@EnableAutoConfiguration
@Component
public class Addcollege {
	@Autowired
	MyrestUrl resturl;

	@SuppressWarnings("unchecked")
	public boolean rest(ArrayList<String> list) {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + "adcollege/";
		System.out.println(url);
		ArrayList<String> status = temple.postForObject(url, list, ArrayList.class);
		System.out.println(status.get(0));
		if (!status.isEmpty()) {
			return true;
		} else
			return false;
	}
}

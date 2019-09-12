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
public class Login_call {
	@Autowired
	MyrestUrl resturl;

	@SuppressWarnings("unchecked")
	public ArrayList<String> request(ArrayList<String> list) {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + "login/";
		return temple.postForObject(url, list, ArrayList.class);
	}
}
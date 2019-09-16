package com.Jntu.sas.business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.Jntu.sas.MyrestUrl;
import com.Jntu.sas.beans.Admintable;

@Service
@EnableAutoConfiguration
@Component
public class Logincall {
	@Autowired
	MyrestUrl resturl;

	@SuppressWarnings("unchecked")
	public ArrayList<String> request(Admintable loginbean) throws HttpClientErrorException, HttpServerErrorException {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + Messages.getString("Login_call.0");
		return temple.postForObject(url, loginbean, ArrayList.class);
	}
}

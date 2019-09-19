package com.jntu.sas.business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.jntu.sas.beans.Admin;
import com.jntu.sas.constants.MyrestUrl;

@Service
@EnableAutoConfiguration
@Component
public class LoginCall {
	@Autowired
	MyrestUrl resturl;

	@SuppressWarnings("unchecked")
	public ArrayList<String> request(Admin loginbean) throws HttpClientErrorException, HttpServerErrorException {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + "login/";
		return temple.postForObject(url, loginbean, ArrayList.class);
	}
}

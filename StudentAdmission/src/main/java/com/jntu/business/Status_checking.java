package com.jntu.business;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jntu.main.MyrestUrl;

@Service
@EnableAutoConfiguration
@Component
public class Status_checking {
	@Autowired
	MyrestUrl resturl;

	@SuppressWarnings("unchecked")
	public ArrayList<String> checks(String name, String password, HttpSession session) {
		ArrayList<String> details = new ArrayList<>();
		details.add(name);
		String[] values = password.split("/", 4);
		details.add(values[0]);
		details.add(values[1]);
		details.add(values[3]);
		RestTemplate restcall = new RestTemplate();
		String url = resturl.geturl() + "Status_check/";
		return restcall.postForObject(url, details, ArrayList.class);

	}

}

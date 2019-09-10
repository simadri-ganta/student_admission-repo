package com.jntu.business;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jntu.beans.Selected_students;
import com.jntu.main.MyrestUrl;

@Service
@EnableAutoConfiguration
@Component
public class Top_Students {
	@Autowired
	MyrestUrl resturl;

	@SuppressWarnings("unchecked")
	public List<Selected_students> getlist(HttpSession session) {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + "top10/" + session.getAttribute("code");
		return temple.getForObject(url, ArrayList.class);
	}

}

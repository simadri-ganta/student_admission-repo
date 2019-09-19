package com.jntu.sas.business;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jntu.sas.beans.Student;
import com.jntu.sas.constants.MyrestUrl;

@Service
@EnableAutoConfiguration
@Component
public class TopStudents {
	@Autowired
	MyrestUrl resturl;

	@SuppressWarnings("unchecked")
	public List<Student> getlist(HttpSession session) {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + "top10/" + session.getAttribute("code");
		return temple.getForObject(url, ArrayList.class);
	}

}

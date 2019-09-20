package com.jntu.sas.business;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jntu.sas.beans.College;
import com.jntu.sas.beans.Student;
import com.jntu.sas.constants.MyrestUrl;

@Service
@EnableAutoConfiguration
@Component
public class Admin {
	@Autowired
	MyrestUrl resturl;

	@SuppressWarnings("unchecked")
	public ArrayList<Integer> confirm(HttpSession session) {
		RestTemplate restcall = new RestTemplate();
		return restcall.getForObject(resturl.geturl() + "Confirm_allotement_rest/" + session.getAttribute("code"),
				ArrayList.class);
	}

	public void rest(College collegedetails) {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + "adcollege/";
		temple.put(url, collegedetails);
	}

	@SuppressWarnings("unchecked")
	public List<Student> getList(HttpSession session) {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + "top10/" + session.getAttribute("code");
		return temple.getForObject(url, ArrayList.class);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<List<Student>> getlist(HttpSession session) {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + "departmentwise_request/" + session.getAttribute("code");
		return temple.getForObject(url, ArrayList.class);
	}

}

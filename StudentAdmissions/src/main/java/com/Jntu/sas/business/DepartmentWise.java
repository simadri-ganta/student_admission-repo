package com.Jntu.sas.business;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Jntu.sas.MyrestUrl;
import com.Jntu.sas.beans.Selected_students;

@Service
@EnableAutoConfiguration
@Component
public class DepartmentWise {
	@Autowired
	MyrestUrl resturl;

	@SuppressWarnings("unchecked")
	public ArrayList<List<Selected_students>> getlist(HttpSession session) {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + "departmentwise_request/" + session.getAttribute("code");
		return temple.getForObject(url, ArrayList.class);
	}
}

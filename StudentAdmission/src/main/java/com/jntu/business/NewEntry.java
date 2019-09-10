package com.jntu.business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jntu.main.MyrestUrl;

@Service
@EnableAutoConfiguration
@Component
public class NewEntry {
	@Autowired
	MyrestUrl resturl;

	public boolean send(String name, String board, String marks, String gpa, String percentage, String school,
			String department, String college1, String college2) {
		ArrayList<String> values = new ArrayList<String>();
		values.add(name);
		values.add(board);
		values.add(marks);
		if (gpa != null) {
			values.add(gpa);
		} else {
			double gpa1 = ((Integer.parseInt(percentage) * 9.5) / 100);
			values.add(String.valueOf(gpa1));
		}
		values.add(percentage);
		values.add(school);
		values.add(department);
		values.add(college1);
		values.add(college2);
		RestTemplate restcall = new RestTemplate();
		if (!restcall.postForObject(resturl.geturl() + "new_applicantion/", values, ArrayList.class).isEmpty())
			return true;
		else
			return false;
	}

}

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
import com.Jntu.sas.beans.Selectedstudents;

@Service
@EnableAutoConfiguration
@Component
public class Top_Students {
	@Autowired
	MyrestUrl resturl;

	@SuppressWarnings("unchecked")
	public List<Selectedstudents> getlist(HttpSession session) {
		RestTemplate temple = new RestTemplate();
		String url = resturl.geturl() + Messages.getString("Top_Students.0") + session.getAttribute(Messages.getString("Top_Students.1")); //$NON-NLS-1$ //$NON-NLS-2$
		return temple.getForObject(url, ArrayList.class);
	}

}

package com.Jntu.sas.business;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Jntu.sas.MyrestUrl;

@Service
@EnableAutoConfiguration
@Component
public class ComfirmSeats {
	@Autowired
	MyrestUrl resturl;

	@SuppressWarnings("unchecked")
	public ArrayList<Integer> confirm(HttpSession session) {
		RestTemplate restcall = new RestTemplate();
		return restcall.getForObject(resturl.geturl() + Messages.getString("ComfirmSeats.0") + session.getAttribute(Messages.getString("ComfirmSeats.1")), //$NON-NLS-1$ //$NON-NLS-2$
				ArrayList.class);
	}
}

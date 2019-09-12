package com.Jntu.sas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyrestUrl {
	@Value("${restservice.url}")
	private String rest;

	public String geturl() {
		return rest;
		

	}
}
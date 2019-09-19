package com.jntu.sas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class InValidCredentials extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6216608288335300866L;

	public InValidCredentials(String exception){
		super(exception);
		
	}
}

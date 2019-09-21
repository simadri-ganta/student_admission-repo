package com.jntu.sas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "no_user",code=HttpStatus.UNAUTHORIZED)
public class UnAuthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnAuthorizedException(String exception) {
		super(exception);
	}
}

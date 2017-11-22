package com.demo.microarch.config.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {
	private static final long serialVersionUID = 2220798861814627962L;

	public CustomerNotFoundException(String pesel) {
		super("No such customer: " + pesel);
	}

}

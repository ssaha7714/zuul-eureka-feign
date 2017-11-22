package com.demo.microarch.card.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class CardNotFoundException extends Exception {
	private static final long serialVersionUID = 869489888194209511L;

	public CardNotFoundException(String cardNumber) {
		super("No such card: " + cardNumber);
	}
}

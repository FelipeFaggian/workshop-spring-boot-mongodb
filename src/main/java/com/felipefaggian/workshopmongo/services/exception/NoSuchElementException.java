package com.felipefaggian.workshopmongo.services.exception;

public class NoSuchElementException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NoSuchElementException(String msg) {
		super(msg);
	}
}

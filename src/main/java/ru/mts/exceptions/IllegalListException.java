package ru.mts.exceptions;

import java.io.IOException;

public class IllegalListException extends IOException {
	public IllegalListException() {
		super();
	}

	public IllegalListException(String s) {
		super(s);
	}
}

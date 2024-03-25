package ru.mts.exceptions;

import java.io.IOException;

public class IllegalListException extends Exception {
	public IllegalListException() {
		super();
	}

	public IllegalListException(String str) {
		super(str);
	}
}

package ru.mts.exceptions;

public class IllegalValueException extends IllegalArgumentException {
	public IllegalValueException() {
		super();
	}

	public IllegalValueException(String message) {
		super(message);
	}
}

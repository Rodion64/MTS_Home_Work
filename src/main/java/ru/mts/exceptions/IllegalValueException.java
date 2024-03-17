package ru.mts.exceptions;

public class IllegalValueException extends IllegalListException {
	public IllegalValueException() {
		super();
	}

	public IllegalValueException(String message) {
		super(message);
	}
}

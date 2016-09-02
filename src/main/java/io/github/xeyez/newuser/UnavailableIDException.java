package io.github.xeyez.newuser;

@SuppressWarnings("serial")
public class UnavailableIDException extends RuntimeException {
	public UnavailableIDException(String message) {
		super(message);
	}
}

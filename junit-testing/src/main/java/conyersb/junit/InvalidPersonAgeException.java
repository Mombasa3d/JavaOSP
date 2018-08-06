package conyersb.junit;

public class InvalidPersonAgeException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;
	
	public InvalidPersonAgeException() {
	}

	public InvalidPersonAgeException(String s) {
		super(s);
	}

	public InvalidPersonAgeException(Throwable cause) {
		super(cause);
	}

	public InvalidPersonAgeException(String message, Throwable cause) {
		super(message, cause);
	}

}

package conyersb.junit;

public class InvalidPersonNameException extends IllegalArgumentException {

	private static final long serialVersionUID=1L;
	
	public InvalidPersonNameException() {

	}

	public InvalidPersonNameException(String arg0) {
		super(arg0);
	}

	public InvalidPersonNameException(Throwable arg0) {
		super(arg0);
	}

	public InvalidPersonNameException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}

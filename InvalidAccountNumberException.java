package bankapplication;

public class InvalidAccountNumberException extends Exception {
	private static final long serialVersionUID = 1L;

	InvalidAccountNumberException(String s)
	{
		super(s);
	}

}

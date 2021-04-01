/*
@Banking application - With the help of this application we can create new bank 
account and other banking operation's.
@Author      - Nitheesh G.
@Created at  - 02-16-2021
@Updated at  - 02-16-2021
@Reviewed by - Anto
*/
package bankapplication;

public class InvalidAadharException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidAadharException(String s) 
    {
        super(s);
    }
}

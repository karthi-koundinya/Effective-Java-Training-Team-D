package in.conceptarchitect.exceptions;

@SuppressWarnings("serial")
public class InvalidDenominationException extends Exception {

	private String message; 
	public InvalidDenominationException (String message) 
	{ 
		this.message = message;
		} 
	public InvalidDenominationException(Throwable cause, String message)
	{ 
		super(cause); 
		this.message = message;
		}
	public String getMessage()
	{ 
		return message;
		} 
}

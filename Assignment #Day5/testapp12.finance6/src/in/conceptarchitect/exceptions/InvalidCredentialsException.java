package in.conceptarchitect.exceptions;

@SuppressWarnings("serial")
public class InvalidCredentialsException extends Exception {
	private String message; 
	public InvalidCredentialsException (String message) 
	{ 
		this.message = message;
		} 
	public InvalidCredentialsException(Throwable cause, String message)
	{ 
		super(cause); 
		this.message = message;
		}
	public String getMessage()
	{ 
		return message;
		} 

}

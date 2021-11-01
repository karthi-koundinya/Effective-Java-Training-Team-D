package in.conceptarchitect.exceptions;

@SuppressWarnings("serial")
public class InvalidAccountException extends Exception {
	
	private String message; 
	public InvalidAccountException (String message) 
	{ 
		this.message = message;
		} 
	public InvalidAccountException(Throwable cause, String message)
	{ 
		super(cause); 
		this.message = message;
		}
	public String getMessage()
	{ 
		return message;
		} 

}

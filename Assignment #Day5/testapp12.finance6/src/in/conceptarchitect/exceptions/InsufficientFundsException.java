package in.conceptarchitect.exceptions;

@SuppressWarnings("serial")
public class InsufficientFundsException extends Exception  {

	private String message; 
	public InsufficientFundsException (String message) 
	{ 
		this.message = message;
		} 
	public InsufficientFundsException(Throwable cause, String message)
	{ 
		super(cause); 
		this.message = message;
		}
	public String getMessage()
	{ 
		return message;
		} 
	
}
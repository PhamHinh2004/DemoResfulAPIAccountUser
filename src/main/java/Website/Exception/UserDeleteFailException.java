package Website.Exception;

public class UserDeleteFailException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDeleteFailException(String message) {
		super(message);
	}
}

package Website.Exception;

public class UserUpdateFailException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserUpdateFailException(String message) {
		super(message);
	}
}

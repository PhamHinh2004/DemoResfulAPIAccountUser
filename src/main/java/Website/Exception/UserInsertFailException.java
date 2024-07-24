package Website.Exception;

public class UserInsertFailException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserInsertFailException(String message) {
		super(message);
	}
}

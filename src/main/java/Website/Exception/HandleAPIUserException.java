package Website.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class HandleAPIUserException {
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorMessage handleUserCanNotFindException(Exception e, WebRequest request) {
		
		return new ErrorMessage(10100, "Đối tượng không tồn tai!!!");
	}
	
	@ExceptionHandler(UserDeleteFailException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage handleUserDeleteException(Exception e, WebRequest request) {
		
		return new ErrorMessage(10200, "Đối tượng không thể xóa được!!!");
	}
	
	@ExceptionHandler(UserUpdateFailException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleUserUpdateException(Exception e, WebRequest request) {
		
		return new ErrorMessage(10300, "Đối tượng không thể update!!!");
	}
	
	@ExceptionHandler(UserInsertFailException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage handleUserInsertException(Exception e, WebRequest request) {
		
		return new  ErrorMessage(10300, "Đối tượng không chèn đối tượng!!!");
	}
	
}

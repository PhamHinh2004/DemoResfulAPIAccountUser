package Website.Validator;

import Website.Model.User;
import lombok.Data;

@Data
public class UserValidatr {
	public boolean isValid(User user) {
		if(user.getUsername().isBlank()||user.getPassword().isBlank()) {
			return false;
		}
		else {
			return true;
		}
	}
}

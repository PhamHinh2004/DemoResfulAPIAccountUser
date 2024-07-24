package Website.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Website.Model.User;
import Website.Repository.UserResponsitory;
import Website.Validator.UserValidatr;
import jakarta.annotation.PostConstruct;

@Service
public class UserService {

	@Autowired
	UserResponsitory responsitory;

	@Autowired
	UserValidatr userValidatr;

	List<User> users = new ArrayList<>();

	@PostConstruct
	public void reload() {
		users = responsitory.findAll();
	}

	public List<User> getListOfUser() {
		return users;
	}

	public User addUser(User user) {
		if (userValidatr.isValid(user)) {
			User saveUser = responsitory.save(user);
			reload();
			return saveUser;
		}
		return null;
	}

	public User getUserById(Long id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}

		return null;
	}

	public User postUser(User user) {
		User rs = responsitory.save(user);
		reload();
		return rs;
	}

	public boolean putUser(Long id, User user) {
		int rs = responsitory.updateUser(id, user.getUsername(), user.getPassword());
		reload();
		return rs > 0;
	}

	public boolean deleteUser(long id) {
		if (responsitory.existsById(id)) {
			responsitory.deleteById(id);
			reload();
			return true;
		}

		return false;

	}

}

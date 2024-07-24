package Website.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Website.Exception.UserDeleteFailException;
import Website.Exception.UserInsertFailException;
import Website.Exception.UserNotFoundException;
import Website.Exception.UserUpdateFailException;
import Website.Model.User;
import Website.Service.UserService;

@RestController
@RequestMapping("/api/users")
public class MyWebSiteRestfulAPI {

	@Autowired
	UserService userService;

	@GetMapping
	public List<User> getAllUser() {
		return userService.getListOfUser();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		User u = userService.getUserById(id);
		if(u == null) {	
			throw new UserNotFoundException("Không tìm thấy người dùng với id: " + id);
		}
		return userService.getUserById(id);
	}

	@PostMapping
	public ResponseEntity<User> postUser(@RequestBody User user) {
		User rs = userService.postUser(user);
		if(rs == null) {
			throw new UserInsertFailException("Không thể thêm được đối tượng với id: " );
		}
		return ResponseEntity.ok(rs);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> putUser(@PathVariable Long id, @RequestBody User user) {
		boolean isUpdated = userService.putUser(id, user);
		if (!isUpdated) {
			throw new UserUpdateFailException("Không thể cập nhật được đối tượng với id: " + id);
		}
		else {
			return ResponseEntity.ok().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id){
		boolean isDeleted = userService.deleteUser(id);
		if(!isDeleted) {
			throw new UserDeleteFailException("Không thể xóa được đối tượng với id: " + id);
		}
		return  "User with id " + id + " deleted successfully";
	}
	
}

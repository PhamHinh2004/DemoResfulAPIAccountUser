package Website.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import Website.Model.User;
import Website.Service.UserService;

@Controller
public class MyWebsiteController {

	@Autowired
	UserService service;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}

	@PostMapping("/")
	public String postApterPost(@ModelAttribute User user, Model model) {
		if (service.addUser(user) != null) {
			return "redirect:/list";
		}

		return "index";
	}

	@GetMapping("/list")
	public String getList(Model model) {
		model.addAttribute("users", service.getListOfUser());
		model.addAttribute("updatedUser", new User());
		return "list";
	}

	@GetMapping("/delete")
	public String delete(Model model) {
		model.addAttribute("users", service.getListOfUser());
		return "delete";
	}

	@PostMapping("/delete/{id}")
	public String deleteByID(@PathVariable Long id) {
		if (service.deleteUser(id)) {
			return "redirect:/list";
		}
		return "redirect:/delete";

	}

//	@GetMapping("/update")
//	public String getUpdateForm(Model model) {
//		model.addAttribute("users", service.getListOfUser());
//		model.addAttribute("updatedUser", new User());
//		return "update";
//	}
	
	@GetMapping("/update/{id}")
	public String getUpdateFormByID(@PathVariable Long id ,Model model) {
		model.addAttribute("user", service.getUserById(id));
		model.addAttribute("updatedUser", new User());
		return "update";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") Long id, @ModelAttribute("updatedUser") User user) {
		if (service.putUser(id, user)) {
			return "redirect:/list";
		}
		return "redirect:/update";
	}

}
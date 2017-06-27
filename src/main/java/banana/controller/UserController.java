package banana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import banana.bean.User;
import banana.database.service.UserService;

@Controller
public class UserController {

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("userForm", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		return "login";
	}
}

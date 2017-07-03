package banana.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import banana.bean.User;
import banana.database.service.UserService;
import banana.util.system.ViewName;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){
		return userService.setModel(model).setViewName(ViewName.LOGIN).getLoginForm();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
		return userService.setBindingResult(bindingResult).setUser(userForm).setModel(model).setRequest(request).login();
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		return "register";
	}

	@RequestMapping(value = "/active", method = RequestMethod.GET)
	public String active(Model model) {
		return "active";
	}

	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String reset(Model model) {
		return "active";
	}

	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String reset(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		return "active";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "logout";
	}

}

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

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){
		return userService.setModel(model).getLoginForm();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
		return userService.setBindingResult(bindingResult).setUserForm(userForm).setModel(model).setRequest(request).login();
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		return userService.setModel(model).getRegisterForm();
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {
		return userService.setModel(model).setBindingResult(bindingResult).setUserForm(userForm).register();
	}

	@RequestMapping(value = "/active/{email}/", method = RequestMethod.GET)
	public String active(Model model,User userForm) {
		return userService.setUserForm(userForm).setModel(model).active();
	}

	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String reset(Model model) {
		return userService.setModel(model).getPasswordForm();
	}

	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String reset(@ModelAttribute("userForm") User userForm, Model model) {
		return userService.setUserForm(userForm).setModel(model).getPassword();
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		return userService.setRequest(request).logout();
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String changePassword(Model model) {
		return userService.setModel(model).getChangePasswordForm();
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("userForm") User userForm, Model model, HttpServletRequest request) {
		return userService.setUserForm(userForm).setModel(model).setRequest(request).changePassword();
	}

}

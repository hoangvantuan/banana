package banana.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import banana.database.service.UserService;

@Controller
public class HomepageController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/")
	public String homepage(Model model,  HttpServletRequest request) {
		return userService.setModel(model).setRequest(request).setDataForHomePage();
	}
}

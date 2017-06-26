package banana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import banana.bean.User;

@Controller
public class Test {

	@RequestMapping("/")
	public String start(Model model){
		model.addAttribute(new User());
		return "login";
	}
}

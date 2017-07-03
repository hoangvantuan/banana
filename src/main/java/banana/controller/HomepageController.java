package banana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import banana.database.service.AccountService;

@Controller
public class HomepageController {

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/")
	public String homepage(Model model) {

		return "homepage";
	}
}

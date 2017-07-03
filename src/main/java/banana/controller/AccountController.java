package banana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import banana.bean.Account;
import banana.database.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		return "addaccount";
	}

	public String add(@ModelAttribute("accountForm") Account account, BindingResult bindingResult, Model model) {
		return "addaccount";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model) {
		return "addaccount";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model) {
		return "editaccount";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String edit(@ModelAttribute("accountForm") Account account, BindingResult bindingResult, Model model) {
		return "editaccount";
	}

}

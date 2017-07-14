package banana.controller;

import banana.database.service.AccountService;
import banana.model.Account;
import banana.util.system.ViewName;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController {

  @ModelAttribute
  public Account getAccountForm() {
    return new Account();
  }

  @Autowired
  private AccountService accountService;

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public String add(Model model) {
    this.getAccountForm();
    return ViewName.ADDCCOUNT.get();
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String add(@ModelAttribute("account") @Valid Account account, BindingResult bindingResult, Model model, HttpServletRequest request) {
    return accountService.setAccount(account).setBindingResult(bindingResult).setModel(model).setRequest(request).createAccount();
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
  public String delete(Account account, Model model) {
    return accountService.setAccount(account).setModel(model).deleteAccount();
  }

  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
  public String edit(Account account, Model model) {
    return accountService.setAccount(account).setModel(model).editAccountForm();
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public String edit(@ModelAttribute("account") @Valid Account account, BindingResult bindingResult,Model model) {
    return accountService.setAccount(account).setBindingResult(bindingResult).setModel(model).editAccount();
  }

}

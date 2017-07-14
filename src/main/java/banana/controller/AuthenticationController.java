package banana.controller;

import banana.database.service.AuthenticationService;
import banana.model.User;
import banana.util.system.ViewName;
import banana.validation.CreateGroup;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {

  @ModelAttribute
  public User getUserForm() {
    return new User();
  }

  @Autowired
  private AuthenticationService authenticationService;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(Model model) {
    this.getUserForm();
    return ViewName.LOGIN.get();
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(@ModelAttribute("user") @Validated(CreateGroup.class) User userForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
    return authenticationService.setBindingResult(bindingResult).setUser(userForm).setModel(model).setRequest(request).login();
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String register(Model model) {
    this.getUserForm();
    return ViewName.REGISTER.get();
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String register(@ModelAttribute("user") @Validated(CreateGroup.class) User userForm, BindingResult bindingResult, Model model) {
    return authenticationService.setModel(model).setBindingResult(bindingResult).setUser(userForm).register();
  }

  @RequestMapping(value = "/active/{email}/", method = RequestMethod.GET)
  public String active(Model model, User userForm) {
    return authenticationService.setUser(userForm).setModel(model).active();
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(Model model, HttpServletRequest request) {
    return authenticationService.setRequest(request).logout();
  }

}

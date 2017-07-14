package banana.controller;

import banana.database.service.UserService;
import banana.model.User;
import banana.util.system.ViewName;
import banana.validation.UpdateGroup;
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
public class UserController {

  @ModelAttribute
  public User getUserForm() {
    return new User();
  }

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/reset", method = RequestMethod.GET)
  public String reset(Model model) {
    this.getUserForm();
    return ViewName.RESET.get();
  }

  @RequestMapping(value = "/reset", method = RequestMethod.POST)
  public String reset(@ModelAttribute("user") User userForm, Model model) {
    return userService.setUser(userForm).setModel(model).reset();
  }

  @RequestMapping(value = "/changepassword", method = RequestMethod.GET)
  public String changePassword(Model model) {
    this.getUserForm();
    return ViewName.CHANGEPASSWORD.get();
  }

  @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
  public String changePassword(@ModelAttribute("user") @Validated(UpdateGroup.class) User userForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
    return userService.setUser(userForm).setBindingResult(bindingResult).setModel(model).setRequest(request).changePassword();
  }

}

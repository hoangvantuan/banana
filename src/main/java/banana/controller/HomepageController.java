package banana.controller;

import banana.database.service.HomePageService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {

  @Autowired
  private HomePageService homePageService;

  @RequestMapping(value = "/")
  public String homepage(Model model, HttpServletRequest request) {
    return homePageService.setModel(model).setRequest(request).initHomePage();
  }

}

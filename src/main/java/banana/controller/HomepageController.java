package banana.controller;

import banana.database.service.HomePageService;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomepageController {

  @Autowired
  private HomePageService homePageService;

  @RequestMapping(value = "/")
  public String homepage(Model model, HttpServletRequest request) {
    return homePageService.setModel(model).setRequest(request).initHomePage();
  }

  @RequestMapping(value = "/page/{page}")
  public String homepage(Model model, @PathVariable Integer page, HttpServletRequest request) {
    return homePageService.setModel(model).setRequest(request).setPage(page).initHomePage();
  }

  @RequestMapping(value = "/search")
  public String search(Model model, @RequestParam String key, HttpServletRequest request) {
    return homePageService.setModel(model).setRequest(request).setKey(key).search();
  }

  @RequestMapping(value = "/search/page/{page}")
  public String search(Model model, @RequestParam String key, @PathVariable Integer page, HttpServletRequest request) {
    return homePageService.setModel(model).setRequest(request).setKey(key).setPage(page).search();
  }

  @ResponseBody
  @RequestMapping(value = "/changelanguage")
  public String changeLanguage(@RequestParam String lang) {
	  LocaleContextHolder.setLocale(new Locale(lang));
	  return "ok";
  }

}

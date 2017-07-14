package banana.database.service.impl;

import banana.database.dao.UserDAO;
import banana.database.service.HomePageService;
import banana.model.User;
import banana.util.system.Path;
import banana.util.system.SystemUtil;
import banana.util.system.ViewName;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomePageServiceImpl extends HomePageService {

  @Autowired
  private UserDAO userDAO;

  @Override
  @Transactional
  public String initHomePage() {
    clearNotifys();

    try {
      User user = (User) this.getRequest().getSession().getAttribute("user");
      user = userDAO.findByEmail(user.getEmail());
      if (SystemUtil.notNull(user)) {
        this.addModelAttribute("user", user);
        return ViewName.HOMEPAGE.get();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    this.setMessages("banana.login.error");
    this.addModelAttribute("messages", this.getMessages());
    return this.redirect(Path.LOGIN.get());
  }

}

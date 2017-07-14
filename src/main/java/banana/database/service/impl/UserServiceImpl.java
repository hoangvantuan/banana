package banana.database.service.impl;

import banana.database.dao.UserDAO;
import banana.database.service.UserService;
import banana.model.User;
import banana.util.email.EmailUtil;
import banana.util.system.SystemUtil;
import banana.util.system.ViewName;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends UserService {

  @Autowired
  private UserDAO userDAO;

  @Override
  @Transactional
  public String reset() {
    clearNotifys();

    try {
      User userTemp = userDAO.findByEmail(user.getEmail());
      if (SystemUtil.isNull(userTemp)) {
        this.setMessages("banana.user.reset.error.notexits");
      } else {
        EmailUtil email = new EmailUtil();
        email.sendPasswordMail(userTemp.getEmail(), userTemp.getPassword());
        this.setMessages("banana.user.reset.success");
      }
    } catch (Exception e) {
      e.printStackTrace();
      this.setMessages("banana.user.reset.error");
    }

    this.addModelAttribute("user", user);
    this.addModelAttribute("messages", this.getMessages());
    return ViewName.RESET.get();
  }

  @Override
  @Transactional
  public String changePassword() {
    this.clearNotifys();

    if (isHasError()) {
      return ViewName.CHANGEPASSWORD.get();
    }

    try {
      User userTemp = userDAO.findByEmail(((User) this.getRequest().getSession().getAttribute("user")).getEmail());
      if (SystemUtil.isNull(userTemp)) {
        this.setMessages("banana.changepassword.error.notexits");
      } else {
        userTemp.setPassword(user.getPassword());
        userTemp.setUpdateAt(new Date());
        userDAO.saveOrUpdate(userTemp);
        this.setMessages("banana.changepassword.success");
      }
    } catch (Exception e) {
      this.setMessages("banana.changepassword.error");
    }

    this.addModelAttribute("messages", this.getMessages());
    return ViewName.CHANGEPASSWORD.get();
  }
}

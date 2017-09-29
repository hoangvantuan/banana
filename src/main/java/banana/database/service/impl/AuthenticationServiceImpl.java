package banana.database.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banana.database.dao.UserDAO;
import banana.database.service.AuthenticationService;
import banana.model.User;
import banana.util.email.EmailUtil;
import banana.util.system.Path;
import banana.util.system.SystemUtil;
import banana.util.system.ViewName;

@Service
public class AuthenticationServiceImpl extends AuthenticationService {

  @Autowired
  private UserDAO userDAO;

  @Override
  @Transactional
  public String login() {
    this.clearNotifys();

    if (isHasError()) {
      return ViewName.LOGIN.get();
    }

    try {
      User userTemp = userDAO.checkLogin(this.getUser());
      if (SystemUtil.notNull(userTemp)) {
        if (userTemp.getActive()) {
          this.getRequest().getSession().setAttribute("user", userTemp);
          return this.redirect(Path.HONE.get());
        } else {
          this.setMessages("banana.login.message.not.active");
        }
      } else {
        this.setMessages("banana.login.error");
      }
    } catch (Exception e) {
      e.printStackTrace();
      this.setMessages("banana.login.error");
    }

    this.addModelAttribute("messages", this.getMessages());
    return ViewName.LOGIN.get();
  }

  @Override
  public String logout() {
    this.getRequest().getSession().removeAttribute("user");
    return redirect(Path.LOGIN.get());
  }

  @Override
  @Transactional
  public String register() {
    this.clearNotifys();

    if (isHasError()) {
      return ViewName.REGISTER.get();
    }

    try {
      User userTemp = userDAO.findByEmail(user.getEmail());
      if (SystemUtil.notNull(userTemp)) {
        this.setMessages("banana.register.error.account.exits");
      } else {
        userDAO.saveOrUpdate(user);
        EmailUtil email = new EmailUtil();
        email.sendThankyouMail(user.getEmail());
        this.setMessages("banana.register.success");
      }

    } catch (Exception e) {
      e.printStackTrace();
      this.setMessages("banana.register.error");
    }

    this.addModelAttribute("messages", this.getMessages());
    return ViewName.REGISTER.get();
  }

  @Override
  @Transactional
  public String active() {
    this.clearNotifys();

    try {
      User userTemp = userDAO.findByEmail(user.getEmail());
      if (SystemUtil.isNull(userTemp)) {
        this.setMessages("banana.active.error.notexits");
      } else if (userTemp.getActive()) {
        this.setMessages("banana.active.error.actived");
      } else {
        userTemp.setActive(true);
        userTemp.setUpdateAt(new Date());
        userDAO.saveOrUpdate(userTemp);
        this.setMessages("banana.active.success");
      }
    } catch (Exception e) {
      e.printStackTrace();
      this.setMessages("banana.active.error");
    }

    this.addModelAttribute("messages", this.getMessages());

    return ViewName.LOGIN.get();
  }

}

package banana.database.service.impl;

import banana.database.dao.AccountDAO;
import banana.database.dao.UserDAO;
import banana.database.service.HomePageService;
import banana.model.Account;
import banana.model.User;
import banana.util.system.Path;
import banana.util.system.ViewName;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomePageServiceImpl extends HomePageService {

  @Autowired
  private UserDAO userDAO;
  @Autowired
  private AccountDAO accountDAO;

  public final Integer LIMIT = 10;

  @Override
  @Transactional
  public String initHomePage() {
    clearNotifys();

    if (page == null || page <= 0) {
      page = 1;
    }

    try {
      User user = (User) this.getRequest().getSession().getAttribute("user");
      user = userDAO.findByEmail(user.getEmail());

      Integer sumPages = user.getAccounts().size() % LIMIT == 0 ? user.getAccounts().size() / LIMIT : user.getAccounts().size() / LIMIT + 1;
      List<Integer> pages = new ArrayList<Integer>();
      for (int i = 1; i <= sumPages; i++) {
        pages.add(i);
      }

      List<Account> accounts = accountDAO.listAll(user.getId(), LIMIT, LIMIT * (page - 1));
      user.setAccounts(accounts);
      this.addModelAttribute("user", user);
      this.addModelAttribute("pages", pages);
      this.addModelAttribute("currentPage", page);
      return ViewName.HOMEPAGE.get();
    } catch (Exception e) {
      e.printStackTrace();
    }

    this.setMessages("banana.login.error");
    this.addModelAttribute("messages", this.getMessages());
    return this.redirect(Path.LOGIN.get());
  }

  @Override
  @Transactional
  public String search() {
    clearNotifys();

    if(page == null || page < 0) {
      page = 1;
    }

    if(key == null) {
      key = "";
    }

    try {
      User user = (User) this.getRequest().getSession().getAttribute("user");
      user = userDAO.findByEmail(user.getEmail());

      List<Account> accounts = accountDAO.search(key, user.getId());

      Integer sumPages = accounts.size() % LIMIT == 0 ? accounts.size() / LIMIT : accounts.size() / LIMIT + 1;

      List<Integer> pages = new ArrayList<Integer>();
      for (int i = 1; i <= sumPages; i++) {
        pages.add(i);
      }

      List<Account> filterAccounts = accountDAO.search(key, user.getId(), LIMIT, LIMIT * (page - 1));

      user.setAccounts(filterAccounts);
      this.addModelAttribute("key", key);
      this.addModelAttribute("user", user);
      this.addModelAttribute("pages", pages);
      this.addModelAttribute("currentPage", page);
      return ViewName.HOMEPAGE.get();
    } catch (Exception e) {
      e.printStackTrace();
    }

    this.setMessages("banana.login.error");
    this.addModelAttribute("messages", this.getMessages());
    return this.redirect(Path.LOGIN.get());
  }

}

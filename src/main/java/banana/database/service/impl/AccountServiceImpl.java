package banana.database.service.impl;

import banana.database.dao.AccountDAO;
import banana.database.service.AccountService;
import banana.model.Account;
import banana.model.User;
import banana.util.system.SystemUtil;
import banana.util.system.ViewName;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends AccountService {

  @Autowired
  private AccountDAO accountDAO;

  @Override
  @Transactional
  public String createAccount() {
    clearNotifys();

    if (isHasError()) {
      return ViewName.ADDCCOUNT.get();
    }

    try {
      User user = (User) request.getSession().getAttribute("user");
      account.setUser(user);
      accountDAO.saveOrUpdate(account);
      this.setMessages("banana.account.add.success");
    } catch (Exception e) {
      e.printStackTrace();
      this.setMessages("banana.account.add.error");
    }

    this.addModelAttribute("messages", getMessages());
    this.addModelAttribute("account", account);

    return ViewName.ADDCCOUNT.get();
  }

  @Override
  @Transactional
  public String editAccount() {
    clearNotifys();

    if (isHasError()) {
      return ViewName.EDITACCOUNT.get();
    }

    try {
      Account accountTemp = (Account) accountDAO.findById(account.getId());
      if (SystemUtil.notNull(accountTemp)) {

        accountTemp.setUpdateAt(new Date());
        accountTemp.setUrl(account.getUrl());
        accountTemp.setAccountName(account.getAccountName());
        accountTemp.setPassword(account.getPassword());

        accountDAO.saveOrUpdate(accountTemp);
        setMessages("banana.account.edit.success");
      } else {
        setMessages("banana.account.edit.error.id.not.found");
      }
    } catch (Exception e) {
      e.printStackTrace();
      setMessages("banana.account.edit.error");
    }

    addModelAttribute("messages", messages);

    return ViewName.EDITACCOUNT.get();
  }

  @Override
  @Transactional
  public String editAccountForm() {
    clearNotifys();

    try {
      Account accountTemp = (Account) accountDAO.findById(account.getId());
      if (SystemUtil.notNull(accountTemp)) {
        addModelAttribute("account", accountTemp);
      } else {
        setMessages("banana.account.edit.error.id.not.found");
      }
    } catch (Exception e) {
      e.printStackTrace();
      setMessages("banana.account.edit.error.id.not.found");
    }

    addModelAttribute("messages", messages);

    return ViewName.EDITACCOUNT.get();
  }

  @Override
  @Transactional
  public String deleteAccount() {
    try {
      Account accountTemp = (Account) accountDAO.findById(account.getId());
      if (SystemUtil.notNull(accountTemp)) {
        accountDAO.delete(accountTemp);
      } else {
        return "banana.account.delete.error.id.not.found";
      }
    } catch (Exception e) {
      e.printStackTrace();
      return "banana.account.delete.error.id.not.found";
    }

    return "banana.account.delete.success";
  }

}

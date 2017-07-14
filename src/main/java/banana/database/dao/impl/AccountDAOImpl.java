package banana.database.dao.impl;

import banana.database.dao.AccountDAO;
import banana.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl extends GenericDAOImpl<Account, Integer> implements AccountDAO {

  public AccountDAOImpl() {}

  @Override
  Class getFormClass() {
    return Account.class;
  }

  @Override
  String getEntityName() {
    return "Account";
  }
}

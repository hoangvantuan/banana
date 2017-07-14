package banana.database.dao.impl;

import banana.database.dao.AccountDAO;
import banana.model.Account;
import java.util.List;
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

  @Override
  public List<Account> listAll(Integer userId, Integer limit, Integer offset) throws Exception {
    List<Account> listAll = this.getSession().createQuery("FROM " + this.getEntityName() + " AS A WHERE A.user.id = " + "\'" + userId + "\'" + " ORDER BY A.id ASC").setFirstResult(offset).setMaxResults(limit).list();
    return listAll;
  }

  @Override
  public List<Account> search(String key, Integer userId, Integer limit, Integer offset) throws Exception {
    List<Account> listAll = this.getSession().createQuery("FROM " + this.getEntityName() + " AS A WHERE A.user.id = " + "\'" + userId + "\'" + " AND(A.url LIKE '%" + key +"%' OR A.accountName LIKE '%" + key +"%')" + " ORDER BY A.id ASC").setFirstResult(offset).setMaxResults(limit).list();
    return listAll;
  }

  @Override
  public List<Account> search(String key, Integer userId) throws Exception {
    List<Account> listAll = this.getSession().createQuery("FROM " + this.getEntityName() + " AS A WHERE A.user.id = " + "\'" + userId + "\'" + " AND(A.url LIKE '%" + key +"%' OR A.accountName LIKE '%" + key +"%')" + " ORDER BY A.id ASC").list();
    return listAll;
  }
}

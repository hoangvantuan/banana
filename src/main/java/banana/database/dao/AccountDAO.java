package banana.database.dao;

import banana.model.Account;
import java.util.List;

public interface AccountDAO extends GenericDAO<Account, Integer> {
  public List<Account> listAll(Integer userId, Integer limit, Integer offset) throws Exception;

  public List<Account> search(String key, Integer userId, Integer limit, Integer offset) throws Exception;

  public List<Account> search(String key, Integer userId) throws Exception;
}

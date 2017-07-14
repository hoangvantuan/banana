package banana.database.dao;

import banana.model.User;

public interface UserDAO extends GenericDAO<User, Integer> {

  public User findByEmail(String email) throws Exception;

  public User checkLogin(User user) throws Exception;
}

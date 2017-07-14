package banana.database.dao.impl;

import banana.database.dao.UserDAO;
import banana.model.User;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {

  public UserDAOImpl() {}

  @Override
  Class getFormClass() {
    return User.class;
  }

  @Override
  String getEntityName() {
    return "User";
  }

  @Override
  public User findByEmail(String email) throws Exception {
    List<User> users = (List<User>) this.getSession().createQuery("FROM " + this.getEntityName() + " AS A WHERE A.email = " + "\'" + email + "\'").list();
    if (users.size() == 1) {
      return users.get(0);
    }
    return null;
  }

  @Override
  public User checkLogin(User user) throws Exception {
    List<User> users = (List<User>) this.getSession()
        .createQuery("FROM " + this.getEntityName() + " AS A WHERE A.email = " + "\'" + user.getEmail() + "\'" + " AND A.password = " + "\'" + user.getPassword() + "\'").list();
    if (users.size() == 1) {
      return users.get(0);
    }
    return null;
  }
}

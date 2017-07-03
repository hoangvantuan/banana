package banana.database.dao;

import banana.bean.User;

public interface UserDAO extends GenericDAO<User, String>{

	public User findByEmail(String email) throws Exception;
	public User checkLogin(User user) throws Exception;
}

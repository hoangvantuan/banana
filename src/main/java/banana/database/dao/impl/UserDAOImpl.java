package banana.database.dao.impl;

import org.springframework.stereotype.Repository;

import banana.bean.User;
import banana.database.dao.UserDAO;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User, String> implements UserDAO {

	public UserDAOImpl() {
	}

	@Override
	Class getFormClass() {
		return User.class;
	}

	@Override
	String getEntityName() {
		return "User";
	}
}

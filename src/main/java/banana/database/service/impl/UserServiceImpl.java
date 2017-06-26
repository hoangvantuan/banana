package banana.database.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import banana.bean.User;
import banana.database.dao.UserDAO;
import banana.database.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void create(User user) throws Exception {
		this.userDAO.create(user);
	}

	@Override
	@Transactional
	public List<User> listAll() throws Exception {
		return this.userDAO.listAll();
	}
}

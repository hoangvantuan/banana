package banana.database.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banana.bean.User;
import banana.database.dao.UserDAO;
import banana.database.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;

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

	@Override
	@Transactional
	public User getUserByEmail(String email) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}

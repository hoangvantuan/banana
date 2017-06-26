package banana.database.service;

import java.util.List;

import banana.bean.User;

public interface UserService {

	public void create(User user) throws Exception;
	public List<User> listAll() throws Exception;
}

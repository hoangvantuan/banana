package banana.database.service;

import banana.bean.User;

public abstract class UserService extends BaseService<UserService> {

	protected User user;

	public abstract String getLoginForm();
	public abstract String login();

	public User getUser() {
		return user;
	}

	public UserService setUser(User user) {
		this.user = user;
		return this;
	}

}

package banana.database.service;

import banana.bean.User;

public abstract class UserService extends BaseService<UserService> {

	protected User userForm;

	public abstract String getLoginForm();
	public abstract String login();
	public abstract String setDataForHomePage();
	public abstract String logout();
	public abstract String getRegisterForm();
	public abstract String register();
	public abstract String active();
	public abstract String getPasswordForm();
	public abstract String getPassword();
	public abstract String getChangePasswordForm();
	public abstract String changePassword();

	public User getUserForm() {
		return userForm;
	}

	public UserService setUserForm(User userForm) {
		this.userForm = userForm;
		return this;
	}

}

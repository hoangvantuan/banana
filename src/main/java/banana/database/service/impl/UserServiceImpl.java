package banana.database.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import banana.bean.User;
import banana.database.dao.UserDAO;
import banana.database.service.UserService;
import banana.util.email.EmailUtil;
import banana.util.system.Path;
import banana.util.system.SystemUtil;
import banana.util.system.ViewName;

@Service
public class UserServiceImpl extends UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public String getLoginForm() {
		User user = new User();
		this.addModelAttribute("userForm", user);

		return ViewName.LOGIN.get();
	}

	@Override
	@Transactional
	public String login() {
		this.clearNotifys();

		if(this.getBindingResult().hasErrors()) {
			for(ObjectError error : this.getBindingResult().getAllErrors()) {
				this.setMessages(error.getDefaultMessage());
			}
			this.addModelAttribute("messages", this.getMessages());
			return ViewName.LOGIN.get();
		}

		try {
			User user = userDAO.checkLogin(userForm);
			if(SystemUtil.notNull(user)) {
				if(user.getActive()) {
					this.getRequest().getSession().setAttribute("user", user);
					return this.redirect(Path.HONE.get());
				} else {
					this.addModelAttribute("userForm", user);
					this.setMessages("banana.login.message.not.active");
				}
			} else {
				this.setMessages("banana.login.error");
			}
		} catch(Exception e) {
			e.printStackTrace();
			this.setMessages("banana.login.error");
		}

		this.addModelAttribute("messages", this.getMessages());
		return ViewName.LOGIN.get();
	}

	@Override
	@Transactional
	public String setDataForHomePage() {
		this.clearNotifys();

		User user = (User) this.getRequest().getSession().getAttribute("user");
		try {
			user = userDAO.checkLogin(user);
			if(SystemUtil.notNull(user)) {
				this.addModelAttribute("userForm", user);
				return ViewName.HOMEPAGE.get();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		this.setMessages("banana.login.error");
		this.addModelAttribute("messages", this.getMessages());
		return this.redirect(Path.LOGIN.get());
	}

	@Override
	public String logout() {
		this.getRequest().getSession().removeAttribute("user");
		return redirect(Path.LOGIN.get());
	}

	@Override
	public String getRegisterForm() {
		User user = new User();
		this.addModelAttribute("userForm", user);

		return ViewName.REGISTER.get();
	}

	@Override
	@Transactional
	public String register() {
		this.clearNotifys();

		if(this.getBindingResult().hasErrors()) {
			for(ObjectError error : this.getBindingResult().getAllErrors()) {
				this.setMessages(error.getDefaultMessage());
			}
			this.addModelAttribute("messages", this.getMessages());
			return ViewName.REGISTER.get();
		}



		try {
			User user = userDAO.findByEmail(userForm.getEmail());
			if(SystemUtil.notNull(user)) {
				this.setMessages("banana.register.error.account.exits");
			}
			else {
				userDAO.saveOrUpdate(userForm);
				EmailUtil email = new EmailUtil();
				email.sendThankyouMail(userForm.getEmail());
				this.setMessages("banana.register.success");
			}

		} catch(Exception e) {
			e.printStackTrace();
			this.setMessages("banana.register.error");
		}

		this.addModelAttribute("messages", this.getMessages());
		return ViewName.REGISTER.get();
	}

	@Override
	@Transactional
	public String active() {
		this.clearNotifys();

		try {
			User user = userDAO.findByEmail(userForm.getEmail());
			if(SystemUtil.isNull(user)) {
				user = new User();
				this.setMessages("banana.active.error.notexits");
			} else if(user.getActive()) {
				this.setMessages("banana.active.error.actived");
			} else
				{
				user.setActive(true);
				user.setUpdateAt(new Date());
				userDAO.saveOrUpdate(user);
				this.setMessages("banana.active.success");
			}
			this.addModelAttribute("userForm", user);
		} catch(Exception e) {
			e.printStackTrace();
			this.setMessages("banana.active.error");
			this.addModelAttribute("userForm", new User());
		}

		this.addModelAttribute("messages", this.getMessages());

		return ViewName.LOGIN.get();
	}

	@Override
	public String getPasswordForm() {
		this.addModelAttribute("userForm", new User());

		return ViewName.RESET.get();
	}

	@Override
	@Transactional
	public String getPassword() {
		clearNotifys();

		try {
			User user = userDAO.findByEmail(userForm.getEmail());
			if(SystemUtil.isNull(user)) {
				this.setMessages("banana.user.reset.error.notexits");
			} else {
				EmailUtil email = new EmailUtil();
				email.sendPasswordMail(user.getEmail(), user.getPassword());
				this.setMessages("banana.user.reset.success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setMessages("banana.user.reset.error");
		}

		this.addModelAttribute("userForm", userForm);
		this.addModelAttribute("messages", this.getMessages());
		return ViewName.RESET.get();
	}

	@Override
	public String getChangePasswordForm() {
		this.addModelAttribute("userForm", new User());
		return ViewName.CHANGEPASSWORD.get();
	}

	@Override
	@Transactional
	public String changePassword() {
		this.clearNotifys();

		if(this.getBindingResult().hasErrors()) {
			for(ObjectError error : this.getBindingResult().getAllErrors()) {
				this.setMessages(error.getDefaultMessage());
			}
			this.addModelAttribute("messages", this.getMessages());
			return ViewName.CHANGEPASSWORD.get();
		}

		try {
			User user = userDAO.findByEmail(((User)this.getRequest().getSession().getAttribute("user")).getEmail());
			if(SystemUtil.isNull(user)) {
				this.setMessages("banana.changepassword.error.notesits");
			} else {
				user.setPassword(userForm.getPassword());
				userDAO.saveOrUpdate(user);
				this.setMessages("banana.changepassword.success");
			}
		} catch(Exception e) {
			e.printStackTrace();
			this.setMessages("banana.changepassword.error");
		}
		this.addModelAttribute("userForm", new User());
		this.addModelAttribute("messages", this.getMessages());
		return ViewName.CHANGEPASSWORD.get();
	}
}

package banana.database.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banana.bean.User;
import banana.database.dao.UserDAO;
import banana.database.service.UserService;
import banana.util.system.SystemUtil;
import banana.util.system.ViewName;

@Service
public class UserServiceImpl extends UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public String getLoginForm() {
		this.clearNotifys();
		User user = new User();
		this.getModel().addAttribute("userForm", user);

		return this.getViewName();
	}

	@Override
	@Transactional
	public String login() {
		this.clearNotifys();
		if(this.getBindingResult().hasErrors()) {
			return this.getViewName();
		}

		try {
			User user = userDAO.checkLogin(this.user);
			if(SystemUtil.isNull(user)) {
				this.setMessages("banana.login.error");
				this.getModel().addAttribute("messages", this.getMessages());
				return ViewName.LOGIN.getViewName();
			}
			else {
				this.getRequest().getSession().setAttribute("user", user);
				this.setMessages("banana.login.message.success");
				return redirect("/");
			}
		} catch(Exception e) {
			e.printStackTrace();
			this.setMessages("banana.login.error");
			this.getModel().addAttribute("messages", this.getMessages());
			return ViewName.LOGIN.getViewName();
		}
	}

}

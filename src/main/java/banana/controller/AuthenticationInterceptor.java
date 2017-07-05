package banana.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import banana.bean.User;
import banana.util.system.Path;
import banana.util.system.SystemUtil;

/**
 *
 * @author hoang_van_tuan
 *
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

	private List<String> userPaths;
	private List<String> guestPaths;

	public AuthenticationInterceptor() {
		userPaths = new ArrayList<String>();
		guestPaths = new ArrayList<String>();

		/* guest action */
		guestPaths.add("^/banana/login/?$");
		guestPaths.add("^/banana/register/?$");
		guestPaths.add("^/banana/active.*/$");
		guestPaths.add("^/banana/reset$");

		/* user action */
		userPaths.add("^/banana/?$");
		userPaths.add("^/banana/account/add/?$");
		userPaths.add("^/banana/account/edit/.*$");
		userPaths.add("^/banana/account/delele/.*$");
		userPaths.add("^/banana/changepassword$");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		User user = (User)request.getSession().getAttribute("user");
		String path = request.getRequestURI();
		if(SystemUtil.isNull(user)) {
			for(String temp : userPaths) {
				if(path.matches(temp)) {
					response.sendRedirect(request.getContextPath() + Path.LOGIN.get());
					return false;
				}
			}

		} else {
			for(String temp : guestPaths) {
				if(path.matches(temp)) {
					response.sendRedirect(request.getContextPath() + Path.HONE.get());
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}
}

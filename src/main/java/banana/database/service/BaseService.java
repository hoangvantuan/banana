package banana.database.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import banana.util.system.ViewName;

public class BaseService<T> {

	private ViewName viewName;
	private Model model;
	private BindingResult bindingResult;
	private HttpServletRequest request;
	private List<String> messages;

	public BaseService() {
		this.viewName = ViewName.HOMEPAGE;
	}

	public String getViewName() {
		return viewName.getViewName();
	}

	public T setViewName(ViewName viewName) {
		this.viewName = viewName;
		return (T) this;
	}

	public Model getModel() {
		return model;
	}

	public T setModel(Model model) {
		this.model = model;
		return (T) this;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public T setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
		return (T) this;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public T setRequest(HttpServletRequest request) {
		this.request = request;
		return (T) this;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public void setMessages(String message) {
		if(this.messages == null) {
			messages = new ArrayList<String>();
		}

		messages.add(message);
	}

	public void clearNotifys() {
		if(messages != null && messages.size() != 0)
			this.messages.clear();
	}

	public String redirect(String path) {
		return "redirect:" + path;
	}
}

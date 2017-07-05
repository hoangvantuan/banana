package banana.database.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public class BaseService<T> {

	private Model model;
	private BindingResult bindingResult;
	private HttpServletRequest request;
	private List<String> messages;

	public BaseService() {
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

	public T setMessages(List<String> messages) {
		if(messages != null && this.messages.size() == 0)
			this.messages = messages;
		else {
			messages.addAll(messages);
		}
		return (T) this;
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

	public void addModelAttribute(String modelName, Object model) {
		this.getModel().addAttribute(modelName, model);
	}
}

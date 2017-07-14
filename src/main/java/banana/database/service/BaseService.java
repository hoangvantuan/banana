package banana.database.service;

import banana.model.Account;
import banana.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class BaseService<T> {

  protected Model model;
  protected BindingResult bindingResult;
  protected HttpServletRequest request;
  protected List<String> messages;
  protected User user;
  protected Account account;

  public BaseService() {
    this.model = null;
    this.bindingResult = null;
    this.request = null;
    this.messages = null;
    this.user = null;
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
    if (messages != null && this.messages.size() == 0)
      this.messages = messages;
    else {
      messages.addAll(messages);
    }
    return (T) this;
  }

  public void setMessages(String message) {
    if (this.messages == null) {
      messages = new ArrayList<String>();
    }

    messages.add(message);
  }

  public User getUser() {
    return user;
  }

  public T setUser(User user) {
    this.user = user;
    return (T) this;
  }

  public Account getAccount() {
    return account;
  }

  public T setAccount(Account account) {
    this.account = account;
    return (T) this;
  }

  public void clearNotifys() {
    if (messages != null && messages.size() != 0)
      this.messages.clear();
  }

  public String redirect(String path) {
    return "redirect:" + path;
  }

  public void addModelAttribute(String modelName, Object model) {
    this.getModel().addAttribute(modelName, model);
  }

  public boolean isHasError() {
    if (this.getBindingResult().hasErrors()) {
      for (ObjectError error : this.getBindingResult().getAllErrors()) {
        this.setMessages(error.getDefaultMessage());
      }
      this.addModelAttribute("messages", this.getMessages());
      return true;
    } else {
      return false;
    }
  }
}

package banana.database.service;

public abstract class AuthenticationService extends BaseService<AuthenticationService> {

  public abstract String login();

  public abstract String logout();

  public abstract String register();

  public abstract String active();
}

package banana.database.service;

public abstract class UserService extends BaseService<UserService> {

  public abstract String reset();

  public abstract String changePassword();

}

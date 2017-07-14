package banana.database.service;

public abstract class AccountService extends BaseService<AccountService> {

  public abstract String createAccount();

  public abstract String editAccount();

  public abstract String editAccountForm();

  public abstract String deleteAccount();
}

package banana.database.dao.impl;

import org.springframework.stereotype.Repository;

import banana.bean.Account;
import banana.bean.User;
import banana.database.dao.AccountDAO;

@Repository
public class AccountDAOImpl extends GenericDAOImpl<Account, String> implements AccountDAO {

	public AccountDAOImpl() {
	}

	@Override
	Class getFormClass() {
		return User.class;
	}

	@Override
	String getEntityName() {
		return "Account";
	}
}

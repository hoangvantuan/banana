package banana.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banana.database.dao.AccountDAO;
import banana.database.service.AccountService;

@Service
public class AccountServiceImpl extends AccountService{

	@Autowired
	private AccountDAO accountDAO;

}

package net.nilsghesquiere.services;

import net.nilsghesquiere.DAO.AccountDAO;
import net.nilsghesquiere.entities.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
	private final AccountDAO accountDAO;
	
	@Autowired
	public AccountServiceImpl(@Qualifier("staticAccount") AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	public Account getAccount(){
		return accountDAO.getAccount();
	}
}

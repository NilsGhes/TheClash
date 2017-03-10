package net.nilsghesquiere.services;

import net.nilsghesquiere.entities.Account;
import net.nilsghesquiere.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class AccountServiceImpl implements AccountService{
	private final AccountRepository accountRepository;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository){
		this.accountRepository = accountRepository;
	}
	
	public Account read(long id){
		return accountRepository.findOne(id);
	}
}

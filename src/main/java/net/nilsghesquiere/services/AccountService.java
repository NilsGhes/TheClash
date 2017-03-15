package net.nilsghesquiere.services;

import java.util.List;

import net.nilsghesquiere.entities.Account;
import net.nilsghesquiere.entities.Jeugdhuis;

public interface AccountService {
	Account read(long id);
	List<Account> findAll();
	void create(Account account);
}

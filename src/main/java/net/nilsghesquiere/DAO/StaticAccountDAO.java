package net.nilsghesquiere.DAO;

import net.nilsghesquiere.entities.Account;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("static")
class StaticAccountDAO implements AccountDAO{
	
	public Account getAccount(){
		return new Account("nils");
	}
}

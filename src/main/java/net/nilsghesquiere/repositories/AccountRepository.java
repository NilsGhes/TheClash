package net.nilsghesquiere.repositories;

import net.nilsghesquiere.entities.Account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{
}

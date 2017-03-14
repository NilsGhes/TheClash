package net.nilsghesquiere.repositories;

import net.nilsghesquiere.entities.Jeugdhuis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JeugdhuisRepository extends CrudRepository<Jeugdhuis, Long>{
	
}

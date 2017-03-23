package net.nilsghesquiere.repositories;

import java.util.List;

import net.nilsghesquiere.entities.Jeugdhuis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JeugdhuisRepository extends CrudRepository<Jeugdhuis, Long>{
	 public List<Jeugdhuis> findAllByOrderByIdAsc();
}

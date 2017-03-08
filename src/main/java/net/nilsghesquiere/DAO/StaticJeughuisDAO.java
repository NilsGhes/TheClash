package net.nilsghesquiere.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.nilsghesquiere.entities.Account;
import net.nilsghesquiere.entities.Jeugdhuis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("staticJeugdhuis")
class StaticJeughuisDAO implements JeugdhuisDAO{
	
	private final Map<Long, Jeugdhuis> jeugdhuizen = new ConcurrentHashMap<>();
	
	StaticJeughuisDAO() {
		jeugdhuizen.put(1L, new Jeugdhuis(1L, "Den Traveir", 97, new Account(1L,"Nils")));
		jeugdhuizen.put(2L, new Jeugdhuis(2L, "Chaplin", 23, new Account(2L,"Lukas")));
	}
	
	@Override
	public void create(Jeugdhuis jeugdhuis) {
		jeugdhuis.setId(Collections.max(jeugdhuizen.keySet())+1);
		jeugdhuizen.put(jeugdhuis.getId(), jeugdhuis);
	}

	@Override
	public Jeugdhuis read(long id) {
		return jeugdhuizen.get(id);
	}

	@Override
	public void update(Jeugdhuis jeugdhuis) {
		jeugdhuizen.put(jeugdhuis.getId(),jeugdhuis);
	}
	
	@Override
	public void delete(long id) {
		jeugdhuizen.remove(id);
	}

	@Override
	public List<Jeugdhuis> findaAll() {
		return new ArrayList<>(jeugdhuizen.values());
	}

	@Override
	public long findAantalJeugdhuizen() {
		return jeugdhuizen.size();
	}
}

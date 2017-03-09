package net.nilsghesquiere.services;

import java.util.List;

import net.nilsghesquiere.entities.Jeugdhuis;

public interface JeugdhuisService {
	void create(Jeugdhuis jeugdhuis);
	Jeugdhuis read(long id);
	void delete(long id);
	void update(Jeugdhuis jeugdhuis);
	List<Jeugdhuis> findAll();
	long findAantalJeugdhuizen();
}

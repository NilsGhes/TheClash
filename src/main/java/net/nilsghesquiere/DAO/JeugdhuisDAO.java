package net.nilsghesquiere.DAO;

import java.util.List;

import net.nilsghesquiere.entities.Jeugdhuis;


public interface JeugdhuisDAO {
	void create(Jeugdhuis jeugdhuis);
	Jeugdhuis read(long id);
	void delete(long id);
	void update(Jeugdhuis jeugdhuis);
	List<Jeugdhuis> findaAll();
	long findAantalJeugdhuizen();
	//long findAantalLeden(long id);
}

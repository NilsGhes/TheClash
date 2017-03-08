package net.nilsghesquiere.services;

import java.util.List;

import net.nilsghesquiere.DAO.JeugdhuisDAO;
import net.nilsghesquiere.entities.Jeugdhuis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JeugdhuisServiceImpl implements JeugdhuisService{
	private final JeugdhuisDAO jeugdhuisDAO;
	
	@Autowired
	public JeugdhuisServiceImpl(@Qualifier("staticJeugdhuis") JeugdhuisDAO jeugdhuisDAO){
		this.jeugdhuisDAO = jeugdhuisDAO;
	}
	
	@Override
	public void create(Jeugdhuis jeugdhuis) {
		jeugdhuisDAO.create(jeugdhuis);
	}

	@Override
	public Jeugdhuis read(long id) {
		return jeugdhuisDAO.read(id);
	}

	@Override
	public void delete(long id) {
		jeugdhuisDAO.delete(id);
	}

	@Override
	public void update(Jeugdhuis jeugdhuis) {
		jeugdhuisDAO.update(jeugdhuis);
	}

	@Override
	public List<Jeugdhuis> findaAll() {
		return jeugdhuisDAO.findaAll();
	}

	@Override
	public long findAantalJeugdhuizen() {
		return jeugdhuisDAO.findAantalJeugdhuizen();
	}
	
}

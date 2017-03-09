package net.nilsghesquiere.services;

import java.util.List;

import net.nilsghesquiere.entities.Jeugdhuis;
import net.nilsghesquiere.repositories.JeugdhuisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JeugdhuisServiceImpl implements JeugdhuisService{
	private final JeugdhuisRepository jeugdhuisRepository;
	
	@Autowired
	public JeugdhuisServiceImpl(@Qualifier("staticJeugdhuis") JeugdhuisRepository jeugdhuisRepository){
		this.jeugdhuisRepository = jeugdhuisRepository;
	}
	
	@Override
	public void create(Jeugdhuis jeugdhuis) {
		jeugdhuisRepository.save(jeugdhuis);
	}

	@Override
	public Jeugdhuis read(long id) {
		return jeugdhuisRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		jeugdhuisRepository.delete(id);
	}

	@Override
	public void update(Jeugdhuis jeugdhuis) {
		jeugdhuisRepository.save(jeugdhuis);
	}

	@Override
	public List<Jeugdhuis> findAll() {
		return (List<Jeugdhuis>) jeugdhuisRepository.findAll();
	}

	@Override
	public long findAantalJeugdhuizen() {
		return jeugdhuisRepository.count();
	}
	
}

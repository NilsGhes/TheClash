package net.nilsghesquiere.services;

import net.nilsghesquiere.DAO.JeugdhuisDAO;
import net.nilsghesquiere.entities.Jeugdhuis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JeugdhuisService{
	private final JeugdhuisDAO jeugdhuisDAO;
	
	@Autowired
	public JeugdhuisService(@Qualifier("staticJeugdhuis") JeugdhuisDAO jeugdhuisDAO){
		this.jeugdhuisDAO = jeugdhuisDAO;
	}
	
	public Jeugdhuis getJeugdhuis(){
		return jeugdhuisDAO.getJeugdhuis();
	}
	
}

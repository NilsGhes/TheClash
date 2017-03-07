package net.nilsghesquiere.DAO;

import net.nilsghesquiere.entities.Jeugdhuis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("staticJeugdhuis")
class StaticJeughuisDAO implements JeugdhuisDAO{
	
	public Jeugdhuis getJeugdhuis(){
		return new Jeugdhuis("dentraveir");
	}
}

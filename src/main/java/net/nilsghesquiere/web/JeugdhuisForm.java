package net.nilsghesquiere.web;

import javax.validation.constraints.NotNull;

import net.nilsghesquiere.entities.Jeugdhuis;

public class JeugdhuisForm {
	@NotNull
	private Jeugdhuis jeugdhuis;

	public Jeugdhuis getJeugdhuis() {
		return jeugdhuis;
	}

	public void setJeugdhuis(Jeugdhuis jeugdhuis) {
		this.jeugdhuis = jeugdhuis;
	}
	
}

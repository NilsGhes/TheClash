package net.nilsghesquiere.entities;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class Jeugdhuis {
	private long id;
	@NotBlank
	private String name;
	@Min(0)
	private int aantalDranken;
	private Account eigenaar;
	
	public Jeugdhuis(long id, String name, int aantalDranken, Account eigenaar) {
		this.id=id;
		this.name = name;
		this.aantalDranken = aantalDranken;
		this.eigenaar = eigenaar;
	}

	public Jeugdhuis(long id, String name, int aantalDranken) {
		this.id=id;
		this.name = name;
		this.aantalDranken = aantalDranken;
		this.eigenaar = null;
	}
	
	public Jeugdhuis() {

	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAantalDranken() {
		return aantalDranken;
	}

	public Account getEigenaar() {
		return eigenaar;
	}

	public void setEigenaar(Account eigenaar) {
		this.eigenaar = eigenaar;
	}
	
	public void setAantalDranken(Integer aantalDranken) {
		this.aantalDranken = aantalDranken;
	}

	public void incrementAantalDranken(){
		this.aantalDranken++;
	}

	public void setId(long id) {
		this.id=id;
	}
	
}

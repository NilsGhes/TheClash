package net.nilsghesquiere.entities;

public class Jeugdhuis {
	private String name;
	private Integer aantalDranken;
	
	public Jeugdhuis(String name) {
		super();
		this.name = name;
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

	public void setAantalDranken(Integer aantalDranken) {
		this.aantalDranken = aantalDranken;
	}
	
}

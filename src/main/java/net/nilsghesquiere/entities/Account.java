package net.nilsghesquiere.entities;

public class Account {
	private String name;
	private Jeugdhuis jeugdhuis;
	boolean isBaas;
	
	public Account(String name) {
		this.name = name;
		this.isBaas = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Jeugdhuis getJeugdhuis() {
		return jeugdhuis;
	}

	public void setJeugdhuis(Jeugdhuis jeugdhuis) {
		this.jeugdhuis = jeugdhuis;
	}
	
}

package net.nilsghesquiere.entities;

public class Account {
	long id;
	private String name;
	
	public Account(long id, String name) {
		this.id=id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

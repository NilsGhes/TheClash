package net.nilsghesquiere.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Entity
@Table(name ="jeugdhuizen")
public class Jeugdhuis implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonIgnore
	@NotBlank
	private String name;
	@Min(0)
	private int aantalDranken;
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	private User eigenaar;
	
	public Jeugdhuis(long id, String name, int aantalDranken, User eigenaar) {
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
	
	public Jeugdhuis(String name, int aantalDranken, User eigenaar) {
		this.name = name;
		this.aantalDranken = aantalDranken;
		this.eigenaar = eigenaar;
	}

	public Jeugdhuis(String name, int aantalDranken) {
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

	public User getEigenaar() {
		return eigenaar;
	}

	public void setEigenaar(User eigenaar) {
		this.eigenaar = eigenaar;
	}
	
	public void setAantalDranken(Integer aantalDranken) {
		this.aantalDranken = aantalDranken;
	}

	public void incrementAantalDranken(Integer aantal){
		this.aantalDranken += aantal;
	}

	public void setId(long id) {
		this.id=id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jeugdhuis other = (Jeugdhuis) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
		
}

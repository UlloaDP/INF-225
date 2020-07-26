package com.MicroSillones.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sillones{
	
	//Attributes
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long ides;
	
	private boolean disponibilidad;
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id", referencedColumnName = "id", nullable=false)
	private Sala sala;
	
	//constructor
	public Sillones() {}
	
	public long getId() {
		return ides;
	}
	
	public boolean getDisponibilidad() {
		return disponibilidad;
	}
	
	public Sala getSala() {
		return sala;
	}
	
	
	public void setDisponibilidad(boolean dispo) {
		this.disponibilidad=dispo;
	}
	
	public void setSala(com.MicroSillones.model.Sala sal) {
		this.sala=sal;
	}
}

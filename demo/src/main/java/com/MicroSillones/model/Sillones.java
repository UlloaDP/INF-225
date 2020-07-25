package com.MicroSillones.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
public class Sillones {
	
	//Atributos
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	private boolean disponibilidad;
    @ManyToOne
	@JoinColumn(name="id", nullable=false)
	private Sala Sala;
	
	//constructor
	public Sillones() {}
	
	public long getId() {
		return id;
	}
	
	public boolean getDisponibilidad() {
		return disponibilidad;
	}
	
	public Sala getSala() {
		return Sala;
	}
	
	
	public void setDisponibilidad(boolean dispo) {
		this.disponibilidad=dispo;
	}
	
	public void setSala(com.MicroSillones.model.Sala sal) {
		this.Sala=sal;
	}
}

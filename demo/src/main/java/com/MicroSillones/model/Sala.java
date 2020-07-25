package com.MicroSillones.model;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sala {
	//Atributos
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private int capacidad;
	private boolean disponibilidad;
	
	@OneToMany(mappedBy="Sala")
    private Set<Sillones> Sillones;
	
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
	
}

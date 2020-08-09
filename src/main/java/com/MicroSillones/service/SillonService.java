package com.MicroSillones.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MicroSillones.repository.*;
import com.MicroSillones.model.*;

@Service
public class SillonService {

	
	@Autowired
	private SillonRepository sillonRepository;
	
	@Autowired 
	private SalaRepository salaRepository;
	
	//Agregar Sillon
	public String saveSillon(boolean dispo,int id) {
		
		Sala sala = this.salaRepository.findById((long)id).orElse(null); 
		
		Sillones new_sillon = new Sillones();
		new_sillon.setDisponibilidad(dispo);
		new_sillon.setSala(sala);
		this.sillonRepository.save(new_sillon);
		
		return "Sillón añadido a la sala " + id ;
	}
	
	//Obtener todos los sillones
	public List<Sillones> getAll(){
		return (List<Sillones>) this.sillonRepository.findAll();
	}
	
	//Obtener Sillon por Id
	public Sillones getSillonById(long id) {
		Sillones sillon = this.sillonRepository.findById(id).orElse(null);
		
		if(sillon==null) {
			System.out.println("Sillon " +id+ " no encontrado" );
			return null;
		}
		
		return sillon;
	}
	
	//Actualizar disponibilidad del Sillon
	public String updateSillon(long id,boolean new_dispo) {
		Sillones sillonData = this.sillonRepository.findById(id).orElse(null);
		
		if(sillonData==null) return "ERROR: sillon no encontrado";
				
		boolean prev_dispo = sillonData.getDisponibilidad();
		sillonData.setDisponibilidad(new_dispo);
		this.sillonRepository.save(sillonData);
		
		return "Sillon actualizado: " + id + "\nEstado: " + prev_dispo + " --> " + new_dispo;
	}
	
	//Buscar por Dispo
	public List<Sillones> searchByDisponibilidad(boolean dispo){
		return this.sillonRepository.searchSillonByDisponibilidad(dispo);
	}
	
	//Elimina Sillon por Id
	public String deleteById(long id) {

		this.sillonRepository.deleteById(id);
		
		return "Sillon with ID: "+id+" has been deleted";
	}
}

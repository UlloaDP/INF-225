package com.MicroSillones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.MicroSillones.model.Sala;
import com.MicroSillones.repository.SalaRepository;

@Service
public class SalaService {

	
	@Autowired
	private SalaRepository salaRepository;
	
	//Añade 1 o mas salas
	public String addSala(List<Sala> salas) {
		this.salaRepository.saveAll(salas);
		return "Salas guardados: " + salas.size();
	}
	
	//Obtiene todas las Salas
	public List<Sala> getAll(){
		return (List<Sala>) this.salaRepository.findAll();
	}
	
	//Obtiene sala por id
	public Sala getById(long id) {
		Sala sala = this.salaRepository.findById(id).orElse(null);
		
		if(sala==null) {
			System.out.println("No se ha encontrado la sala solicitada");
			return null;
		}
		return sala;
	}
	
	//Actualiza la Disponibilidad de la Sala
	public String updateSala(long id, boolean new_dispo) {
		Sala salaData = this.salaRepository.findById(id).orElse(null);
		if(salaData == null) return "ERROR: Sala no encontrada";
		boolean prev_dispo = salaData.isDisponibilidad();
		salaData.setDisponibilidad(new_dispo);
		this.salaRepository.save(salaData);
		return "Sala actualizada: " + id + "\nEstado: " + prev_dispo + " --> " + new_dispo;
	}
	
	//Busca por Disponibilidad
	public List<Sala> searchByDisponibilidad(boolean dispo){
		return this.salaRepository.searchSalaByDisponibilidad(dispo);
	}
	
	//Elimina Sala por Id
	public String deleteSala(long id) {
		 
	    this.salaRepository.deleteById(id);
	 
	    return "Sala with ID: "+ id + " has been deleted!";
	}
}

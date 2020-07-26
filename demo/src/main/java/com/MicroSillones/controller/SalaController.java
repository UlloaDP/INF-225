package com.MicroSillones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MicroSillones.model.Sala;
import com.MicroSillones.repository.SalaRepository;

@RestController
@RequestMapping("/sala")
public class SalaController {
	@Autowired
	private SalaRepository salaRepository;
	
	//Add Salas
	@PostMapping("/add")
	public String addSala(@RequestBody List<Sala> salas) {
		salaRepository.saveAll(salas);
		return "Salas guardados: " + salas.size();
	}
	
	//Get Salas
	@GetMapping("/all")
	public List<Sala> getAllSala(){
		return (List<Sala>) this.salaRepository.findAll();
	}
	
	//Get Sala by Id
	@GetMapping("/get/{id}")
	public Sala getSalaById(@PathVariable("id" )long id) {
		
		Sala sala = (Sala) salaRepository.findById(id).orElse(null);
		
		if(sala==null) {
			System.out.println("No se ha encontrado la sala solicitada");
			return null;
		}
		return sala;
	}
	
	//Update Sala(Solo para disponibilidad)
	@PutMapping("/update/{id}")
	public String updateSala(@PathVariable("id")long id,@RequestBody boolean new_dispo ) {
		
		Sala salaData = salaRepository.findById(id).orElse(null);
		
		if(salaData == null) return "ERROR: Sala no encontrada";
		
		boolean prev_dispo = salaData.isDisponibilidad();
		salaData.setDisponibilidad(new_dispo);
		salaRepository.save(salaData);
		
		return "Sala actualizada: " + id + "\nEstado: " + prev_dispo + " --> " + new_dispo;
	}
	//Search by Disponibilidad
	@GetMapping("/status/{disponibilidad}")
	public List<Sala> searchSalaByDisponibilidad(@PathVariable("disponibilidad") boolean disponibilidad){
		return salaRepository.searchSalaByDisponibilidad(disponibilidad);
	};
	
	
	//Delete Sala
	@DeleteMapping("/delete/{id}")
	public String deleteSala(@PathVariable("id") long id) {
		System.out.println("Delete Sala with ID = " + id + "...");
	 
	    salaRepository.deleteById(id);
	 
	    return "Sala with ID: "+ id + " has been deleted!";
	}
}

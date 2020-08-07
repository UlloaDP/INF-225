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
import com.MicroSillones.service.SalaService;

@RestController
@RequestMapping("/sala")
public class SalaController {
	@Autowired
	private SalaService salaService;
	
	//Add Salas
	@PostMapping("/add")
	public String addSala(@RequestBody List<Sala> salas) {
		return this.salaService.addSala(salas);
	}
	
	//Get Salas
	@GetMapping("/all")
	public List<Sala> getAllSala(){
		return this.salaService.getAll();
	}
	
	//Get Sala by Id
	@GetMapping("/get/{id}")
	public Sala getSalaById(@PathVariable("id") long id) {
		return this.salaService.getById(id);		
	}
	
	//Update Sala(Solo para disponibilidad)
	@PutMapping("/update/{id}")
	public String updateSala(@PathVariable("id")long id,@RequestBody boolean new_dispo ) {
		return this.salaService.updateSala(id, new_dispo);		
	}
	//Search by Disponibilidad
	@GetMapping("/status/{disponibilidad}")
	public List<Sala> searchSalaByDisponibilidad(@PathVariable("disponibilidad") boolean disponibilidad){
		return this.salaService.searchByDisponibilidad(disponibilidad);
	};
	//Delete Sala
	@DeleteMapping("/delete/{id}")
	public String deleteSala(@PathVariable("id") long id) {
		return this.salaService.deleteSala(id);
	}
}

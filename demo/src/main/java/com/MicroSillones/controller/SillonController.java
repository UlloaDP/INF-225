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

import com.MicroSillones.repository.SillonRepository;
import com.MicroSillones.model.Sillones;

@RestController
@RequestMapping("/sillon")
public class SillonController {
	
	
	@Autowired
	private SillonRepository sillonRepository;
	
	//Add Sillones
	@PostMapping("/add")
	public String addSillon(@RequestBody List<Sillones> sillones) {
		sillonRepository.saveAll(sillones);
		return "Sillones guardados: " + sillones.size();
	}
	
	//Get Sillones
	@GetMapping("/all")
	public List<Sillones> getAllSillon(){
		return (List<Sillones>) this.sillonRepository.findAll();
	}
	
	//Get Sillon by Id
	@GetMapping("/get/{id}")
	public Sillones getSalaById(@PathVariable("id") long id) {
		Sillones sillon = (Sillones) sillonRepository.findById(id).orElse(null);
		
		if(sillon==null) {
			System.out.println("Sillon " +id+ " no encontrado" );
			return null;
		}
		
		return sillon;
	}
	//Update Sillon
	@PutMapping("/update/{id}")
	public String updateSillon(@PathVariable("id") long id, @RequestBody boolean new_dispo) {
		Sillones sillonData = sillonRepository.findById(id).orElse(null);
		
		if(sillonData==null) return "ERROR: sillon no encontrado";
				
		boolean prev_dispo = sillonData.getDisponibilidad();
		sillonData.setDisponibilidad(new_dispo);
		sillonRepository.save(sillonData);
		
		return "Sillon actualizado: " + id + "\nEstado: " + prev_dispo + " --> " + new_dispo;
	}
	
	//Search by disponibilidad
	@GetMapping("/status/{dispo}")
	public List<Sillones> searchSillonByDisponibilidad(@PathVariable("dispo") boolean dispo){
		return sillonRepository.searchSillonByDisponibilidad(dispo);
	}
	
	//Delete Sillon
	@DeleteMapping("delete/{id}")
	public String deleteSillon(@PathVariable("id") long id) {
		
		sillonRepository.deleteById(id);
		
		return "Sillon with ID: "+id+" has been deleted";
	}
}

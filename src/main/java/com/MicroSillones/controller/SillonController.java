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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MicroSillones.model.Sillones;
import com.MicroSillones.service.SillonService;

@RestController
@RequestMapping("/sillon")
public class SillonController {
	
	
	@Autowired
	private SillonService sillonService;
	
	//Add Sillones
	@PostMapping("/add")
	public String addSillon(@RequestParam(name = "disponibilidad") boolean dispo , @RequestParam(name = "id") int sala) {
		return this.sillonService.saveSillon(dispo, sala);
	}
	
	//Get Sillones
	@GetMapping("/all")
	public List<Sillones> getAllSillon(){
		return this.sillonService.getAll();
	}
	
	//Get Sillon by Id
	@GetMapping("/get/{id}")
	public Sillones getSillonById(@PathVariable("id") long id) {
		return this.sillonService.getSillonById(id);
	}
	//Update Sillon
	@PutMapping("/update/{id}")
	public String updateSillon(@PathVariable("id") long id, @RequestBody boolean new_dispo) {
		return this.sillonService.updateSillon(id, new_dispo);
	}
	
	//Search by disponibilidad
	@GetMapping("/status/{dispo}")
	public List<Sillones> searchSillonByDisponibilidad(@PathVariable("dispo") boolean dispo){
		return this.sillonService.searchByDisponibilidad(dispo);
	}
	
	//Delete Sillon
	@DeleteMapping("delete/{id}")
	public String deleteSillon(@PathVariable("id") long id) {
		return this.sillonService.deleteById(id);
	}
}

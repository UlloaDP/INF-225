package com.MicroSillones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	//Update Sala
	//Delete Sala
}

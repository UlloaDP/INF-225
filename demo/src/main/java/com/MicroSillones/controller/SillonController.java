package com.MicroSillones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	//Update Sillon
	//Delete Sillon
}

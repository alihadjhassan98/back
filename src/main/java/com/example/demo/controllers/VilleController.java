package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LocaleRepository;
import com.example.demo.dao.VilleRepository;
import com.example.demo.entities.Ville;

@CrossOrigin("*") 
@RestController
@RequestMapping("Villes")
public class VilleController {
	@Autowired
	private VilleRepository V;
	@Autowired
	private LocaleRepository L;
	@GetMapping
	public List<Ville> getAllVilles(){
	return V.findAll();
	}
	@PostMapping
	public Ville add(@RequestBody Ville villes) {
		return V.save(villes);
	} 
	@GetMapping("/{Id}")
	public Ville getVillesById(@PathVariable Long Id) { 
		Optional<Ville> ville=V.findById(Id);
		return ville.isPresent() ? ville.get() : null;
			 
	}
	
}
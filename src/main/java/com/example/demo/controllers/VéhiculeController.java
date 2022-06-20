package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dao.VéhiculeRepository;
import com.example.demo.entities.Véhicule;
@CrossOrigin("*")
@RestController
@RequestMapping(value="/vehicules")
public class VéhiculeController {
	
	@Autowired
	protected VéhiculeRepository VH;
	
	
	
	@PostMapping("")
	public Véhicule ajouterV(@RequestBody Véhicule v)
	{
		return VH.save(v);
	}
	@GetMapping("/{id}")
	public Optional<Véhicule> getVehiculeById(@PathVariable Long id) { 
		return VH.findById(id);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteH(@PathVariable Long id) { 
		VH.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Véhicule updateH(@PathVariable Long id ,@RequestBody Véhicule vehicule) { 
		return VH.save(vehicule);
	}
	
	@GetMapping("")
	public List<Véhicule> afficherToutC()
	{
		return VH.findAll();
	}

	
}
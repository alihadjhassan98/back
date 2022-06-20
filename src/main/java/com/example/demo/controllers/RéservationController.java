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


import com.example.demo.dao.RéservationRepository;

import com.example.demo.entities.Réservation;

@CrossOrigin("*") 
@RestController
@RequestMapping(value="/Reservations")
public class RéservationController {
	@Autowired
	protected RéservationRepository RR;
	@PostMapping
	public Réservation ajouterR(@RequestBody Réservation r)
	{
		return RR.save(r);
	}
	@GetMapping
	public List<Réservation> afficherToutR()
	{
		return RR.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Réservation> getRéservationById(@PathVariable Long id) { 
		return RR.findById(id);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) { 
		RR.deleteById(id);
	}
	@PutMapping("/{id}")
	public Réservation update(@PathVariable Long id ,@RequestBody Réservation réservation) { 
		return RR.save(réservation);
	}
	
	@GetMapping("/resnumb")
	public Long numberOfreservations(){
        return RR.count();
      
    }

}
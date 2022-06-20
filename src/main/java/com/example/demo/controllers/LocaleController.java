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


import com.example.demo.dao.LocaleRepository;
import com.example.demo.dao.VilleRepository;
import com.example.demo.entities.Locale;

@CrossOrigin("*") 
@RestController
@RequestMapping()
public class LocaleController {
	
	
	

	@Autowired
	private LocaleRepository L;
	@Autowired
	private VilleRepository V;
	
	
	
	@GetMapping("/Locales")
	public List<Locale> getAllLocales(){
	return L.findAll();
	}
	@PostMapping("/Locales")
	public Locale add(@RequestBody Locale Locales) {
		return L.save(Locales);
	} 
	@GetMapping("/Locales/{Id}")
	public Locale getLocaleById(@PathVariable Long Id) { 
		Optional<Locale> Locale=L.findById(Id);
		return Locale.isPresent() ? Locale.get() : null;
			 
	}
	
	
	
	@GetMapping("/Locales/localenumb")
	public Long numberOfLocales(){
        return L.count();
      
    }
}
	

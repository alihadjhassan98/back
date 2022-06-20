package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SeanceRepository;
import com.example.demo.entities.Seance;

@CrossOrigin("*") 
@RestController
@RequestMapping()
public class SeanceController {
	@Autowired
	private SeanceRepository S;
	@GetMapping("/Seances")
	//public List<Seance> getAllSeances(Long idLocal){
	//return S.findByLocaleId(idLocal);
	//}
	public List<Seance> getAllSeances(){
		return S.findAll();
		}
	@PostMapping("/Seances")
	public Seance add(@RequestBody Seance Seances) {
		return S.save(Seances);
	} 
	@GetMapping("/Seances/{Id}")
	public Seance getSeanceById(@PathVariable Long Id) { 
		Optional<Seance> Seance=S.findById(Id);
		return Seance.isPresent() ? Seance.get() : null;
	}
		@DeleteMapping("/Seances/{id}")
		public void delete (@PathVariable Long id ) {
			S.deleteById(id);
		}

}

package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LocaleRepository;
import com.example.demo.dao.RéservationRepository;
import com.example.demo.dao.TicketRepository;
import com.example.demo.entities.Ticket;

@RestController
@RequestMapping(value="/ticket")
public class TicketController {
	@Autowired
	protected TicketRepository TK;
	@PostMapping("/AddT")
	public Ticket ajouterR(@RequestBody Ticket t)
	{
		return TK.save(t);
	}
	@GetMapping("/GetAllT")
	public List<Ticket> afficherToutT()
	{
		return TK.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Ticket> getLocaleById(@PathVariable Long id) { 
		return TK.findById(id);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) { 
		TK.deleteById(id);
	}
	@PutMapping("/{id}")
	public Ticket update(@PathVariable Long id ,@RequestBody Ticket ticket) { 
		return TK.save(ticket);
	}
}

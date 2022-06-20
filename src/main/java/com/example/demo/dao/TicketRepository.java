package com.example.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Réservation;
import com.example.demo.entities.Ticket;

	
@RepositoryRestResource
public interface TicketRepository extends JpaRepository <Ticket, Long> {
	List<Ticket> findByRéservation(Long id);

}

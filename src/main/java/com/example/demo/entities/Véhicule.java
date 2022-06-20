package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@RequiredArgsConstructor

public class Véhicule {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_vehicule;
	@NonNull
	private String numCarteGrise;
	private String typeImmatriculation;
	private String immatriculation;
	private String marque;
	private String modele;
	
	@ManyToOne
	@JoinColumn(name="code_client")
	private Client client;

	//@OneToMany(mappedBy="véhicule",
			//fetch=FetchType.LAZY, cascade=CascadeType.ALL)
			//private Collection<Réservation> réservations;
	

	
	
}
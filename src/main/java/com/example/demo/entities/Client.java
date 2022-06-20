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
public class Client{ 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String cin;
	private String photo;
	private String permis;
	private String numtel;
	@NonNull
	private String username;
	private String firstname;
	private String lastname;
	@NonNull
	private String password;
	private String email;
	
	@OneToMany(mappedBy="client",
			fetch=FetchType.LAZY, cascade=CascadeType.ALL)
			private Collection<Véhicule>véhicules;
	
	//@OneToMany(mappedBy="client",
			//fetch=FetchType.LAZY, cascade=CascadeType.ALL)
			//private Collection<Réservation>réservations;
	
	//@ManyToOne
	//@JoinColumn(name="codeLocale")
	//private Locale locale;

}

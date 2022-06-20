//Elaborée par Hela Cherni

package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@NoArgsConstructor

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Locale.class)
public class Locale {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;	
	@Column
	private String nom ;
	@Column
	private String adresse;
	@Column
	private String telephone;
	@Column
	private String nbguichet;
	@ManyToOne
	@JoinColumn(name="ville_id", nullable = false)
    private Ville ville;
	public Locale(String nom, String adresse, String telephone, String nbguichet, Ville ville) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.nbguichet = nbguichet;
		this.ville = ville;
	}
	
	
}

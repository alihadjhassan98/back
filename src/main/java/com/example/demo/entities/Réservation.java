

package com.example.demo.entities;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@NoArgsConstructor

@Data
@Entity
public class Réservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//	@Temporal(TemporalType.DATE)
	 private LocalDate dateReservation;
	@ManyToOne
	@JoinColumn
    private Seance seance;
	@ManyToOne
	@JoinColumn
    private Client client ;
	  @ManyToOne
		@JoinColumn
	    private Locale locale;
	
	public Réservation( LocalDate dateReservation, Seance seance, Client client, Locale locale) {
		super();
		
		this.dateReservation = dateReservation;
		this.seance = seance;
		this.client = client;
		this.locale = locale;
	}
	

}

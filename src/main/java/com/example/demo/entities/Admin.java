//Elaborée par Hela Cherni

package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.NonNull;


@Entity
public class Admin{ 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code_admin;
	@NonNull
	private String username;
	private String firstname;
	private String lastname;
	@NonNull
	private String password;
	private String email;
	
	
		
	}
	
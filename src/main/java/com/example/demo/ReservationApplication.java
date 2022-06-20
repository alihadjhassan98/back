package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;
import com.example.demo.controllers.ClientController;

@SpringBootApplication
public class ReservationApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ReservationApplication.class, args);
	}

}

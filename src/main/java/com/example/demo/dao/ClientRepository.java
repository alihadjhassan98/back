package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Client;
@Repository
public interface ClientRepository extends JpaRepository <Client, Long>  {
	Client findByUsernameAndPassword(String username,String password);
	//Optional<Client> findByCode_Client(Long id);

}

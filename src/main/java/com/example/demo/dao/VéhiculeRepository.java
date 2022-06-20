//Elaborée par Hela Cherni

package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Véhicule;

@RepositoryRestResource
public interface VéhiculeRepository extends JpaRepository <Véhicule, Long> {

}
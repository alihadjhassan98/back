//Elaborée par Hela Cherni

package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.example.demo.entities.Locale;

@RepositoryRestResource
public interface LocaleRepository extends JpaRepository <Locale, Long> {

}
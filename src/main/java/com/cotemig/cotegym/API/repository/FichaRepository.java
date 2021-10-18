package com.cotemig.cotegym.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cotemig.cotegym.API.model.Ficha;



@Repository("fichaRepository")
public interface FichaRepository extends JpaRepository<Ficha, Integer> {

}

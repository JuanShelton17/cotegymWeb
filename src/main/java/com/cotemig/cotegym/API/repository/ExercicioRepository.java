package com.cotemig.cotegym.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cotemig.cotegym.API.model.Exercicio;


@Repository("exercicioRepository")
public interface ExercicioRepository extends JpaRepository<Exercicio, Integer> {

}

package com.cotemig.cotegym.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cotemig.cotegym.API.model.Professor;



@Repository("professorRepository")
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}

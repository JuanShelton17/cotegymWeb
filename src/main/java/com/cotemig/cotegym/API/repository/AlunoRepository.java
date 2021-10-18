package com.cotemig.cotegym.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cotemig.cotegym.API.model.Aluno;


@Repository("alunoRepository")
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}

package com.cotemig.cotegym.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cotemig.cotegym.API.model.Modalidade;


@Repository("modalidadeRepository")
public interface ModalidadeRepository extends JpaRepository<Modalidade, Integer> {

}

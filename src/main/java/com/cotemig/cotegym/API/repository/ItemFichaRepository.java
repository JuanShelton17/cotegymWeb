package com.cotemig.cotegym.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cotemig.cotegym.API.model.ItemFicha;



@Repository("itemFichaRepository")
public interface ItemFichaRepository extends JpaRepository<ItemFicha, Integer> {

}

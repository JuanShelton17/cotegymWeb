package com.cotemig.cotegym.API.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.cotegym.API.model.Ficha;


public interface FichaService {

	Optional<Ficha> getFichaById(Integer id);
	List<Ficha> getAllFichas();
	void deleteAllFichas();
	void deleteFichaById(Integer id);
	void updateFichaById(Integer id, Ficha ficha);
	void updateFicha(Ficha ficha);
	void insertFicha(Ficha ficha);
}

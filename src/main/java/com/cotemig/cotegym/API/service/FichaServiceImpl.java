package com.cotemig.cotegym.API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.cotegym.API.model.Ficha;
import com.cotemig.cotegym.API.repository.FichaRepository;


@Service("FichaService")
public class FichaServiceImpl implements FichaService{

	@Autowired
	FichaRepository repository;
	
	@Override
	public Optional<Ficha> getFichaById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<Ficha> getAllFichas() {
		return repository.findAll();
	}

	@Override
	public void deleteAllFichas() {
		repository.deleteAll();
	}

	@Override
	public void deleteFichaById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void updateFichaById(Integer id, Ficha ficha) {

		 Optional<Ficha> getFicha = getFichaById(id);
		 getFicha.get().setTipoFicha(ficha.getTipoFicha());
		 getFicha.get().setFichaLetra(ficha.getFichaLetra());
		 getFicha.get().setTipoFicha(ficha.getTipoFicha());
		 
		 repository.save(getFicha.get());
	}

	@Override
	public void updateFicha(Ficha ficha) {
		repository.save(ficha);
	}

	@Override
	public void insertFicha(Ficha ficha) {
		repository.save(ficha);
	}
}

package com.cotemig.cotegym.API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.cotegym.API.model.Exercicio;
import com.cotemig.cotegym.API.repository.ExercicioRepository;


@Service("ExercicioService")
public class ExercicioServiceImpl implements ExercicioService{
	
	@Autowired
	ExercicioRepository repository;
	
	@Override
	public Optional<Exercicio> getExercicioById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<Exercicio> getAllExercicios() {
		return repository.findAll();
	}

	@Override
	public void deleteAllExercicios() {
		repository.deleteAll();
	}

	@Override
	public void deleteExercicioById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void updateExercicioById(Integer id, Exercicio exercicio) {
		 Optional<Exercicio> getExercicio = getExercicioById(id);
		 getExercicio.get().setNome(exercicio.getNome());
		 repository.save(getExercicio.get());
		
	}

	@Override
	public void updateExercicio(Exercicio exercicio) {
		repository.save(exercicio);
	}

	@Override
	public void insertExercicio(Exercicio exercicio) {
		repository.save(exercicio);
	}

}

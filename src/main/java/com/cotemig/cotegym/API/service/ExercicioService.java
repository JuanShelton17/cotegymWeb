package com.cotemig.cotegym.API.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.cotegym.API.model.Exercicio;


public interface ExercicioService {

	Optional<Exercicio> getExercicioById(Integer id);

	List<Exercicio> getAllExercicios();

	void deleteAllExercicios();

	void deleteExercicioById(Integer id);

	void updateExercicioById(Integer id, Exercicio exercicio);

	void updateExercicio(Exercicio exercicio);

	void insertExercicio(Exercicio exercicio);
}

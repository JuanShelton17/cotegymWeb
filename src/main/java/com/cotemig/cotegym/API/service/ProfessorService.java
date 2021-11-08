package com.cotemig.cotegym.API.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.cotegym.API.model.Professor;

public interface ProfessorService {

	Optional<Professor> getProfessorById(Integer id);
	List<Professor> getAllProfessores();
	void deleteAllProfessores();
	void deleteProfessorById(Integer id);
	void updateProfessorById(Integer id, Professor professor);
	void updateProfessor(Professor professor);
	void insertProfessor(Professor professor);
}

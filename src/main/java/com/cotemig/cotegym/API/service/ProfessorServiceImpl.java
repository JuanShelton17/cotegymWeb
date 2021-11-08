package com.cotemig.cotegym.API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.cotegym.API.model.Professor;
import com.cotemig.cotegym.API.repository.ProfessorRepository;

@Service("professorService")
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	ProfessorRepository repository;

	@Override
	public Optional<Professor> getProfessorById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<Professor> getAllProfessores() {
		return repository.findAll();
	}

	@Override
	public void deleteAllProfessores() {
		repository.deleteAll();
	}

	@Override
	public void deleteProfessorById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void updateProfessorById(Integer id, Professor professor) {

		Optional<Professor> getProfessor = getProfessorById(id);
		getProfessor.get().setCpf(professor.getCpf());
		getProfessor.get().setIdade(professor.getIdade());
		getProfessor.get().setModalidade_id(professor.getModalidade_id());
		getProfessor.get().setNome(professor.getNome());

		repository.save(getProfessor.get());

	}

	@Override
	public void updateProfessor(Professor professor) {
		repository.save(professor);
	}

	@Override
	public void insertProfessor(Professor professor) {
		repository.save(professor);
	}
}

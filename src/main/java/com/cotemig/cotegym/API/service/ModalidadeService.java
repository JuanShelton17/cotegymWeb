package com.cotemig.cotegym.API.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.cotegym.API.model.Modalidade;

public interface ModalidadeService {
	
	Optional<Modalidade> getModalidadeById(Integer id);
	List<Modalidade> getAllModalidades();
	void deleteAllModalidades();
	void deleteModalidadeById(Integer id);
	void updateModalidadeById(Integer id, Modalidade modalidade);
	void updateModalidade(Modalidade modalidade);
	void insertModalidade(Modalidade modalidade);
}

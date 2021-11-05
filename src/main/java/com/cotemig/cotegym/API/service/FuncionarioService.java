package com.cotemig.cotegym.API.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.cotegym.API.model.Funcionario;


public interface FuncionarioService {

	Optional<Funcionario> getFuncionarioById(Integer id);
	List<Funcionario> getAllFuncionarios();
	void deleteAllFuncionarios();
	void deleteFuncionarioById(Integer id);
	void updateFuncionarioById(Integer id, Funcionario funcionario);
	void updateFuncionario(Funcionario funcionario);
	void insertFuncionario(Funcionario funcionario);
}

package com.cotemig.cotegym.API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.cotegym.API.model.Funcionario;
import com.cotemig.cotegym.API.repository.FuncionarioRepository;


@Service("FuncionarioService")
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	FuncionarioRepository repository;
	
	@Override
	public Optional<Funcionario> getFuncionarioById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<Funcionario> getAllFuncionarios() {
		return repository.findAll();
	}

	@Override
	public void deleteAllFuncionarios() {
		repository.deleteAll();
	}

	@Override
	public void deleteFuncionarioById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void updateFuncionarioById(Integer id, Funcionario funcionario) {

		 Optional<Funcionario> getFuncionario = getFuncionarioById(id);
		 
		 getFuncionario.get().setNome(funcionario.getNome());
		 getFuncionario.get().setCpf(funcionario.getCpf());
		 getFuncionario.get().setIdade(funcionario.getIdade());
		 
		 repository.save(getFuncionario.get());
	}

	@Override
	public void updateFuncionario(Funcionario funcionario) {
		repository.save(funcionario);
	}

	@Override
	public void insertFuncionario(Funcionario funcionario) {
		repository.save(funcionario);
	}
}

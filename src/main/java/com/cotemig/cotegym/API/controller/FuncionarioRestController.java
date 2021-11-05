package com.cotemig.cotegym.API.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cotemig.cotegym.API.model.Funcionario;
import com.cotemig.cotegym.API.service.FuncionarioService;

@RestController
public class FuncionarioRestController {

	@Autowired
	FuncionarioService funcionarioService;
	
	@RequestMapping(value = "funcionario/rest/getAll", method = RequestMethod.GET)
	public List<Funcionario> getFuncionarios() {
		return funcionarioService.getAllFuncionarios();
	}

	@RequestMapping(value = "funcionario/rest/get/{id}", method = RequestMethod.GET)
	public Optional<Funcionario> getFuncionario(@PathVariable("id") Integer id) {
		return funcionarioService.getFuncionarioById(id);
	}

	@RequestMapping(value = "funcionario/rest/deleteAll", method = RequestMethod.DELETE)
	public void deleteFuncionarios() {
		funcionarioService.deleteAllFuncionarios();
	}

	@RequestMapping(value = "funcionario/rest/delete/{id}", method = RequestMethod.DELETE)
	public void deleteFuncionario(@PathVariable("id") Integer id) {
		funcionarioService.deleteFuncionarioById(id);
	}

	@RequestMapping(value = "funcionario/rest/update/{id}", method = RequestMethod.POST)
	public void updateFuncionario(@RequestBody Funcionario funcionario, @PathVariable("id") Integer id) {
		funcionarioService.updateFuncionarioById(id, funcionario);
	}

	@RequestMapping(value = "funcionario/rest/insert", method = RequestMethod.POST)
	public void updateFuncionario(@RequestBody Funcionario aluno) {
		funcionarioService.insertFuncionario(aluno);
	}
}

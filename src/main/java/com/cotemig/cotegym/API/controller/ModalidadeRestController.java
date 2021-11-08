package com.cotemig.cotegym.API.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cotemig.cotegym.API.model.Modalidade;
import com.cotemig.cotegym.API.service.ModalidadeService;

@RestController
public class ModalidadeRestController {

	@Autowired
	private ModalidadeService modalidadeService;

	@RequestMapping(value = "modalidade/rest/getAll", method = RequestMethod.GET)
	public List<Modalidade> getmodalidadees() {
		return modalidadeService.getAllModalidades();
	}

	@RequestMapping(value = "modalidade/rest/get/{id}", method = RequestMethod.GET)
	public Optional<Modalidade> getmodalidade(@PathVariable("id") Integer id) {
		return modalidadeService.getModalidadeById(id);
	}

	@RequestMapping(value = "modalidade/rest/deleteAll", method = RequestMethod.DELETE)
	public void deleteModalidadees() {
		modalidadeService.deleteAllModalidades();
	}

	@RequestMapping(value = "modalidade/rest/delete/{id}", method = RequestMethod.DELETE)
	public void deleteModalidade(@PathVariable("id") Integer id) {
		modalidadeService.deleteModalidadeById(id);
	}

	@RequestMapping(value = "modalidade/rest/update/{id}", method = RequestMethod.POST)
	public void updateModalidade(@RequestBody Modalidade modalidade, @PathVariable("id") Integer id) {
		modalidadeService.updateModalidadeById(id, modalidade);
	}

	@RequestMapping(value = "modalidade/rest/insert", method = RequestMethod.POST)
	public void updateModalidade(@RequestBody Modalidade modalidade) {
		modalidadeService.insertModalidade(modalidade);
	}
}

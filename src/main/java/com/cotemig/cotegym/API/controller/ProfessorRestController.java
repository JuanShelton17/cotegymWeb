package com.cotemig.cotegym.API.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cotemig.cotegym.API.model.Professor;
import com.cotemig.cotegym.API.service.ProfessorService;

@RestController
public class ProfessorRestController {
	
	@Autowired
	private ProfessorService professorService;

	@RequestMapping(value = "professor/rest/getAll", method = RequestMethod.GET)
	public List<Professor> getProfessores() {
		return professorService.getAllProfessores();
	}

	@RequestMapping(value = "professor/rest/get/{id}", method = RequestMethod.GET)
	public Optional<Professor> getProfessor(@PathVariable("id") Integer id) {
		return professorService.getProfessorById(id);
	}

	@RequestMapping(value = "professor/rest/deleteAll", method = RequestMethod.DELETE)
	public void deleteProfessores() {
		professorService.deleteAllProfessores();
	}

	@RequestMapping(value = "professor/rest/delete/{id}", method = RequestMethod.DELETE)
	public void deleteProfessor(@PathVariable("id") Integer id) {
		professorService.deleteProfessorById(id);
	}

	@RequestMapping(value = "professor/rest/update/{id}", method = RequestMethod.POST)
	public void updateProfessor(@RequestBody Professor professor, @PathVariable("id") Integer id) {
		professorService.updateProfessorById(id, professor);
	}

	@RequestMapping(value = "professor/rest/insert", method = RequestMethod.POST)
	public void updateProfessor(@RequestBody Professor professor) {
		professorService.insertProfessor(professor);
	}
}

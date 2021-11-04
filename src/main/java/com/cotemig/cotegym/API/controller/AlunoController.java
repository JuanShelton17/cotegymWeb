package com.cotemig.cotegym.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.cotegym.API.model.Aluno;
import com.cotemig.cotegym.API.service.AlunoServiceImpl;

@Controller
public class AlunoController {
	
	@Autowired
	AlunoServiceImpl alunoService;

	// Aluno
	@RequestMapping(value = "/insertAluno", method = RequestMethod.GET)
	public ModelAndView insertAluno() {

		return new ModelAndView("insertAluno", "aluno", new Aluno());

	}

	@RequestMapping(value = "/insertAluno", method = RequestMethod.POST)
	public String submitInsertAluno(@Validated @ModelAttribute("aluno") Aluno aluno, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		alunoService.insertAluno(aluno);

		return "redirect:/readAlunos";
	}

}

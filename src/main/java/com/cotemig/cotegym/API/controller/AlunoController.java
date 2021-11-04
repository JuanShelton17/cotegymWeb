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
	
	@RequestMapping(value = "/deleteAluno", method = RequestMethod.GET)
	public ModelAndView deleteAluno(Integer id) {

		return new ModelAndView("deleteAluno", "aluno", alunoService.getAlunoById(id).get());
	}

	@RequestMapping(value = "/deleteAluno", method = RequestMethod.POST)
	public String submitDeleteAluno(@Validated @ModelAttribute("aluno") Aluno aluno, BindingResult result, ModelMap model)
	{

		if (result.hasErrors()) {
			return "error";
		}

		alunoService.deleteAlunoById(aluno.getId());

		return "redirect:/readAlunos";

	}

	@RequestMapping(value = "/updateAluno", method = RequestMethod.GET)
	public ModelAndView updateAluno(Integer id) {

		return new ModelAndView("updateAluno", "aluno", alunoService.getAlunoById(id).get());

	}

	@RequestMapping(value = "/updateAluno", method = RequestMethod.POST)
	public String submitUpdateAluno(@Validated @ModelAttribute("aluno") Aluno aluno, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		alunoService.updateAluno(aluno);

		return "redirect:/readAlunos";
	}

	@RequestMapping(value = "/readAlunos", method = RequestMethod.GET)
	public ModelAndView readAlunos() {

		ModelAndView mav = new ModelAndView("readAlunos");
		mav.addObject("alunos", alunoService.getAllAlunos());
		return mav;
	}

	@RequestMapping(value = "/readAluno", method = RequestMethod.GET)
	public ModelAndView readAluno(Integer id) {

		ModelAndView mav = new ModelAndView("readAluno");
		mav.addObject("alunos", alunoService.getAlunoById(id));
		return mav;
	}

}

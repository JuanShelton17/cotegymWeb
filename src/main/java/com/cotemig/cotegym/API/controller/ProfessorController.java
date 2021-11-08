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

import com.cotemig.cotegym.API.model.Professor;
import com.cotemig.cotegym.API.service.ModalidadeServiceImpl;
import com.cotemig.cotegym.API.service.ProfessorServiceImpl;

@Controller
public class ProfessorController {
	
	@Autowired
	ProfessorServiceImpl professorService;
	
	@Autowired
	ModalidadeServiceImpl modalidadeService;

	@RequestMapping(value = "/insertProfessor", method = RequestMethod.GET)
	public ModelAndView insertProfessor() {

		ModelAndView mav = new ModelAndView("insertProfessor");

		mav.addObject("professor", new Professor());
		mav.addObject("modalidades", modalidadeService.getAllModalidades());

		return mav;

	}

	@RequestMapping(value = "/insertProfessor", method = RequestMethod.POST)
	public String submitInsertProfessor(@Validated @ModelAttribute("professor") Professor professor, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		professorService.insertProfessor(professor);

		return "redirect:/readProfessores";
	}

	@RequestMapping(value = "/deleteProfessor", method = RequestMethod.GET)
	public ModelAndView deleteProfessor(Integer id) {

		ModelAndView mav = new ModelAndView("deleteProfessor");

		Professor professor = professorService.getProfessorById(id).get();

		mav.addObject("professor", professor);
		mav.addObject("modalidades", modalidadeService.getAllModalidades());

		// mav.addObject("modalidade",
		// modalidadeService.getModalidadeById(professor.getModalidade_id()));

		return mav;
	}

	@RequestMapping(value = "/deleteProfessor", method = RequestMethod.POST)
	public String submitDeleteProfessor(@Validated @ModelAttribute("professor") Professor professor, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		professorService.deleteProfessorById(professor.getId());

		return "redirect:/readProfessores";
	}

	@RequestMapping(value = "/updateProfessor", method = RequestMethod.GET)
	public ModelAndView updateProfessor(Integer id) {

		ModelAndView mav = new ModelAndView("updateProfessor");

		mav.addObject("professor", professorService.getProfessorById(id).get());
		mav.addObject("modalidades", modalidadeService.getAllModalidades());

		return mav;

	}

	@RequestMapping(value = "/updateProfessor", method = RequestMethod.POST)
	public String submitUpdateProfessor(@Validated @ModelAttribute("professor") Professor professor, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		professorService.updateProfessorById(professor.getId(), professor);

		return "redirect:/readProfessores";
	}

	@RequestMapping(value = "/readProfessores", method = RequestMethod.GET)
	public ModelAndView readProfessores() {

		ModelAndView mav = new ModelAndView("readProfessores");
		mav.addObject("professores", professorService.getAllProfessores());
		mav.addObject("modalidades", modalidadeService.getAllModalidades());
		return mav;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {

		ModelAndView mav = new ModelAndView("index");

		return mav;
	}

}

package com.cotemig.cotegym.API.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cotemig.cotegym.API.model.Ficha;
import com.cotemig.cotegym.API.model.Modalidade;
import com.cotemig.cotegym.API.model.Professor;
import com.cotemig.cotegym.API.service.AlunoService;
import com.cotemig.cotegym.API.service.ExercicioService;
import com.cotemig.cotegym.API.service.FichaService;
import com.cotemig.cotegym.API.service.ItemFichaService;
import com.cotemig.cotegym.API.service.ModalidadeService;
import com.cotemig.cotegym.API.service.ProfessorService;

@Controller
public class FichaController {
	
	@Autowired
	FichaService fichaService;
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired
	AlunoService alunoService;
	
	@Autowired
	ExercicioService exercicioService;
	
	@Autowired
	ModalidadeService modalidadeService;
	
	@Autowired
	ItemFichaService itemFichaService;
	
	
	@RequestMapping(value = "/insertFicha", method = RequestMethod.GET)
	public ModelAndView insertFicha() {

		ModelAndView mav = new ModelAndView("insertFicha");
		
		mav.addObject("ficha", new Ficha());
		mav.addObject("itensFicha", itemFichaService.getAllItensFicha());
		mav.addObject("alunos", alunoService.getAllAlunos());
		mav.addObject("professores", professorService.getAllProfessores());
		mav.addObject("exercicios", exercicioService.getAllExercicios());
		
		return mav;
	}

	@RequestMapping(value = "/insertFicha", method = RequestMethod.POST)
	public String submitInsertFicha(@Validated @ModelAttribute("ficha") Ficha ficha, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		Optional<Professor> professor = professorService.getProfessorById(ficha.getProfessor_id());
		Optional<Modalidade> modalidade = modalidadeService.getModalidadeById(professor.get().getModalidade_id());
		
		
		if(!professor.isPresent() || modalidade.get().getAerobico()) {
			
			return "error, professor inexistente ou com a modalidade do tipo aeróbico";
			
		} 
		
		fichaService.insertFicha(ficha);

		return "redirect:/painelFichas";
	}

	@RequestMapping(value = "/deleteFicha", method = RequestMethod.GET)
	public ModelAndView deleteFicha(Integer id) {

		ModelAndView mav = new ModelAndView("deleteFicha");
		
		mav.addObject("ficha", fichaService.getFichaById(id).get());
		mav.addObject("itensFicha", itemFichaService.getAllItensFicha());
		mav.addObject("alunos", alunoService.getAllAlunos());
		mav.addObject("professores", professorService.getAllProfessores());
		mav.addObject("exercicios", exercicioService.getAllExercicios());
		
		return mav;
	}

	@RequestMapping(value = "/deleteFicha", method = RequestMethod.POST)
	public String submitDeleteFicha(@Validated @ModelAttribute("ficha") Ficha ficha, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		fichaService.deleteFichaById(ficha.getId());

		return "redirect:/painelFichas";
	}

	@RequestMapping(value = "/updateFicha", method = RequestMethod.GET)
	public ModelAndView updateFicha(Integer id) {

		ModelAndView mav = new ModelAndView("updateFicha");
		
		mav.addObject("ficha", fichaService.getFichaById(id).get());
		mav.addObject("itensFicha", itemFichaService.getAllItensFicha());
		mav.addObject("alunos", alunoService.getAllAlunos());
		mav.addObject("professores", professorService.getAllProfessores());
		mav.addObject("exercicios", exercicioService.getAllExercicios());
		
		return mav;
	}

	@RequestMapping(value = "/updateFicha", method = RequestMethod.POST)
	public String submitUpdateFicha(@Validated @ModelAttribute("ficha") Ficha ficha, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		Optional<Professor> professor = professorService.getProfessorById(ficha.getProfessor_id());
		Optional<Modalidade> modalidade = modalidadeService.getModalidadeById(professor.get().getModalidade_id());
		
		if(!professor.isPresent() || modalidade.get().getAerobico()) {
			
			return "error, professor inexistente ou com a modalidade do tipo aeróbico";
		} 
		
		fichaService.updateFicha(ficha);

		return "redirect:/painelFichas";
	}

	@RequestMapping(value = "/readFichas", method = RequestMethod.GET)
	public ModelAndView readFichas() {

		ModelAndView mav = new ModelAndView("readFichas");
		mav.addObject("fichas", fichaService.getAllFichas());
		return mav;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {

		ModelAndView mav = new ModelAndView("index");

		return mav;
	}

	@RequestMapping(value = "/painelAdm", method = RequestMethod.GET)
	public ModelAndView painelAdm() {

		ModelAndView mav = new ModelAndView("painelAdm");
		return mav;
	}

	@RequestMapping(value = "/painelFichas", method = RequestMethod.GET)
	public ModelAndView painelFichas() {

		ModelAndView mav = new ModelAndView("painelFichas");
		mav.addObject("fichas", fichaService.getAllFichas());
		mav.addObject("itensFicha", itemFichaService.getAllItensFicha());
		mav.addObject("professores", professorService.getAllProfessores());
		mav.addObject("alunos", alunoService.getAllAlunos());
		
		return mav;
	}
	
	@RequestMapping(value = "/getFicha", method = RequestMethod.GET)
	public ModelAndView getFicha(Integer id) {

		ModelAndView mav = new ModelAndView("getFicha");
		
		mav.addObject("ficha", fichaService.getFichaById(id).get());
		mav.addObject("itensFicha", itemFichaService.getAllItensFicha());
		mav.addObject("alunos", alunoService.getAllAlunos());
		mav.addObject("professores", professorService.getAllProfessores());
		mav.addObject("exercicios", exercicioService.getAllExercicios());

		return mav;
	}
}

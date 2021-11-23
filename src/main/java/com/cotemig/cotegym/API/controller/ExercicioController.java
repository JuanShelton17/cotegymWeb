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

import com.cotemig.cotegym.API.model.Exercicio;
import com.cotemig.cotegym.API.service.ExercicioService;

@Controller
public class ExercicioController {
	
	@Autowired
	ExercicioService exercicioService;
	
	@RequestMapping(value = "/insertExercicio", method = RequestMethod.GET)
	public ModelAndView insertExercicio() {

		return new ModelAndView("insertExercicio", "exercicio", new Exercicio());

	}

	@RequestMapping(value = "/insertExercicio", method = RequestMethod.POST)
	public String submitInsertExercicio(@Validated @ModelAttribute("exercicio") Exercicio exercicio, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		exercicioService.insertExercicio(exercicio);

		return "redirect:/readExercicios";
	}

	@RequestMapping(value = "/deleteExercicio", method = RequestMethod.GET)
	public ModelAndView deleteExercicio(Integer id) {

		return new ModelAndView("deleteExercicio", "exercicio", exercicioService.getExercicioById(id).get());
	}

	@RequestMapping(value = "/deleteExercicio", method = RequestMethod.POST)
	public String submitDeleteExercicio(@Validated @ModelAttribute("exercicio") Exercicio exercicio, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		exercicioService.deleteExercicioById(exercicio.getId());

		return "redirect:/readExercicios";
	}

	@RequestMapping(value = "/updateExercicio", method = RequestMethod.GET)
	public ModelAndView updateExercicio(Integer id) {

		return new ModelAndView("updateExercicio", "exercicio", exercicioService.getExercicioById(id).get());

	}

	@RequestMapping(value = "/updateExercicio", method = RequestMethod.POST)
	public String submitUpdateExercicio(@Validated @ModelAttribute("exercicio") Exercicio exercicio, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		exercicioService.updateExercicio(exercicio);

		return "redirect:/readExercicios";
	}

	@RequestMapping(value = "/readExercicios", method = RequestMethod.GET)
	public ModelAndView readExercicios() {

		ModelAndView mav = new ModelAndView("readExercicios");
		mav.addObject("exercicios", exercicioService.getAllExercicios());
		return mav;
	}
}

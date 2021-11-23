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

import com.cotemig.cotegym.API.model.ItemFicha;
import com.cotemig.cotegym.API.service.ExercicioService;
import com.cotemig.cotegym.API.service.ItemFichaService;

@Controller
public class ItemFichaController {

	@Autowired
	ExercicioService exercicioService;
	
	@Autowired
	ItemFichaService itemFichaService;
	
	@RequestMapping(value = "/insertItemFicha", method = RequestMethod.GET)
	public ModelAndView insertItemFicha() {

		ModelAndView mav = new ModelAndView("insertItemFicha");
		mav.addObject("itemFicha", new ItemFicha());
		mav.addObject("exercicios", exercicioService.getAllExercicios());
		return mav;

	}

	@RequestMapping(value = "/insertItemFicha", method = RequestMethod.POST)
	public String submitInsertItemFicha(@Validated @ModelAttribute("itemFicha") ItemFicha itemFicha, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		itemFichaService.insertItemFicha(itemFicha);

		return "redirect:insertFicha";
	}

	@RequestMapping(value = "/deleteItemFicha", method = RequestMethod.GET)
	public ModelAndView deleteItemFicha(Integer id) {

		ModelAndView mav = new ModelAndView("deleteItemFicha");
		mav.addObject("itemFicha", itemFichaService.getItemFichaById(id).get());
		mav.addObject("exercicios", exercicioService.getAllExercicios());
		return mav;
	}

	@RequestMapping(value = "/deleteItemFicha", method = RequestMethod.POST)
	public String submitDeleteItemFicha(@Validated @ModelAttribute("itemFicha") ItemFicha itemFicha, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		itemFichaService.deleteItemFichaById(itemFicha.getId());

		return "redirect:readItensFicha";
	}

	@RequestMapping(value = "/updateItemFicha", method = RequestMethod.GET)
	public ModelAndView updateItemFicha(Integer id) {

		ModelAndView mav = new ModelAndView("updateItemFicha");
		mav.addObject("itemFicha", itemFichaService.getItemFichaById(id).get());
		mav.addObject("exercicios", exercicioService.getAllExercicios());
		return mav;
		
	}

	@RequestMapping(value = "/updateItemFicha", method = RequestMethod.POST)
	public String submitUpdateItemFicha(@Validated @ModelAttribute("itemFicha") ItemFicha itemFicha, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		itemFichaService.updateItemFicha(itemFicha);

		return "redirect:/readItensFicha";
	}

	// por id
	@RequestMapping(value = "/readItensFicha", method = RequestMethod.GET)
	public ModelAndView readItensFicha() {

		ModelAndView mav = new ModelAndView("readItensFicha");
		mav.addObject("itensFicha", itemFichaService.getAllItensFicha());
		mav.addObject("exercicios", exercicioService.getAllExercicios());
		return mav;
	}
	
}

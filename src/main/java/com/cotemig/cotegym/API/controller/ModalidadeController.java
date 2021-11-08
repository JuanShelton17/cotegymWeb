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

import com.cotemig.cotegym.API.model.Modalidade;
import com.cotemig.cotegym.API.service.ModalidadeServiceImpl;

@Controller
public class ModalidadeController {
	
	@Autowired
	ModalidadeServiceImpl modalidadeService;

	@RequestMapping(value = "/insertModalidade", method = RequestMethod.GET)
	public ModelAndView insertModalidade() {

		return new ModelAndView("insertModalidade", "modalidade", new Modalidade());

	}

	@RequestMapping(value = "/insertModalidade", method = RequestMethod.POST)
	public String submitInsertModalidade(@Validated @ModelAttribute("modalidade") Modalidade modalidade,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		if (modalidade.getAerobico() == null)
			modalidade.setAerobico(false);

		modalidadeService.insertModalidade(modalidade);

		return "redirect:/readModalidades";
	}

	@RequestMapping(value = "/deleteModalidade", method = RequestMethod.GET)
	public ModelAndView deleteModalidade(Integer id) {

		return new ModelAndView("deleteModalidade", "modalidade", modalidadeService.getModalidadeById(id).get());
	}

	@RequestMapping(value = "/deleteModalidade", method = RequestMethod.POST)
	public String submitDeleteModalidade(@Validated @ModelAttribute("modalidade") Modalidade modalidade,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		modalidadeService.deleteModalidadeById(modalidade.getId());

		return "redirect:/readModalidades";
	}

	@RequestMapping(value = "/updateModalidade", method = RequestMethod.GET)
	public ModelAndView updateModalidade(Integer id) {

		return new ModelAndView("updateModalidade", "modalidade", modalidadeService.getModalidadeById(id).get());

	}

	@RequestMapping(value = "/updateModalidade", method = RequestMethod.POST)
	public String submitUpdateModalidade(@Validated @ModelAttribute("modalidade") Modalidade modalidade,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		if (modalidade.getAerobico() == null)
			modalidade.setAerobico(false);

		modalidadeService.updateModalidade(modalidade);

		return "redirect:/readModalidades";
	}

	@RequestMapping(value = "/readModalidades", method = RequestMethod.GET)
	public ModelAndView readModalidades() {

		ModelAndView mav = new ModelAndView("readModalidades");
		mav.addObject("modalidades", modalidadeService.getAllModalidades());
		return mav;
	}

}

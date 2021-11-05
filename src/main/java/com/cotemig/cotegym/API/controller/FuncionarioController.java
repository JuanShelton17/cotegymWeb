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

import com.cotemig.cotegym.API.model.Funcionario;
import com.cotemig.cotegym.API.service.FuncionarioService;

@Controller
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;

	@RequestMapping(value = "/insertFuncionario", method = RequestMethod.GET)
	public ModelAndView insertFuncionario() {

		return new ModelAndView("insertFuncionario", "funcionario", new Funcionario());

	}

	@RequestMapping(value = "/insertFuncionario", method = RequestMethod.POST)
	public String submitInsertFuncionario(@Validated @ModelAttribute("funcionario") Funcionario funcionario,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		funcionarioService.insertFuncionario(funcionario);

		return "redirect:";
	}

	@RequestMapping(value = "/deleteFuncionario", method = RequestMethod.GET)
	public ModelAndView deleteFuncionario(Integer id) {

		return new ModelAndView("deleteFuncionario", "funcionario", funcionarioService.getFuncionarioById(id).get());
	}

	@RequestMapping(value = "/deleteFuncionario", method = RequestMethod.POST)
	public String submitDeleteFuncionario(@Validated @ModelAttribute("funcionario") Funcionario funcionario,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		funcionarioService.deleteFuncionarioById(funcionario.getId());

		return "redirect:";
	}

	@RequestMapping(value = "/updateFuncionario", method = RequestMethod.GET)
	public ModelAndView updateFuncionario(Integer id) {

		return new ModelAndView("updateFuncionario", "funcionario", funcionarioService.getFuncionarioById(id).get());

	}

	@RequestMapping(value = "/updateFuncionario", method = RequestMethod.POST)
	public String submitUpdateFuncionario(@Validated @ModelAttribute("funcionario") Funcionario funcionario,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		funcionarioService.updateFuncionario(funcionario);

		return "redirect:";
	}

	@RequestMapping(value = "/readFuncionarios", method = RequestMethod.GET)
	public ModelAndView readFuncionarios() {

		ModelAndView mav = new ModelAndView("readFuncionarios");
		mav.addObject("funcionarios", funcionarioService.getAllFuncionarios());
		return mav;
	}
}

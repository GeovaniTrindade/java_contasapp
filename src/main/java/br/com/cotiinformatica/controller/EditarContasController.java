package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditarContasController {

	@RequestMapping(value = "/admin/editar-contas")
	public ModelAndView cadastrarContas() {
		ModelAndView modelAndView = new ModelAndView("admin/editar-contas");
		return modelAndView;
	}

}

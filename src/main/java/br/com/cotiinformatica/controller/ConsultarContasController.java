package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConsultarContasController {

	@RequestMapping(value = "/admin/consultar-contas")
	public ModelAndView cadastrarContas() {
		ModelAndView modelAndView = new ModelAndView("admin/consultar-contas");
		return modelAndView;
	}

}

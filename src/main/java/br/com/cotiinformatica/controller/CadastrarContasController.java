package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CadastrarContasController {
	@RequestMapping(value = "/admin/cadastrar-contas")
	public ModelAndView cadastrarContas() {
		ModelAndView modelAndView = new ModelAndView("admin/cadastrar-contas");
		return modelAndView;
	}
}

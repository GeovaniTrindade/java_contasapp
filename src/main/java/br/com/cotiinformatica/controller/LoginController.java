package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value = "/") // caminho da página no navegador (raiz)
	public ModelAndView login() {
		// definir o nome da página que será exibida
		// WEB-INF/views/login.jsp
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
}

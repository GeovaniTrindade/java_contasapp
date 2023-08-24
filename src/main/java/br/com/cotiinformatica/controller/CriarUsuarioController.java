package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.helpers.MD5Helper;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class CriarUsuarioController {

	@Autowired // autoinicialização
	UsuarioRepository usuarioRepository; // atributo

	@RequestMapping(value = "/criar-usuario")
	// caminho da página no navegador
	public ModelAndView criarUsuario() {
		// Mapeamento da página que será exibida no navegador
		// WEB-INF/views/criar-conta.jsp
		ModelAndView modelAndView = new ModelAndView("criar-usuario");
		return modelAndView;
	}

	// método para capturar o submit post do formulário
	@RequestMapping(value = "/criar-usuario-post", method = RequestMethod.POST)
	public ModelAndView criarUsuarioPost(HttpServletRequest request) {
		// Mapeamento da página que será exibida no navegador
		// WEB-INF/views/criar-conta.jsp
		ModelAndView modelAndView = new ModelAndView("criar-usuario");

		try {

			Usuario usuario = new Usuario();

			usuario.setNome(request.getParameter("nome"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(MD5Helper.encrypt(request.getParameter("senha")));

			// verificar se o email
			//já está cadastrado no banco de dados
			if (usuarioRepository.find(usuario.getEmail()) != null) {
				modelAndView.addObject("mensagem_erro", "O email informado já está cadastrado. Tente outro.");
			} else {
				usuarioRepository.create(usuario);
				//cadastrando o usuário				
				modelAndView.addObject("mensagem_sucesso", "Usuário cadastrado com sucesso!");
			}
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", "Erro: " + e.getMessage());
		}

		return modelAndView;
	}
}

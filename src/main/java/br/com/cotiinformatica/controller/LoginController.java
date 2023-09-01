package br.com.cotiinformatica.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import br.com.cotiinformatica.dtos.UsuarioDTO;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.helpers.MD5Helper;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class LoginController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/") // caminho da página no navegador (raiz)
	public ModelAndView login() {
		// definir o nome da página que será exibida
		// WEB-INF/views/login.jsp
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@RequestMapping(value = "/login-post", method = RequestMethod.POST)
	public ModelAndView loginPost(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("login");

		try {

			// capturando os campos 'email' e 'senha'
			String email = request.getParameter("email");
			String senha = MD5Helper.encrypt(request.getParameter("senha"));

			// consultando o usuário no banco de dados através do email e da senha
			Usuario usuario = usuarioRepository.find(email, senha);

			// verificando se o usuário foi encontrado
			if (usuario != null) {

				// Autenticar o usuário
				UsuarioDTO dto = new UsuarioDTO();

				dto.setId(usuario.getId());
				dto.setNome(usuario.getNome());
				dto.setEmail(usuario.getEmail());
				dto.setDataHoraAcesso(new Date());

				// gravar os dados do DTO em uma sessão
				request.getSession().setAttribute("usuario_auth", dto);

				// redirecionar para a página /admin/dashboard
				modelAndView.setViewName("redirect:/admin/dashboard");
			} else {
				modelAndView.addObject("mensagem_erro", "Acesso negado. Usuário inválido.");
			}
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}
}

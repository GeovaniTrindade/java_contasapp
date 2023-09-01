package br.com.cotiinformatica.controller;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import br.com.cotiinformatica.dtos.UsuarioDTO;
import br.com.cotiinformatica.entities.Conta;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.ContaRepository;

@Controller
public class CadastrarContasController {
	@Autowired
	ContaRepository contaRepository;

	// método para abrir a página
	@RequestMapping(value = "/admin/cadastrar-contas")
	public ModelAndView cadastrarContas() {
		ModelAndView modelAndView = new ModelAndView("admin/cadastrar-contas");
		return modelAndView;
	}

	// método para receber o SUBMIT POST do formulário
	@RequestMapping(value = "/admin/cadastrar-contas-post", method = RequestMethod.POST)
	public ModelAndView cadastrarContasPost(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/cadastrar-contas");

		try {

			Conta conta = new Conta();
			conta.setUsuario(new Usuario());

			// capturando os dados enviados pelo formulário
			conta.setNome(request.getParameter("nome"));
			conta.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
			conta.setValor(Double.parseDouble(request.getParameter("valor")));
			conta.setDescricao(request.getParameter("descricao"));
			conta.setTipo(Integer.parseInt(request.getParameter("tipo")));

			// capturando o usuário autenticado na sessão
			UsuarioDTO usuarioDTO = (UsuarioDTO) request.getSession().getAttribute("usuario_auth");
			conta.getUsuario().setId(usuarioDTO.getId());

			// gravar no banco de dados:
			contaRepository.create(conta);

			// retornando mensagem para a página
			modelAndView.addObject("mensagem_sucesso", "Conta cadastrada com sucesso.");
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", "Erro: " + e.getMessage());
		}

		return modelAndView;
	}
}

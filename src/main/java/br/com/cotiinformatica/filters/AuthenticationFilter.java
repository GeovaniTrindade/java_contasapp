package br.com.cotiinformatica.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements Filter {
	public AuthenticationFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// converter os objetos ServletRequest e ServletResponse
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// verificar se o usuário está navegando em alguma página /admin
		if (req.getServletPath().contains("/admin/")) {
			// verificar se o usuário não está autenticado
			// verificar se o usuário não está gravado em sessão
			if (req.getSession().getAttribute("usuario_auth") == null) {
				// redirecionar de volta para a página inicial do sistema
				resp.sendRedirect("/java_contasapp/"); // raiz do projeto
			}
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}

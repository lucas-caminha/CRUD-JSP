package br.com.lucas.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucas.gerenciador.acao.Acao;

@WebFilter("/central")
public class FiltroDeControle implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String parametro = request.getParameter("acao");
		
		String nomeDaClasse = "br.com.lucas.gerenciador.acao." + parametro;
		
		String redirecionamento;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			redirecionamento = acao.executa(request,response);
		} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		
		String[] tipoRedirecionamento = redirecionamento.split(":");
		if(tipoRedirecionamento[0].equals("forward")) {
		    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoRedirecionamento[1]);
		    rd.forward(request, response);
		} else {
			response.sendRedirect(tipoRedirecionamento[1]);
		}
	}

}

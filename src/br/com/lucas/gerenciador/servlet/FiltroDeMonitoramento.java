package br.com.lucas.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/central")
public class FiltroDeMonitoramento implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long antes = System.currentTimeMillis();
		
		String parametro = request.getParameter("acao");
		
		// executa a a��o
		chain.doFilter(request, response);
		
		long depois =  System.currentTimeMillis();

		System.out.println("Tempo de Execu��o da A��o -> " + parametro + " -> " + (depois - antes) + "ms");
		
	}

}

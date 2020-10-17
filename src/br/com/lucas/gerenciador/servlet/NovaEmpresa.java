package br.com.lucas.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import br.com.lucas.gerenciador.DAO.EmpresaDAO;
import br.com.lucas.gerenciador.model.Empresa;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recebimento dos parametros da requisição
		String nomeEmpresa = request.getParameter("nome");
		String dataRecebida = request.getParameter("data");
		
		Date dataAbertura;
		
		// Parse da data recebida como string para formato Date.util
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataRecebida);
		} catch(Exception e) {
			throw new ServletException(e);
		}
				
		// Criação da nova empresa
		Empresa novaEmpresa = new Empresa(new Random().nextInt(9999), nomeEmpresa, dataAbertura);
		
		// Data access object
		EmpresaDAO empresaDao = new EmpresaDAO();
		empresaDao.adiciona(novaEmpresa);	
		System.out.println("Empresa Adicionada: " + novaEmpresa.toString());


		request.setAttribute("empresa", novaEmpresa.getNome());
		response.sendRedirect("listaEmpresas");

//		request.setAttribute("empresas", empresaDao.getListaDeEmpresas());
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
//		request.setAttribute("empresa", novaEmpresa.getNome());
//		rd.forward(request, response);
	}

}

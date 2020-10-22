package br.com.lucas.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucas.gerenciador.DAO.EmpresaDAO;

/**
 * Servlet implementation class CentralServlet
 */
@WebServlet("/central")
public class CentralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametro = request.getParameter("acao");
		EmpresaDAO empresaDao = new EmpresaDAO();
		String redirecionamento = null;
		
		if(parametro.equals("listaEmpresas")) {
			redirecionamento = empresaDao.listaEmpresas(request, response);
		} else if (parametro.equals("removeEmpresa")) {
			redirecionamento = empresaDao.removeEmpresa(request, response);
		} else if (parametro.equals("mostraEmpresa")) {
			redirecionamento = empresaDao.mostraEmpresa(request, response);
		} else if (parametro.equals("alteraEmpresa")) {
			redirecionamento = empresaDao.alteraEmpresa(request, response);
		} else if (parametro.equals("novaEmpresa")) {
			redirecionamento = empresaDao.adicionaEmpresa(request, response);
		} else if (parametro.equals("novaEmpresaForm")) {
			redirecionamento = empresaDao.novaEmpresaForm(request, response);
		} else {
			redirecionamento = empresaDao.listaEmpresas(request, response);
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

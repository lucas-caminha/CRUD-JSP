package br.com.lucas.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucas.gerenciador.DAO.EmpresaDAO;
import br.com.lucas.gerenciador.model.Empresa;

@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idEmpresa = req.getParameter("idEmpresa");
		Integer id = Integer.parseInt(idEmpresa);
		
		EmpresaDAO empresaDao = new EmpresaDAO();
		
		Empresa empresa = empresaDao.buscaEmpresa(id);
		
		req.setAttribute("empresa", empresa);
		
		RequestDispatcher rd = req.getRequestDispatcher("/formAlteraEmpresa.jsp");
		rd.forward(req, resp);
	}
	
		
	
	

}

package br.com.lucas.gerenciador.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
@WebServlet("/removeEmpresa")
public class RemoveEmpresa extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Servet at: ").append(request.getContextPath());
		try {
			String idEmpresa =  (String) request.getParameter("idEmpresa");	
			EmpresaDAO empresaDao = new EmpresaDAO();
			empresaDao.remove(Integer.parseInt(idEmpresa));
			response.sendRedirect("listaEmpresas");
		} catch(Exception e) {
			e.getMessage();
			response.sendRedirect("listaEmpresas");
		}
		

	}

}

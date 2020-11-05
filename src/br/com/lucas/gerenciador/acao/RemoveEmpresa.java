package br.com.lucas.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucas.gerenciador.DAO.EmpresaDAO;

public class RemoveEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmpresaDAO empresaDao = new EmpresaDAO();
		
		try {
			String idEmpresa =  (String) request.getParameter("idEmpresa");	
			empresaDao.remove(Integer.parseInt(idEmpresa));
			//response.sendRedirect("listaEmpresas");
		} catch(Exception e) {
			e.getMessage();
			//response.sendRedirect("central?acao=listaEmpresas");
		}
		
		return "redirect:central?acao=ListaEmpresas";
	}

}

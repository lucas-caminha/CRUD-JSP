package br.com.lucas.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucas.gerenciador.DAO.EmpresaDAO;
import br.com.lucas.gerenciador.model.Empresa;

public class MostraEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		String idEmpresa = request.getParameter("idEmpresa");
		Integer id = Integer.parseInt(idEmpresa);
		
		EmpresaDAO empresaDao = new EmpresaDAO();
		
		Empresa empresa = empresaDao.buscaEmpresa(id);
		
		request.setAttribute("empresa", empresa);
		
		//RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		//rd.forward(request, response);
		return "forward:formAlteraEmpresa.jsp";
	}
	
}

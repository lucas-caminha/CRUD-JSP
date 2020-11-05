package br.com.lucas.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucas.gerenciador.DAO.EmpresaDAO;
import br.com.lucas.gerenciador.model.Empresa;

public class ListaEmpresas implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmpresaDAO dao = new EmpresaDAO();
		List<Empresa> lista = dao.getListaDeEmpresas();
		request.setAttribute("empresas", lista);
		
		return "forward:listaEmpresas.jsp";
	}

}

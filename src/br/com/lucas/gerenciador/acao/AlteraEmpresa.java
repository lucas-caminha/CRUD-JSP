package br.com.lucas.gerenciador.acao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucas.gerenciador.DAO.EmpresaDAO;
import br.com.lucas.gerenciador.model.Empresa;

public class AlteraEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idEmpresa = request.getParameter("id");
		Integer id = Integer.parseInt(idEmpresa);
		String nomeEmpresa = request.getParameter("nome");
		String dataRecebida = request.getParameter("data");
		Date dataAbertura = null;
		
		// Parse da data recebida como string para formato Date.util
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataRecebida);
		} catch(Exception e) {
			throw new ServletException(e);
		}
		
		EmpresaDAO empresaDao = new EmpresaDAO();
		
		Empresa empresa = empresaDao.buscaEmpresa(id);
		empresaDao.edita(nomeEmpresa, dataAbertura, empresa);
		//empresa.setNome(nomeEmpresa);
		//empresa.setDataAbertura(dataAbertura);
		System.out.println(empresa.toString());
		
		//response.sendRedirect("central?acao=listaEmpresas");
		return "redirect:central?acao=ListaEmpresas";
	}

}

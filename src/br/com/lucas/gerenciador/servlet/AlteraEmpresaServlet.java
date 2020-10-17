package br.com.lucas.gerenciador.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucas.gerenciador.DAO.EmpresaDAO;
import br.com.lucas.gerenciador.model.Empresa;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idEmpresa = req.getParameter("id");
		Integer id = Integer.parseInt(idEmpresa);
		String nomeEmpresa = req.getParameter("nome");
		String dataRecebida = req.getParameter("data");
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
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		System.out.println(empresa.toString());
		
		resp.sendRedirect("listaEmpresas");
		
	}
	
	

}

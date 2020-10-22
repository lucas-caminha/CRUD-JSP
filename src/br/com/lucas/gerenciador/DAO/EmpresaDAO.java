package br.com.lucas.gerenciador.DAO;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucas.gerenciador.model.Empresa;

/**
 * 
 * @author lucas.caminha
 * @version 0.1
 *
 * Esta classe é um Data access object da classe Empresa utilizando ArrayList.
 */

public class EmpresaDAO {
	
	private static List<Empresa> listaDeEmpresas = new ArrayList<>();
	
	// Adiciona uma empresa a lista de empresas.
	public void adiciona(Empresa empresa) {
		listaDeEmpresas.add(empresa);
	}
	
	// Remove uma empresa com o nome pelo parametro.
	public void remove(String nomeEmpresa) {
		for (Empresa empresa : listaDeEmpresas) {
			if(nomeEmpresa.equals(empresa.getNome())) {
				System.out.println("Empresa Removida: " + empresa.toString());
				listaDeEmpresas.remove(empresa);
			}
		}
	}
	
	// Remove uma empresa com o id pelo parametro.
	public void remove(int id) {
		for (Empresa empresa : listaDeEmpresas) {
			if(id == empresa.getId()) {
				System.out.println("Empresa Removida: " + empresa.toString());
				listaDeEmpresas.remove(empresa);
			}
		}
	}
	
	// Edita a empresa.
	public void edita() {
		
	}
	
	public Empresa buscaEmpresa(int id) {
		for (Empresa empresa : listaDeEmpresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	
	// Retorna a listaDeEmpresas imodificavel
	public List<Empresa> getListaDeEmpresas(){
		return Collections.unmodifiableList(listaDeEmpresas);
	}
	
	public String listaEmpresas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmpresaDAO dao = new EmpresaDAO();
		List<Empresa> lista = dao.getListaDeEmpresas();
		request.setAttribute("empresas", lista);
		
		//RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		//rd.forward(request, response);	
		return "forward:listaEmpresas.jsp";
	}
	
	public String removeEmpresa(HttpServletRequest request, HttpServletResponse response)
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
		
		return "redirect:central?acao=listaEmpresas";
	}
	
	
	public String alteraEmpresa(HttpServletRequest request, HttpServletResponse response)
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
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		System.out.println(empresa.toString());
		
		//response.sendRedirect("central?acao=listaEmpresas");
		return "redirect:central?acao=listaEmpresas";
	}
	
	public String mostraEmpresa(HttpServletRequest request, HttpServletResponse response)
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
	
	public String adicionaEmpresa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
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


		//request.setAttribute("empresa", novaEmpresa.getNome());
		//response.sendRedirect("listaEmpresas");
		return "redirect:central?acao=listaEmpresas";

		
	}
	
	public String novaEmpresaForm (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return "forward:formNovaEmpresa.jsp";
	}
	
	

}

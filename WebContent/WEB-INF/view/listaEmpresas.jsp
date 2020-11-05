<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.lucas.gerenciador.model.Empresa"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<link href="${pageContext.request.contextPath}/resource/bootstrap/css/bootstrap.css" rel="stylesheet">
<head>
<meta charset="ISO-8859-1">
<title>Listagem das Empresas</title>
<style>
	body {
	  background-image: url("${pageContext.request.contextPath}/resource/images/background-empresa.png");
	  background-size: cover;
	}
	html,
body {
    height: 100%;
}

.container {
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>
</head>
<body>
	<c:if test="${not empty empresa}">
		Empresa ${empresa} cadastrada com sucesso!
	</c:if>
	
		<c:import url="NavBar.jsp"/>
	
		<div class="container">
			<ul class="list-group">
				<c:forEach items="${empresas}" var="empresa">
					<li class="list-group-item">
					<p>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/></p>
					 
					 <a class="btn btn-warning"  href="/gerenciador/central?acao=MostraEmpresa&idEmpresa=${empresa.id}">Editar</a> 
					 <a class="btn btn-danger"  href="/gerenciador/central?acao=RemoveEmpresa&idEmpresa=${empresa.id}">Remover</a>			 
					</li>
				</c:forEach>
				<a class="btn btn-success" href="/gerenciador/central?acao=NovaEmpresaForm">Adicionar Empresa</a> 
			</ul>

		</div>
</body>
</html>
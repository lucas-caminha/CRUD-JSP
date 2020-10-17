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
</head>
<body>
	<h2 class="alignright">Lista de Empresas 	<a class="btn btn-outline-success" href="/gerenciador/formNovaEmpresa.jsp" >Adicionar Empresa</a> </h2>
	
	<c:if test="${not empty empresa}">
		Empresa ${empresa} cadastrada com sucesso!
	</c:if>
	
	<div class="container-fluid">
		<ul class="list-group">
			<c:forEach items="${empresas}" var="empresa">
				<li class="list-group-item">
				<p>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/></p>
				 
				 <a class="btn btn-outline-warning"  href="/gerenciador/mostraEmpresa?idEmpresa=${empresa.id}">Editar</a> 
				 <a class="btn btn-outline-danger"  href="/gerenciador/removeEmpresa?idEmpresa=${empresa.id}">Remover</a>			 
				</li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>
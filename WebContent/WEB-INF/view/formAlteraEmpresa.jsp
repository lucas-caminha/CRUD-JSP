<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/central" var="linkEntradaServlet"/>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<link href="${pageContext.request.contextPath}/resource/bootstrap/css/bootstrap.css" rel="stylesheet">
<head>
<meta charset="ISO-8859-1">
<title>Altera Empresa</title>
</head>
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
<body>

    <c:import url="NavBar.jsp"/>
	<div class="container">
		<form action="${linkEntradaServlet}" method="post">
		  <input type="hidden" name="id" value="${empresa.id}"  />

		  <div class="form-group">
		    <label for="exampleInputEmail1">Nome da Empresa</label>
		    <input type="text" class="form-control" placeholder="Nome da Empresa" name="nome" value="${empresa.nome}">
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputEmail1">Data de Abertura</label>
		    <input type="text" class="form-control"  placeholder="01/01/0001" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>">
		  </div>
	
		  <input type="hidden" name="acao" value="AlteraEmpresa"  />
		  <button type="submit" class="btn btn-primary">Editar</button>
		</form>
	</div>
 
</body>
</html>
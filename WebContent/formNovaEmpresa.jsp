<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<link href="${pageContext.request.contextPath}/resource/bootstrap/css/bootstrap.css" rel="stylesheet">
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Nova Empresa</title>
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

	<div class="container">
		<form action="${linkServletNovaEmpresa}" method="post">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Nome da Empresa</label>
		    <input type="text" class="form-control" placeholder="Nome da Empresa" name="nome">
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputEmail1">Data de Abertura</label>
		    <input type="text" class="form-control"  placeholder="01/01/0001" name="data">
		  </div>
	
		  <button type="submit" class="btn btn-primary">Adicionar</button>
		</form>
	</div>
 
</body>
</html>
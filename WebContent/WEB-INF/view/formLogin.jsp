<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/central" var="linkServletNovaEmpresa"/>

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
		    <label for="exampleInputEmail1">Usuario:</label>
		    <input type="text" class="form-control" placeholder="User" name="login">
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputEmail1">Senha:</label>
		    <input type="password" class="form-control"  placeholder="********" name="senha">
		  </div>
	
		  <input type="hidden" name="acao" value="Login">
		  <button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
 
</body>
</html>
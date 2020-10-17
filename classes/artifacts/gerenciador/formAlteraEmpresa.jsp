<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alteraEmpresa" var="linkServletAlteraEmpresa"/>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera Empresa</title>
</head>
<body>
	
	<form action="${linkServletAlteraEmpresa}" method="post">
		<input type="hidden" name="id" value="${empresa.id}"  />
		Nome: <input type="text" name="nome" value="${empresa.nome}"/>
		Data: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
		
		<input type="submit"/>
	
	</form>
 
</body>
</html>
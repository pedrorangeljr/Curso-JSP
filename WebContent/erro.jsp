<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de erro</title>
</head>
<body>

   <h1>Messagem de Erro entre em contato com a equipe de suporte do sistema</h1>
   <br/>
   
   <%
   
      out.print(request.getAttribute("msg"));
   
   %>

</body>
</html>
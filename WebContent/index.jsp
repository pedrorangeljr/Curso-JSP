<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

 <form action="ServletLogin" method="post">
 
     <input type="hidden" value="<%= request.getParameter("url") %>" name="url">
      
      <label>Login</label>
      <br/>
      <input type="text" name="login" id="login">
      <br/>
      
      <label>Senha</label>
      <br/>
      <input type="password" name="senha" id="senha">
      <br/>
      <br/>
      
      <input type="submit" value="Logar">
 </form>
 <br/>
 <h3>${msg}</h3>
</body>
</html>
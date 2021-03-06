<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Pagina de Login</title>
<link rel="stylesheet" href="<c:url value='/css/estilos.css'/>" type="text/css" />
</head>
<body onload='document.f.j_username.focus();'>
<img src="<c:url value='/imagenes/xfiles.jpg'/>" align="right"/>
<div id="content">
	<h3>Entrar con Usuario y Contrase�a</h3>

	<c:if test="${param.login_error ne null}">
      <font color="orange">
        El intento de conectar no tuvo �xito, intentelo de nuevo.<br/>
        Raz�n: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
    </c:if>
	<form name="f" action="<c:url value='/j_spring_security_check'/>"method="POST">
		<table>
			<tr>
				<td>Usuario:</td>
				<td><input type="text" name="j_username" value="${cookie.SPRING_SECURITY_LAST_USERNAME.value}"/></td>
			</tr>
			<tr>
				<td>Contrase�a:</td>
				<td><input type="password" name="j_password" /></td>
			</tr>
			<tr>
				<td>Recordarme:</td>
				<td><input type="checkbox" name="_spring_security_remember_me"  /></td>
			</tr>	
			<tr>
				<td colspan='2'><input name="submit" type="submit"	value="Login" /></td>
			</tr>
		</table>
	</form>
</div>	
</body>
</html>




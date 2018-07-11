<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Sesion 1: Trabajamos directamente con HttpSession</h2>
	
	<form:form action="addProducto1.htm" commandName="detalle">
	
		<input type="submit" value="Dale"/>

		<table border="0">
			<tr>
				<td>
					Producto
				</td>
				<td>
					<form:input path="producto"/>
				</td>
			</tr>		
			<tr>
				<td>
					Cantidad
				</td>
				<td>
					<form:input path="cantidad"/>
				</td>
			</tr>		

		</table>
	
	</form:form>
	
	<table border="1">
		<tr>
			<th>Producto</th>
			<th>Cantidad</th>
		</tr>
		<c:forEach items="${pedidoSesion1.detalles}" var="d">
			<tr>
				<td>${d.producto}</td>
				<td>${d.cantidad}</td>
			</tr>		
		</c:forEach>		
	</table>	


</body>
</html>
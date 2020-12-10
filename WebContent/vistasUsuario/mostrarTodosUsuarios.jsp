<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page  import="controlador.control_Usuario.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-Transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>Insert title here</title>
	<style>
		#cabecera {
			font-weight: bold;
		}
	</style>
	</head>
	<body>
	<table border="1">
		<tr id="cabecera">
			<td>Id_usuario</td>
			<td>Nombre</td>
			<td>Apellidos</td>
			<td>Usuario</td>
			<td>Contraseña</td>
			<td>País</td>
			<td>Tecnología</td>
		</tr>
		
			<c:forEach var="usuarios" items="${requestScope.listaUsuarios}">
				<tr>
					<td>${usuarios.id_usuario}</td>
					<td>${usuarios.nombre}</td>
					<td>${usuarios.apellidos}</td>
					<td>${usuarios.usuario}</td>
					<td>${usuarios.contrasena}</td>
					<td>${usuarios.pais}</td>
					<td>${usuarios.tecnologia}</td>
				</tr>
			</c:forEach>
		
	</table>
	
	</body>
</html>
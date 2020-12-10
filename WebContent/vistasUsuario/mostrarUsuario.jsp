<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-Transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>Insert title here</title>
	</head>
	<body>
		<c:set var="usu" value="${requestScope.usuarioBuscado}"/>
		<table border="1">
			<tr class="cabecera">
				<td>Id usuario</td>
				<td>Nombre</td>
				<td>Apellidos</td>
				<td>Usuario</td>
				<td>Contraseña</td>
				<td>Pais</td>
				<td>Tecnología</td>
			</tr>
			<tr>
				<td>${usu.id_usuario}</td>
				<td>${usu.nombre}</td>
				<td>${usu.apellidos}</td>
				<td>${usu.usuario}</td>
				<td>${usu.contrasena}</td>
				<td>${usu.pais}</td>
				<td>${usu.tecnologia}</td>
			</tr>	
		<!--Otra forma-->
			<tr>
				<td>${usuarioBuscado.id_usuario}</td>
				<td>${usuarioBuscado.nombre}</td>
				<td>${usuarioBuscado.apellidos}</td>
				<td>${usuarioBuscado.usuario}</td>
				<td>${usuarioBuscado.contrasena}</td>
				<td>${usuarioBuscado.pais}</td>
				<td>${usuarioBuscado.tecnologia}</td>
			</tr>
		</table>
	</body>
</html>
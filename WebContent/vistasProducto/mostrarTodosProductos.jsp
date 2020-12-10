<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page  import="controlador.control_Producto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-Transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link href="resources/css/estilo.css" rel="stylesheet" type="text/css"/> 
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
			<td>Codigo</td>
			<td>Sección</td>
			<td>Nombre</td>
			<td>Precio</td>
			<td>Fecha</td>
			<td>Importado</td>
			<td>País</td>
			<td>acción</td>
		</tr>
		
		<c:forEach var="producto" items="${requestScope.listaProductos}">
		
			<!-- Link para cada producto con su campo clave -->
			<c:url var="linkTemp" value="Controlador_Producto">
				<c:param name="instruccion" value="cargaParaActualizar"></c:param>
				<c:param name="codProducto" value="${producto.codProd }"></c:param>
			</c:url>
		
			<!-- Link para eliminar un producto con su campo clave -->
			<c:url var="linkTempEliminar" value="Controlador_Producto">
				<c:param name="instruccion" value="eliminar"></c:param>
				<c:param name="codProducto" value="${producto.codProd }"></c:param>
			</c:url>
		
			<tr>
				<td>${producto.codProd}</td>
				<td>${producto.seccion}</td>
				<td>${producto.nombreProd}</td>
				<td>${producto.precio}</td>
				<td>${producto.fecha}</td>
				<td>${producto.importado}</td>
				<td>${producto.pais}</td>
				<td>
					<a href="${linkTemp}">Actualizar</a> &nbsp; &nbsp;
					<a href="${linkTempEliminar}">Eliminar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<input type="button" value="Insertar Registro" onclick="window.location.href='vistasProducto/insertaProducto.jsp'"/>
	</body>
</html>
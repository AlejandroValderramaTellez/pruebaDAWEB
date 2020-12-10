<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page  import="controlador.control_Producto.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
<body>
	<h1>Actualizar registros</h1>
	<fmt:requestEncoding value="UTF-8"/>
	<form action="${pageContext.request.contextPath}/Controlador_Producto" method="post">
	<input type="hidden" name="instruccion" value="actualizar" />
	<input type="hidden" name="codProducto" value="${productoEncontrado.codProd}" />
		<table>
			<tr>
				<td>CodProd: </td>
				<td><input type="text" name="codProd" value="${productoEncontrado.codProd }" /></td>
			</tr>
			<tr>
				<td>Sección: </td>
				<td><input list="lista" name="seccion" value="${productoEncontrado.seccion }" />
					<datalist id="lista">
						<option value="Calzado"></option>
						<option value="Ferreteria"></option>
						<option value="Confeccion"></option>
						<option value="Deportes"></option>
						<option value="Confección"></option>
					</datalist>
				</td>
			</tr>
			<tr>
				<td>Nombre Artículo: </td>
				<td><input type="text" name="nombreProd" value="${productoEncontrado.nombreProd }" /></td>
			</tr>
			<tr>
				<td>Precio: </td>
				<td><input type="text" name="precio" value="${productoEncontrado.precio }"/></td>
			</tr>
			<tr>
				<td>Fecha: </td>
				<td><input type="text" name="fecha" value="${productoEncontrado.fecha }"/></td>
			</tr>
			<tr>
				<td>Importado: </td>
				<td><input type="text" name="importado" value="${productoEncontrado.importado }"/></td>
			</tr>
			<tr>
				<td>Pais: </td>
				<td><input type="text" name="pais" value="${productoEncontrado.pais }"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="envio" value="Actualizar" /></td>
				<td><input type="reset" name="restablecer" value="Restablecer" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../Controlador_Producto" method="post">
	<input type="hidden" name="instruccion" value="insertar"> 
		<table>
			<tr>
				<td>CodProd: </td>
				<td><input type="text" name="codProd"></td>
			</tr>
			<tr>
				<td>Sección: </td>
				<td><input list="lista" name="seccion"/>
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
				<td><input type="text" name="nombreProd"></td>
			</tr>
			<tr>
				<td>Precio: </td>
				<td><input type="text" name="precio"></td>
			</tr>
			<tr>
				<td>Fecha: </td>
				<td><input type="text" name="fecha"></td>
			</tr>
			<tr>
				<td>Importado: </td>
				<td><input type="text" name="importado"></td>
			</tr>
			<tr>
				<td>Pais: </td>
				<td><input type="text" name="pais"></td>
			</tr>
			<tr>
				<td><input type="submit" name="insertar" value="Enviar"></td>
				<td><input type="reset" name="restablecer" value="Restablecer"></td>
			</tr>
		</table>
	</form>
</body>
</html>
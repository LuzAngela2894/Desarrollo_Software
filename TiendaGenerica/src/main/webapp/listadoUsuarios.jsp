<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Usuarios</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link rel="stylesheet" href="listado.css">
<style>
ul{list-style:none;}
</style>
<%Conexion cx = new Conexion();%>
</head>
<body>
	<div class="container">
		<div class="title">
			<h1>Listado de Usuarios</h1>
		</div>
		<table class="content-table" border="1">
			<thead>
				<tr>
					<th scope="col">Cédula</th>
					<th scope="col">Nombre</th>
					<th scope="col">Correo</th>
					<th scope="col">Usuario</th>
					<th scope="col">Contraseña</th>
				</tr>
			</thead>
			<%
			PreparedStatement ps = cx.getConnection().prepareStatement("SELECT * FROM usuarios");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
			%>
			<tbody id="table">
				<tr>
					<td><%=result.getString("cedula_usuario")%></td>
					<td><%=result.getString("nombre_usuario")%></td>
					<td><%=result.getString("email_usuario")%></td>
					<td><%=result.getString("usuario")%></td>
					<td><%=result.getString("contrasena")%></td>
				</tr>
			</tbody>
			<%
			}
			%>
		</table>
		<ul>
			<li><a href="menuReportes.html" class="Volver"><i class="fas fa-undo-alt"></i>Volver</a></li>
		</ul>
	</div>
</body>
</html>
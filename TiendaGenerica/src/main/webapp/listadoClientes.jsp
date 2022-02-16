<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Clientes</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link rel="stylesheet" href="listado.css">
<style>
ul{list-style:none;}
</style>
<%
Conexion cx = new Conexion();
%>
</head>
<body>
	<div class="container">
		<div class="title">
			<h1>Listado de Clientes</h1>
		</div>
		<table class="content-table" border="1">
			<thead>
				<tr>
					<th>Cédula</th>
					<th>Nombre</th>
					<th>Dirección</th>
					<th>Teléfono</th>
					<th>Email</th>
				</tr>
			</thead>
			<%
			PreparedStatement ps = cx.getConnection().prepareStatement("SELECT * FROM clientes");
			ResultSet result = ps.executeQuery();
			while (result.next()) {
			%>
			<tbody id="table">
				<tr>
					<td><%=result.getString("cedula_cliente")%></td>
					<td><%=result.getString("nombre_cliente")%></td>
					<td><%=result.getString("direccion_cliente")%></td>
					<td><%=result.getString("telefono_cliente")%></td>
					<td><%=result.getString("email_cliente")%></td>
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
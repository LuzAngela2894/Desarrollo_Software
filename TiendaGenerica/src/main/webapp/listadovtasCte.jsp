<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas por Cliente</title>
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
			<h1>Total de Ventas por Cliente</h1>
		</div>
		<table class="content-table" border="1">
			<thead>
				<tr>
					<th>Cédula</th>
					<th>Nombre</th>
					<th>Valor Total Ventas</th>
				</tr>
				<%
				PreparedStatement ps = cx.getConnection().prepareStatement(
						"SELECT c.cedula_cliente, c.nombre_cliente, v.valor_venta FROM ventas v INNER join clientes c on c.cedula_cliente = v.cedula_cliente");
				ResultSet result = ps.executeQuery();
				while (result.next()) {
				%>
			</thead>
			<tbody id="table">
				<tr>
					<td><%=result.getString("cedula_cliente")%></td>
					<td><%=result.getString("nombre_cliente")%></td>
					<td><%=result.getString("valor_venta")%></td>
				</tr>
			</tbody>
			<%
			}
			%>
			<%
				PreparedStatement ps1 = cx.getConnection().prepareStatement(
						"SELECT sum(v.valor_venta) FROM ventas v INNER JOIN clientes c on c.cedula_cliente = v.cedula_cliente");
				ResultSet result1 = ps1.executeQuery();
				while (result1.next()) {
				%>
			<tr>
				<td></td>
				<td><b>Total Ventas $</b></td>
				<td><%=result1.getString("sum(v.valor_venta)")%></td>
			</tr>
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
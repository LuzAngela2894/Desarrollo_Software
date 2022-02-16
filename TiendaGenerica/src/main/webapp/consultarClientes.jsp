<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultar Clientes</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link rel="stylesheet" href="consultar.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
ul{list-style:none;}
</style>
<%Conexion cx = new Conexion();%>
</head>
<body>
	<div class="inicio">
	<img class="avatar" src="search.png" alt="serach">
		<form action="" method="post">
			<div class="title">Consultar Cliente</div>
			<div class="input-box">
				<span class="details">Cédula:</span> <input type="text"
					name="cedula" placeholder="Ingrese su Cédula" required>
			</div>
			<div>
				<button class="consultar" type="submit">Consultar</button>
			</div>
		</form>
	</div>

	<%
		String cedula = request.getParameter("cedula");
		PreparedStatement ps = cx.getConnection().prepareStatement("SELECT * FROM clientes WHERE cedula_cliente = "+cedula);
		ResultSet result = ps.executeQuery();
		while(result.next()){
	%>

	<div class="container">
		<div class="title">Cliente</div>
		<form action="" method="get">
			<div class="detalles">
				<div class="input-box">
					<span class="details">Nombre Completo:</span> <input type="text"
						name="nombre" value="<%= result.getString("nombre_cliente")%>" required>
				</div>
				<div class="input-box">
					<span class="details">Dirección:</span> <input type="text"
						name="direccion"
						value="<%= result.getString("direccion_cliente")%>" required>
				</div>
				<div class="input-box">
					<span class="details">Teléfono:</span> <input type="text"
						name="telefono" value="<%= result.getString("telefono_cliente")%>" required>
				</div>
				<div class="input-box">
					<span class="details">Correo Eletrónico:</span> <input type="text"
						name="email" value="<%= result.getString("email_cliente")%>" required>
				</div>
				<ul>
					<li><a href="menuClientes.html" class="Volver"><i
							class="fas fa-undo-alt"></i>Volver</a></li>
				</ul>
			</div>
		</form>
	</div>
	<%
		}
	%>
</body>
</html>
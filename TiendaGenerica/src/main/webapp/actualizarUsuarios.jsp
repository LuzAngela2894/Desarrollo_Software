<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.swing.JOptionPane"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Usuarios</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link rel="stylesheet" href="actualizar.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
ul {
	list-style: none;
}
</style>
<%
Conexion cx = new Conexion();
%>
</head>
<body>
	<div class="inicio">
		<img class="avatar" src="refresh.png" alt="serach">
		<form action="" method="post">
			<div class="title">Actualizar Usuario</div>
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
	PreparedStatement ps = cx.getConnection().prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario = " + cedula);
	ResultSet result = ps.executeQuery();
	while (result.next()) {
	%>
	<div class="container">
		<div class="title">Actualizar Usuario</div>
		<form action="" method="post">
			<div class="detalles">
				<div class="input-box">
					<span class="details">Cédula:</span> <input type="text"
						name="cedula" value="<%=result.getString("cedula_usuario")%>"
						required>
				</div>
				<div class="input-box">
					<span class="details">Nombre:</span> <input type="text"
						name="nombre" value="<%=result.getString("nombre_usuario")%>"
						required>
				</div>
				<div class="input-box">
					<span class="details">Correo Electrónico:</span> <input type="text"
						name="email" value="<%=result.getString("email_usuario")%>"
						required>
				</div>
				<div class="input-box">
					<span class="details">Usuario:</span> <input type="text"
						name="usuario" value="<%=result.getString("usuario")%>" required>
				</div>
				<div class="input-box">
					<span class="details">Contraseña:</span> <input type="password"
						name="contrasena" value="<%=result.getString("contrasena")%>"
						required>
				</div>
				<div class="input-box">
					<span class="details">Rol:</span> <input type="text" name="rol"
						value="<%=result.getString("rol")%>" required>
				</div>
				<div>
					<button class="actualizar" type="submit" name="actualizar">Actualizar</button>
				</div>
				<ul>
					<li><a href="menuUsuarios.html" class="Volver"><i
							class="fas fa-undo-alt"></i>Volver</a></li>
				</ul>
			</div>
		</form>
	</div>
	<%
	}
		if (request.getParameter("actualizar") != null) {
		cedula = request.getParameter("cedula");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String usuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
		String rol = request.getParameter("rol");
		if (cedula != null && nombre != null && email != null && usuario != null && contrasena != null && rol != null) {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("UPDATE usuarios SET nombre_usuario ='" + nombre + "', email_usuario ='" + email + "', usuario ='"
			+ usuario + "', contrasena ='" + contrasena + "', rol ='" + rol + "' WHERE cedula_usuario = " + cedula);
			JOptionPane.showMessageDialog(null, "Se ha actualizado el usuario");
			response.sendRedirect("menuUsuarios.html");
		}else{
			JOptionPane.showMessageDialog(null, "No se pudo actualizar el usuario");
			response.sendRedirect("menuUsuarios.html");
		}
	} 
	%>
</body>
</html>
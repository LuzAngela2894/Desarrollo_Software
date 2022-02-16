<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.swing.JOptionPane"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Usuarios</title>
<%
Conexion cx = new Conexion();
%>
</head>
<body>
	<%
	try {
		String cedula = request.getParameter("cedula");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String usuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
		String rol = request.getParameter("rol");
		Statement st = cx.getConnection().createStatement();
		st.executeUpdate(
		"INSERT INTO usuarios(cedula_usuario, nombre_usuario, email_usuario, usuario, contrasena, rol) VALUES('"
				+ cedula + "','" + nombre + "','" + email + "','" + usuario + "','" + contrasena + "','" + rol
				+ "')");
		JOptionPane.showMessageDialog(null, "Se ha creado el usuario");
		response.sendRedirect("menuUsuarios.html");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Este usuario ya está registrado");
	}
	%>
</body>
</html>
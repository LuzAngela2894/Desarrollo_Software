<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.swing.JOptionPane"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrar Usuarios</title>
<%
Conexion cx = new Conexion();
%>
</head>
<body>
	<%
	try {
		String cedula = request.getParameter("cedula");
		PreparedStatement ps = cx.getConnection().prepareStatement("DELETE FROM usuarios WHERE cedula_usuario = " + cedula);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Se ha eliminado el usuario");
		response.sendRedirect("menuUsuarios.html");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se puede eliminar usuario");
		response.sendRedirect("menuUsuarios.html");
	}
	%>
</body>
</html>
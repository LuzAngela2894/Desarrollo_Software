<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.swing.JOptionPane"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrar Clientes</title>
<%
Conexion cx = new Conexion();
%>
</head>
<body>
	<%
	try {
		String cedula = request.getParameter("cedula");
		PreparedStatement ps = cx.getConnection().prepareStatement("DELETE FROM clientes WHERE cedula_cliente = " + cedula);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Se ha eliminado el cliente");
		response.sendRedirect("menuClientes.html");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se puede eliminar cliente");
		response.sendRedirect("menuClientes.html");
	}
	%>
</body>
</html>
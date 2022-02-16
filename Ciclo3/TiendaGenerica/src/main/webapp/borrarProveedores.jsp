<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.swing.JOptionPane"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrar Proveedores</title>
<%
Conexion cx = new Conexion();
%>
</head>
<body>
	<%
	try {
		String nit = request.getParameter("nit");
		PreparedStatement ps = cx.getConnection().prepareStatement("DELETE FROM proveedores WHERE nit_proveedor = " + nit);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Se ha eliminado el proveedor");
		response.sendRedirect("menuProveedores.html");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "No se puede eliminar proveedor");
		response.sendRedirect("menuProveedores.html");
	}
	%>
</body>
</html>
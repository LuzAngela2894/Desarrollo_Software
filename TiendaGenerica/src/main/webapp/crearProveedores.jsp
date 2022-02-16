<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.swing.JOptionPane"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Proveedores</title>
<%
Conexion cx = new Conexion();
%>
</head>
<body>
	<%
	try {
		String nit = request.getParameter("nit");
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String ciudad = request.getParameter("ciudad");
		Statement st = cx.getConnection().createStatement();
		st.executeUpdate(
		"INSERT INTO proveedores(nit_proveedor, nombre_proveedor, direccion_proveedor, telefono_proveedor, ciudad_proveedor) VALUES('"
				+ nit + "','" + nombre + "','" + direccion + "','" + telefono + "','" + ciudad + "')");
		JOptionPane.showMessageDialog(null, "Se ha creado el proveedor");
		response.sendRedirect("menuProveedores.html");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Este proveedor ya está registrado");
	}
	%>
</body>
</html>
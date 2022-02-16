<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.swing.JOptionPane"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Productos</title>
<%
Conexion cx = new Conexion();
%>
</head>
<body>
	<%
	try {
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String nit = request.getParameter("nit");
		String pcompra = request.getParameter("pcompra");
		String icompra = request.getParameter("icompra");
		String pventa = request.getParameter("pventa");
		Statement st = cx.getConnection().createStatement();
		st.executeUpdate(
		"INSERT INTO productos(codigo_producto, nombre_producto, nit_proveedor, precio_compra, iva_compra, precio_venta) VALUES('"
				+ codigo + "','" + nombre + "','" + nit + "','" + pcompra + "','" + icompra + "','" + pventa
				+ "')");
		JOptionPane.showMessageDialog(null, "Se ha creado el producto");
		response.sendRedirect("menuUsuarios.html");
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Este producto ya está registrado");
	}
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.swing.JOptionPane"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Clientes</title>
<%Conexion cx = new Conexion();%>
</head>
<body>
	<%
	try{
	String cedula = request.getParameter("cedula");
	String nombre = request.getParameter("nombre");
	String direccion = request.getParameter("direccion");
	String telefono = request.getParameter("telefono");
	String email = request.getParameter("email");
	Statement st = cx.getConnection().createStatement();
	st.executeUpdate(
			"INSERT INTO clientes(cedula_cliente, nombre_cliente, direccion_cliente, telefono_cliente, email_cliente) VALUES('"
			+ cedula + "','" + nombre + "','" + direccion + "','" + telefono + "','" + email + "')");
	JOptionPane.showMessageDialog(null,"Se ha creado el cliente");
	response.sendRedirect("menuClientes.html");
	}catch(Exception e){
		JOptionPane.showMessageDialog(null, "Este cliente ya está registrado");
	}
	%>
</body>
</html>
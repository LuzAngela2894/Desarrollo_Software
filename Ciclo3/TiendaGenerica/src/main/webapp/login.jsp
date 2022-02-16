<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.swing.JOptionPane"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%Conexion cx = new Conexion();%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<%
	String usuario = request.getParameter("usuario");
	String contrasena = request.getParameter("contrasena");
	String rol = request.getParameter("rol");
	PreparedStatement ps = cx.getConnection().prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ? AND rol = ?");
	ps.setString(1, usuario);
	ps.setString(2, contrasena);
	ps.setString(3, rol);
	ResultSet result = ps.executeQuery();
	int i = 0;
	while (result.next()) {
		i++;
	}
	if (i == 1) {
		response.sendRedirect("menuPrincipal.html");
	} else {
		JOptionPane.showMessageDialog(null, "¡Cuidado! Usuario o contraseña incorrectos.");
		response.sendRedirect("index.html");
	}
	%>
</body>
</html>
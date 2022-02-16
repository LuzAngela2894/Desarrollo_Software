<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.swing.JOptionPane"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>%@ page import="conexion.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Productos</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link rel="stylesheet" href="actualizar.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
ul{list-style:none;}
</style>
<%Conexion cx = new Conexion();%>
</head>
<body>
	<div class="inicio">
		<img class="avatar" src="refresh.png" alt="serach">
		<form action="" method="post">
			<div class="title">Actualizar Producto</div>
			<div class="input-box">
				<span class="details">Código Producto:</span> <input type="text"
					name="codigo" placeholder="Ingrese Código Producto" required>
			</div>
			<div>
				<button class="consultar" type="submit">Consultar</button>
			</div>
		</form>
	</div>

	<%
	String codigo = request.getParameter("codigo");
	PreparedStatement ps = cx.getConnection().prepareStatement("SELECT * FROM productos WHERE codigo_producto = " + codigo);
	ResultSet result = ps.executeQuery();
	while (result.next()) {
	%>

	<div class="container">
		<div class="title">Producto</div>
		<form action="" method="get">
			<div class="detalles">
				<div class="input-box">
					<span class="details">Nombre Producto:</span> <input type="text"
						name="nombre" value="<%=result.getString("nombre_producto")%>"
						required>
				</div>
				<div class="input-box">
					<span class="details">Nit Proveedor:</span> <input type="text"
						name="nit" value="<%=result.getString("nit_proveedor")%>" required>
				</div>
				<div class="input-box">
					<span class="details">Precio Compra:</span> <input type="text"
						name="pcompra" value="<%=result.getString("precio_compra")%>"
						required>
				</div>
				<div class="input-box">
					<span class="details">Iva Compra:</span> <input type="number"
						name="icompra" value="<%=result.getString("iva_compra")%>"
						required>
				</div>
				<div class="input-box">
					<span class="details">Precio Venta:</span> <input type="text"
						name="pventa" value="<%=result.getString("precio_venta")%>"
						required>
				</div>
				<div>
					<button class="actualizar" type="submit" name="actualizar">Actualizar</button>
				</div>
				<ul>
					<li><a href="menuProductos.html" class="Volver"><i
							class="fas fa-undo-alt"></i>Volver</a></li>
				</ul>
			</div>
		</form>
	</div>
	<%
	}
		if (request.getParameter("actualizar") != null) {
		codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String nit = request.getParameter("nit");
		String pcompra = request.getParameter("pcompra");
		String icompra = request.getParameter("icompra");
		String pventa = request.getParameter("pventa");
		if (codigo != null && nombre != null && nit != null && pcompra != null && icompra != null && pventa != null) {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("UPDATE productos SET nombre_producto ='" + nombre + "', nit_proveedor ='" + nit + "', precio_compra ='"
			+ pcompra + "', iva_compra ='" + icompra + "', precio_venta ='" + pventa + "' WHERE codigo_producto = " + codigo);
			JOptionPane.showMessageDialog(null, "Se ha actualizado el producto");
			response.sendRedirect("menuProductos.html");
		}else{
			JOptionPane.showMessageDialog(null, "No se pudo actualizar el producto");
			response.sendRedirect("menuProductos.html");
		}
	}
	%>
</body>
</html>
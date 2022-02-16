<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.swing.JOptionPane"%>
<%@ page import="com.tiendagenerica.CONEXION.Conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin=" anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link rel="stylesheet"  type="text/css" href="ventas.css">
<title>Modulo Ventas</title>
<%
Conexion cx = new Conexion();
%>
</head>
<body>
	<h1 style="color: WHITE">Módulo Ventas</h1>
	<div class="row">
		<div class="col-md-5 seccion1">
			<div class="card">
				<h5 class="card-header">Datos Usuario</h5>
				<div class="card-body">
					<form action="" method="GET">
						<div class="row">
							<div class="col-md-4 d-flex">
								<select name="cedulausuario" class="form-control">
									<option selected disabled>Nombre Usuario</option>
									<%
									PreparedStatement ctau = cx.getConnection().prepareStatement("SELECT * FROM usuarios");
									ResultSet rseu = ctau.executeQuery();
									while (rseu.next()) {
									%>
									<option value="<%=rseu.getString("cedula_usuario")%>"><%=rseu.getString("nombre_usuario")%></option>
									<%
									}
									%>
								</select>
							</div>
							<div class="col-md-8 d-flex"></div>
						</div>
						<div class="row"></div>
						<div class="row"></div>
						<h5 class="card-header">Datos Cliente</h5>
						<div class="card-body">
							<div class="row">
								<div class="col-md-4 d-flex">
									<select name="cedulacliente" class="form-control">
										<option selected disabled>Nombre Cliente</option>
										<%
										PreparedStatement ctac = cx.getConnection().prepareStatement("SELECT * FROM clientes");
										ResultSet rsec = ctac.executeQuery();
										while (rsec.next()) {
										%>
										<option value="<%=rsec.getString("cedula_cliente")%>"><%=rsec.getString("nombre_cliente")%></option>
										<%
										}
										%>
									</select>
								</div>
								<div class="col-md-8 d-flex"></div>
							</div>
							<div class="row"></div>
						</div>
						<h5 class="card-header">Datos Producto</h5>
						<div class="card-body">
							<div class="row">
								<div class="col-md-8 d-flex form-group">
									<select name="codigoproducto" class="form-control">
										<option selected disabled>Nombre Producto</option>
										<%
										PreparedStatement ctao = cx.getConnection().prepareStatement("SELECT * FROM productos");
										ResultSet rseo = ctao.executeQuery();
										while (rseo.next()) {
										%>
										<option value="<%=rseo.getInt("codigo_producto")%>"><%=rseo.getString("nombre_producto")%></option>
										<%
										}
										%>
									</select>
								</div>
								<div class="col-md-4 d-flex form-group">
									<select name="precioproducto" class="form-control">
										<option selected disabled>Precio Producto</option>
										<%
										PreparedStatement ctap = cx.getConnection().prepareStatement("SELECT * FROM productos");
										ResultSet rsep = ctap.executeQuery();
										while (rsep.next()) {
										%>
										<option><%=rsep.getString("nombre_producto")%></option>
										<option value="<%=rsep.getDouble("precio_venta")%>"><%=rsep.getDouble("precio_venta")%></option>
										<%
										}
										%>
									</select>
								</div>
								<div class="col-md-4 d-flex form-group">
									<input type="number" value="1" name="cantidadproducto"
										class="form-control" placeholder="Cantidad">
								</div>
							</div>
							<button type="submit" name="agregar" value="AgregarProducto"
								class="btn btn-outline-primary col text-center">Agregar
								Producto</button>
							<div class="row"></div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<%
		if (request.getParameter("agregar") != null) {
			String cedulausuario = request.getParameter("cedulausuario");
			String cedulacliente = request.getParameter("cedulacliente");
			Integer codigoproducto = Integer.parseInt(request.getParameter("codigoproducto"));
			Double precioproducto = Double.parseDouble(request.getParameter("precioproducto"));
			Double cantidadproducto = Double.parseDouble(request.getParameter("cantidadproducto"));
			Double valorventa = precioproducto * cantidadproducto;
			Double ivaventa = valorventa * 0.19;
			Double totalventa = valorventa + ivaventa;
			String sqlv = "INSERT INTO ventas(cedula_usuario, cedula_cliente, valor_venta, iva_venta, total_venta) VALUES("
			+ cedulausuario + "," + cedulacliente + "," + valorventa + "," + ivaventa + "," + totalventa + ")";
			String sqld = "INSERT INTO detalle_ventas(codigo_producto, cantidad_producto, valor_venta, valor_iva, valor_total) VALUES("
			+ codigoproducto + "," + cantidadproducto + "," + valorventa + "," + ivaventa + "," + totalventa + ")";
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate(sqlv);
			st.executeUpdate(sqld);
			JOptionPane.showMessageDialog(null, "Se ha creado el registro");
		}
		%>
		<div class="col-md-7">
			<div class="card">
				<div class="card-body">
					<table class="table">
						<thead class="thead-dark">
							<tr class="encabezado">
								<th scope="col">Código Venta</th>
								<th scope="col">Cédula Usuario</th>
								<th scope="col">Cédula Cliente</th>
								<th scope="col">Valor Venta</th>
								<th scope="col">Iva Venta</th>
								<th scope="col">Total Venta</th>
							</tr>
						</thead>
						<%
						PreparedStatement ps = cx.getConnection().prepareStatement("SELECT * FROM ventas");
						ResultSet result = ps.executeQuery();
						while (result.next()) {
						%>
						<tbody id="tabla">
							<tr>
								<td id="c1"><%=result.getString("codigo_venta")%></td>
								<td id="c2"><%=result.getString("cedula_usuario")%></td>
								<td id="c3"><%=result.getString("cedula_cliente")%></td>
								<td id="c4"><%=Math.round(result.getDouble("valor_venta"))%></td>
								<td id="c5"><%=Math.round(result.getDouble("iva_venta"))%></td>
								<td id="c6"><%=Math.round(result.getDouble("total_venta"))%></td>
							</tr>
						</tbody>
						<%
						}
						%>
					</table>
				</div>
				<div class="card-footer d-flex">
					<div class="col-md-8 text-center"></div>
					<div class="col-md-4">

						<%
						PreparedStatement psv = cx.getConnection().prepareStatement("SELECT sum(total_venta) as total FROM ventas");
						ResultSet resultv = psv.executeQuery();
						if (resultv.next()) {
						%>
						<input type="text" name="txttotalapagar" disabled="disabled"
							class="form-control" placeholder="$ 000.000"
							value="<%=Math.round(resultv.getDouble("total"))%>">
						<%
						}
						%>
					</div>
				</div>
			</div>
			<div class="top-left">
				<a href="menuPrincipal.html" class="Volver"><i class="fas fa-undo-alt"></i>Volver</a>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>
</html>
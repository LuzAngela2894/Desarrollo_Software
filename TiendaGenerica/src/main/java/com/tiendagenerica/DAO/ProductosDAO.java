package com.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tiendagenerica.CONEXION.Conexion;
import com.tiendagenerica.DTO.ProductosDTO;

public class ProductosDAO {

	// listarProducto
	// crearProducto
	// consultarProducto
	// borrarProducto
	// actualizarProducto
	// '"++"'

	Conexion cx = new Conexion();
	PreparedStatement preparedStatement;

	public ArrayList<ProductosDTO> listarProducto() {
		ArrayList<ProductosDTO> miProducto = new ArrayList<ProductosDTO>();
		try {
			PreparedStatement consulta = cx.getConnection().prepareStatement("SELECT * FROM productos");
			ResultSet rs = consulta.executeQuery();
			while (rs.next()) {
				ProductosDTO producto = new ProductosDTO();
				producto.setCodigo_producto(Integer.parseInt(rs.getString("codigo_producto")));
				producto.setNombre_producto(rs.getString("nombre_producto"));
				producto.setNit_proveedor(Integer.parseInt(rs.getString("nit_proveedor")));
				producto.setPrecio_compra(Double.parseDouble(rs.getString("precio_compra")));
				producto.setIva_compra(Double.parseDouble(rs.getString("iva_compra")));
				producto.setPrecio_venta(Double.parseDouble(rs.getString("precio_venta")));
				miProducto.add(producto);
			}
			rs.close();
			consulta.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo listar los productos\n" + e);
		}
		return miProducto;
	}

	public void crearProducto(ProductosDTO producto) {
		try {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("INSERT INTO productos VALUES('" + producto.getCodigo_producto() + "','"
					+ producto.getNombre_producto() + "','" + producto.getNit_proveedor() + "','"
					+ producto.getPrecio_compra() + "','" + producto.getIva_compra() + "', '"
					+ producto.getPrecio_venta() + "')");
			st.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo crear el producto\n" + e);
		}
	}

	public ArrayList<ProductosDTO> consultarProducto(int codigo_producto) {
		ArrayList<ProductosDTO> miProducto = new ArrayList<ProductosDTO>();
		try {
			PreparedStatement consulta = cx.getConnection()
					.prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
			consulta.setInt(1, codigo_producto);
			ResultSet rs = consulta.executeQuery();
			if (rs.next()) {
				ProductosDTO producto = new ProductosDTO();
				producto.setCodigo_producto(Integer.parseInt(rs.getString("codigo_producto")));
				producto.setNombre_producto(rs.getString("nombre_producto"));
				producto.setNit_proveedor(Integer.parseInt(rs.getString("nit_proveedor")));
				producto.setPrecio_compra(Double.parseDouble(rs.getString("precio_compra")));
				producto.setIva_compra(Double.parseDouble(rs.getString("iva_compra")));
				producto.setPrecio_venta(Double.parseDouble(rs.getString("precio_venta")));
				miProducto.add(producto);
			}
			rs.close();
			consulta.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar el producto\n" + e);
		}
		return miProducto;
	}

	/*
	 * public void borrarProducto(int codigo_producto) { try { String query =
	 * "DELETE FROM productos WHERE codigo_producto=?"; preparedStatement =
	 * cx.getConnection().prepareStatement(query); preparedStatement.setInt(1,
	 * codigo_producto); preparedStatement.executeUpdate(); } catch (Exception e) {
	 * JOptionPane.showMessageDialog(null, "no se pudo borrar el producto\n" + e); }
	 * }
	 */

	public void actualizarProducto(ProductosDTO producto) {
		try {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("UPDATE productos SET codigo_producto = '" + producto.getCodigo_producto()
					+ "', nombre_producto = '" + producto.getNombre_producto() + "', nit_proveedor ='"
					+ producto.getNit_proveedor() + "', precio_compra = '" + producto.getPrecio_compra()
					+ "', iva_compra='" + producto.getIva_compra() + "', precio_venta='" + producto.getPrecio_venta()
					+ "' WHERE codigo_producto = '" + producto.getCodigo_producto() + "' ");
			st.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo actualizar el producto\n" + e);
		}
	}

}

package com.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tiendagenerica.CONEXION.Conexion;
import com.tiendagenerica.DTO.DetalleVentasDTO;

public class DetalleVentasDAO {

	// listarDetalleVenta
	// crearDetalleVenta
	// consultarDetalleVenta
	// borrarDetalleVenta
	// actualizarDetalleVenta
	// '"++"'

	Conexion cx = new Conexion();
	PreparedStatement preparedStatement;

	public ArrayList<DetalleVentasDTO> listarDetalleVenta() {
		ArrayList<DetalleVentasDTO> miVenta = new ArrayList<DetalleVentasDTO>();
		try {
			PreparedStatement consulta = cx.getConnection().prepareStatement("SELECT * FROM detalle_ventas");
			ResultSet rs = consulta.executeQuery();
			while (rs.next()) {
				DetalleVentasDTO venta = new DetalleVentasDTO();
				venta.setCodigo_detalle_venta(Integer.parseInt(rs.getString("codigo_detalle_venta")));
				venta.setCodigo_producto(Integer.parseInt(rs.getString("codigo_producto")));
				venta.setCodigo_venta(Integer.parseInt(rs.getString("codigo_venta")));
				venta.setCantidad_producto(Integer.parseInt(rs.getString("cantidad_producto")));
				venta.setValor_venta(Double.parseDouble(rs.getString("valor_venta")));
				venta.setValor_iva(Double.parseDouble(rs.getString("valor_iva")));
				venta.setValor_total(Double.parseDouble(rs.getString("valor_total")));
				miVenta.add(venta);
			}
			rs.close();
			consulta.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo listar el detalle de ventas\n" + e);
		}
		return miVenta;
	}

	public void crearDetalleVenta(DetalleVentasDTO venta) {
		try {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("INSERT INTO detalle_ventas VALUES('" + venta.getCodigo_detalle_venta() + "','"
					+ venta.getCodigo_producto() + "','" + venta.getCodigo_venta() + "','"
					+ venta.getCantidad_producto() + "','" + venta.getValor_venta() + "', '" + venta.getValor_iva()
					+ "', '" + venta.getValor_total() + "')");
			st.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo crear el detalle de venta\n" + e);
		}
	}

	public ArrayList<DetalleVentasDTO> consultarDetalleVenta(int codigo_detalle_venta) {
		ArrayList<DetalleVentasDTO> miVenta = new ArrayList<DetalleVentasDTO>();
		try {
			PreparedStatement consulta = cx.getConnection()
					.prepareStatement("SELECT * FROM detalle_ventas WHERE codigo_detalle_venta=?");
			consulta.setInt(1, codigo_detalle_venta);
			ResultSet rs = consulta.executeQuery();
			if (rs.next()) {
				DetalleVentasDTO venta = new DetalleVentasDTO();
				venta.setCodigo_detalle_venta(Integer.parseInt(rs.getString("codigo_detalle_venta")));
				venta.setCodigo_producto(Integer.parseInt(rs.getString("codigo_producto")));
				venta.setCodigo_venta(Integer.parseInt(rs.getString("codigo_venta")));
				venta.setCantidad_producto(Integer.parseInt(rs.getString("cantidad_producto")));
				venta.setValor_venta(Double.parseDouble(rs.getString("valor_venta")));
				venta.setValor_iva(Double.parseDouble(rs.getString("valor_iva")));
				venta.setValor_total(Double.parseDouble(rs.getString("valor_total")));
				miVenta.add(venta);
			}
			rs.close();
			consulta.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar el detalle de venta\n" + e);
		}
		return miVenta;
	}

	public void borrarDetalleVenta(int codigo_detalle_venta) {
		try {
			String query = "DELETE FROM detalle_ventas WHERE codigo_detalle_venta=?";
			preparedStatement = cx.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, codigo_detalle_venta);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo borrar el detalle de venta\n" + e);
		}
	}

	public void actualizarDetalleVenta(DetalleVentasDTO venta) {
		try {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("UPDATE detalle_ventas SET codigo_detalle_venta = '" + venta.getCodigo_detalle_venta()
					+ "', codigo_producto = '" + venta.getCodigo_producto() + "', codigo_venta ='"
					+ venta.getCodigo_venta() + "', cantidad_producto = '" + venta.getCantidad_producto()
					+ "', valor_venta = '" + venta.getValor_venta() + "', valor_iva = '" + venta.getValor_iva()
					+ "', valor_total = '" + venta.getValor_total() + "' WHERE codigo_detalle_venta = '"
					+ venta.getCodigo_detalle_venta() + "' ");
			st.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo actualizar el detalle de venta\n" + e);
		}
	}

}

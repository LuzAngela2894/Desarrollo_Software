package com.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tiendagenerica.CONEXION.Conexion;
import com.tiendagenerica.DTO.VentasDTO;

public class VentasDAO {

	// listarVenta
	// crearVenta
	// consultarVenta
	// borrarVenta
	// actualizarVenta
	// '"++"'

	Conexion cx = new Conexion();
	PreparedStatement preparedStatement;

	public ArrayList<VentasDTO> listarVenta() {
		ArrayList<VentasDTO> miVenta = new ArrayList<VentasDTO>();
		try {
			PreparedStatement consulta = cx.getConnection().prepareStatement("SELECT * FROM ventas");
			ResultSet rs = consulta.executeQuery();
			while (rs.next()) {
				VentasDTO venta = new VentasDTO();
				venta.setCodigo_venta(Integer.parseInt(rs.getString("codigo_venta")));
				venta.setCedula_usuario(Integer.parseInt(rs.getString("cedula_usuario")));
				venta.setCedula_cliente(Integer.parseInt(rs.getString("cedula_cliente")));
				venta.setValor_venta(Double.parseDouble(rs.getString("valor_venta")));
				venta.setIva_venta(Double.parseDouble(rs.getString("iva_venta")));
				venta.setIva_venta(Double.parseDouble(rs.getString("total_venta")));
				miVenta.add(venta);
			}
			rs.close();
			consulta.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo listar las ventas\n" + e);
		}
		return miVenta;
	}

	public void crearVenta(VentasDTO venta) {
		try {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("INSERT INTO ventas VALUES('" + venta.getCodigo_venta() + "','" + venta.getCedula_usuario()
					+ "','" + venta.getCedula_cliente() + "','" + venta.getValor_venta() + "','" + venta.getIva_venta()
					+ "', '" + venta.getTotal_venta() + "')");
			st.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo crear la venta\n" + e);
		}
	}

	public ArrayList<VentasDTO> consultarVenta(int codigo_venta) {
		ArrayList<VentasDTO> miVenta = new ArrayList<VentasDTO>();
		try {
			PreparedStatement consulta = cx.getConnection()
					.prepareStatement("SELECT * FROM ventas WHERE codigo_venta=?");
			consulta.setInt(1, codigo_venta);
			ResultSet rs = consulta.executeQuery();
			if (rs.next()) {
				VentasDTO venta = new VentasDTO();
				venta.setCodigo_venta(Integer.parseInt(rs.getString("codigo_venta")));
				venta.setCedula_usuario(Integer.parseInt(rs.getString("cedula_usuario")));
				venta.setCedula_cliente(Integer.parseInt(rs.getString("cedula_cliente")));
				venta.setValor_venta(Double.parseDouble(rs.getString("valor_venta")));
				venta.setIva_venta(Double.parseDouble(rs.getString("iva_venta")));
				venta.setIva_venta(Double.parseDouble(rs.getString("total_venta")));
				miVenta.add(venta);
			}
			rs.close();
			consulta.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar la venta\n" + e);
		}
		return miVenta;
	}

	public void borrarVenta(int codigo_venta) {
		try {
			String query = "DELETE FROM ventas WHERE codigo_venta=?";
			preparedStatement = cx.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, codigo_venta);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo borrar la venta\n" + e);
		}
	}

	public void actualizarVenta(VentasDTO venta) {
		try {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("UPDATE ventas SET codigo_venta = '" + venta.getCodigo_venta() + "', cedula_usuario = '"
					+ venta.getCedula_usuario() + "', cedula_cliente ='" + venta.getCedula_cliente()
					+ "', valor_venta = '" + venta.getValor_venta() + "', iva_venta='" + venta.getIva_venta()
					+ "', total_venta='" + venta.getTotal_venta() + "' WHERE codigo_venta = '" + venta.getCodigo_venta()
					+ "' ");
			st.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo actualizar la venta\n" + e);
		}
	}

}

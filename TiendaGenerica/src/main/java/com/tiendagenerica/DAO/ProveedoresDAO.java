package com.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tiendagenerica.CONEXION.Conexion;
import com.tiendagenerica.DTO.ProveedoresDTO;

public class ProveedoresDAO {

	// listarProveedor
	// crearProveedor
	// consultarProveedor
	// borrarProveedor
	// actualizarProveedor
	// '"++"'

	Conexion cx = new Conexion();
	PreparedStatement preparedStatement;

	public ArrayList<ProveedoresDTO> listarProveedor() {
		ArrayList<ProveedoresDTO> miProveedor = new ArrayList<ProveedoresDTO>();
		try {
			PreparedStatement consulta = cx.getConnection().prepareStatement("SELECT * FROM proveedores");
			ResultSet rs = consulta.executeQuery();
			while (rs.next()) {
				ProveedoresDTO proveedor = new ProveedoresDTO();
				proveedor.setNit_proveedor(Integer.parseInt(rs.getString("nit_proveedor")));
				proveedor.setNombre_proveedor(rs.getString("nombre_proveedor"));
				proveedor.setDireccion_proveedor(rs.getString("direccion_proveedor"));
				proveedor.setTelefono_proveedor(rs.getString("telefono_proveedor"));
				proveedor.setCiudad_proveedor(rs.getString("ciudad_proveedor"));
				miProveedor.add(proveedor);
			}
			rs.close();
			consulta.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo listar los proveedores\n" + e);
		}
		return miProveedor;
	}

	public void crearProveedor(ProveedoresDTO proveedor) {
		try {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("INSERT INTO proveedores VALUES('" + proveedor.getNit_proveedor() + "','"
					+ proveedor.getNombre_proveedor() + "','" + proveedor.getDireccion_proveedor() + "','"
					+ proveedor.getTelefono_proveedor() + "','" + proveedor.getCiudad_proveedor() + "')");
			st.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo crear el proveedor\n" + e);
		}
	}

	public ArrayList<ProveedoresDTO> consultarProveedor(int nit_proveedor) {
		ArrayList<ProveedoresDTO> miProveedor = new ArrayList<ProveedoresDTO>();
		try {
			PreparedStatement consulta = cx.getConnection()
					.prepareStatement("SELECT * FROM proveedores WHERE nit_proveedor=?");
			consulta.setInt(1, nit_proveedor);
			ResultSet rs = consulta.executeQuery();
			if (rs.next()) {
				ProveedoresDTO proveedor = new ProveedoresDTO();
				proveedor.setNit_proveedor(Integer.parseInt(rs.getString("nit_proveedor")));
				proveedor.setNombre_proveedor(rs.getString("nombre_proveedor"));
				proveedor.setDireccion_proveedor(rs.getString("direccion_proveedor"));
				proveedor.setTelefono_proveedor(rs.getString("telefono_proveedor"));
				proveedor.setCiudad_proveedor(rs.getString("ciudad_proveedor"));
				miProveedor.add(proveedor);
			}
			rs.close();
			consulta.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar el proveedor\n" + e);
		}
		return miProveedor;
	}

	public void borrarProveedor(int nit_proveedor) {
		try {
			String query = "DELETE FROM proveedores WHERE nit_proveedor=?";
			preparedStatement = cx.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, nit_proveedor);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo borrar el proveedor\n" + e);
		}
	}

	public void actualizarProveedor(ProveedoresDTO proveedor) {
		try {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("UPDATE proveedores SET nit_proveedor = '" + proveedor.getNit_proveedor()
					+ "', nombre_proveedor = '" + proveedor.getNombre_proveedor() + "', direccion_proveedor ='"
					+ proveedor.getDireccion_proveedor() + "', telefono_proveedor = '"
					+ proveedor.getTelefono_proveedor() + "', ciudad_proveedor ='" + proveedor.getCiudad_proveedor()
					+ "' WHERE nit_proveedor = '" + proveedor.getNit_proveedor() + "' ");
			st.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo actualizar el proveedor\n" + e);
		}
	}

}

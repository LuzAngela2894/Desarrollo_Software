package com.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tiendagenerica.CONEXION.Conexion;
import com.tiendagenerica.DTO.ClientesDTO;

public class ClientesDAO {

	// listarCliente
	// crearCliente
	// consultarCliente
	// borrarCliente
	// actualizarCliente
	// '"++"'
	
	Conexion cx = new Conexion();
	PreparedStatement preparedStatement;

	public ArrayList<ClientesDTO> listarCliente() {
		ArrayList<ClientesDTO> miCliente = new ArrayList<ClientesDTO>();
		try {
			PreparedStatement consulta = cx.getConnection().prepareStatement("SELECT * FROM clientes");
			ResultSet rs = consulta.executeQuery();
			while (rs.next()) {
				ClientesDTO cliente = new ClientesDTO();
				cliente.setCedula_cliente(Integer.parseInt(rs.getString("cedula_cliente")));
				cliente.setNombre_cliente(rs.getString("nombre_cliente"));
				cliente.setDireccion_cliente(rs.getString("direccion_cliente"));
				cliente.setTelefono_cliente(rs.getString("telefono_cliente"));
				cliente.setEmail_cliente(rs.getString("email_cliente"));
				miCliente.add(cliente);
			}
			rs.close();
			consulta.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo listar a los clientes\n" + e);
		}
		return miCliente;
	}

	public void crearCliente(ClientesDTO cliente) {
		try {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("INSERT INTO clientes VALUES('" + cliente.getCedula_cliente() + "','"
					+ cliente.getNombre_cliente() + "','" + cliente.getDireccion_cliente() + "','"
					+ cliente.getTelefono_cliente() + "','" + cliente.getEmail_cliente() + "')");
			st.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo crear el cliente\n" + e);
		}
	}

	public ArrayList<ClientesDTO> consultarCliente(int cedula_cliente) {
		ArrayList<ClientesDTO> miCliente = new ArrayList<ClientesDTO>();
		try {
			PreparedStatement consulta = cx.getConnection()
					.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente=?");
			consulta.setInt(1, cedula_cliente);
			ResultSet rs = consulta.executeQuery();
			if (rs.next()) {
				ClientesDTO cliente = new ClientesDTO();
				cliente.setCedula_cliente(Integer.parseInt(rs.getString("cedula_cliente")));
				cliente.setNombre_cliente(rs.getString("nombre_cliente"));
				cliente.setDireccion_cliente(rs.getString("direccion_cliente"));
				cliente.setTelefono_cliente(rs.getString("telefono_cliente"));
				cliente.setEmail_cliente(rs.getString("email_cliente"));
				miCliente.add(cliente);
			}
			rs.close();
			consulta.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar el cliente\n" + e);
		}
		return miCliente;
	}

	public void borrarCliente(int cedula_cliente) {
		try {
			String query = "DELETE FROM clientes WHERE cedula_cliente=?";
			preparedStatement = cx.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, cedula_cliente);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo borrar el cliente\n" + e);
		}
	}

	public void actualizarCliente(ClientesDTO cliente) {
		try {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("UPDATE clientes SET cedula_cliente = '" + cliente.getCedula_cliente()
					+ "', nombre_cliente = '" + cliente.getNombre_cliente() + "', direccion_cliente = '"
					+ cliente.getDireccion_cliente() + "', telefono_cliente ='" + cliente.getTelefono_cliente()
					+ "', email_cliente = '" + cliente.getEmail_cliente() + "' WHERE cedula_cliente = '"
					+ cliente.getCedula_cliente() + "' ");
			st.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo actualizar el cliente\n" + e);
		}
	}

}

package com.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tiendagenerica.CONEXION.Conexion;
import com.tiendagenerica.DTO.UsuariosDTO;

public class UsuariosDAO {

	// listarUsuario
	// crearUsuario
	// consultarUsuario
	// borrarUsuario
	// actualizarUsuario
	// '"++"'

	Conexion cx = new Conexion();
	PreparedStatement preparedStatement;

	public ArrayList<UsuariosDTO> listarUsuario() {
		ArrayList<UsuariosDTO> miUsuario = new ArrayList<UsuariosDTO>();
		try {
			PreparedStatement consulta = cx.getConnection().prepareStatement("SELECT * FROM usuarios");
			ResultSet rs = consulta.executeQuery();
			while (rs.next()) {
				UsuariosDTO usuario = new UsuariosDTO();
				usuario.setCedula_usuario(Integer.parseInt(rs.getString("cedula_usuario")));
				usuario.setNombre_usuario(rs.getString("nombre_usuario"));
				usuario.setEmail_usuario(rs.getString("email_usuario"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setContrasena(rs.getString("contrasena"));
				usuario.setRol(rs.getString("rol"));
				miUsuario.add(usuario);
			}
			rs.close();
			consulta.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo listar los usuarios\n" + e);
		}
		return miUsuario;
	}

	public void crearUsuario(UsuariosDTO usuario) {
		try {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("INSERT INTO usuarios VALUES('" + usuario.getCedula_usuario() + "','"
					+ usuario.getNombre_usuario() + "','" + usuario.getEmail_usuario() + "','" + usuario.getUsuario()
					+ "','" + usuario.getContrasena() + "','" + usuario.getRol() + "')");
			st.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo crear el usuario\n" + e);
		}
	}

	public ArrayList<UsuariosDTO> consultarUsuario(int cedula_usuario) {
		ArrayList<UsuariosDTO> miUsuario = new ArrayList<UsuariosDTO>();
		try {
			PreparedStatement consulta = cx.getConnection()
					.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
			consulta.setInt(1, cedula_usuario);
			ResultSet rs = consulta.executeQuery();
			if (rs.next()) {
				UsuariosDTO usuario = new UsuariosDTO();
				usuario.setCedula_usuario(Integer.parseInt(rs.getString("cedula_usuario")));
				usuario.setNombre_usuario(rs.getString("nombre_usuario"));
				usuario.setEmail_usuario(rs.getString("email_usuario"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setContrasena(rs.getString("contrasena"));
				usuario.setRol(rs.getString("rol"));
				miUsuario.add(usuario);
			}
			rs.close();
			consulta.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar el usuario\n" + e);
		}
		return miUsuario;
	}

	public void borrarUsuario(int cedula_usuario) {
		try {
			String query = "DELETE FROM usuarios WHERE cedula_usuario=?";
			preparedStatement = cx.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, cedula_usuario);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo borrar el usuario\n" + e);
		}
	}

	public void actualizarUsuario(UsuariosDTO usuario) {
		try {
			Statement st = cx.getConnection().createStatement();
			st.executeUpdate("UPDATE usuarios SET cedula_usuario = '" + usuario.getCedula_usuario()
					+ "', nombre_usuario = '" + usuario.getNombre_usuario() + "', email_usuario ='"
					+ usuario.getEmail_usuario() + "', usuario = '" + usuario.getUsuario() + "', contrasena ='"
					+ usuario.getContrasena() + "', rol = '" + usuario.getRol() + "' WHERE cedula_usuario = '"
					+ usuario.getCedula_usuario() + "' ");
			st.close();
			cx.closeConnection();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo actualizar el usuario\n" + e);
		}
	}

}

package com.tiendagenerica.CONTROLLERS;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendagenerica.DAO.UsuariosDAO;
import com.tiendagenerica.DTO.UsuariosDTO;

@RestController
public class UsuariosController {

	@RequestMapping("/listarUsuario")
	public ArrayList<UsuariosDTO> listarUsuario() {
		UsuariosDAO dao = new UsuariosDAO();
		return dao.listarUsuario();
	}

	@RequestMapping("/crearUsuario")
	public void crearUsuario(UsuariosDTO usuario) {
		UsuariosDAO dao = new UsuariosDAO();
		dao.crearUsuario(usuario);
	}

	@RequestMapping("/consultarUsuario")
	public ArrayList<UsuariosDTO> consultarUsuario(int cedula_usuario) {
		UsuariosDAO dao = new UsuariosDAO();
		return dao.consultarUsuario(cedula_usuario);
	}

	@RequestMapping("/borrarUsuario")
	public void borrarUsuario(int cedula_usuario) {
		UsuariosDAO dao = new UsuariosDAO();
		dao.borrarUsuario(cedula_usuario);
	}

	@RequestMapping("/actualizarUsuario")
	public void actualizarUsuario(UsuariosDTO usuario) {
		UsuariosDAO dao = new UsuariosDAO();
		dao.actualizarUsuario(usuario);
	}

}

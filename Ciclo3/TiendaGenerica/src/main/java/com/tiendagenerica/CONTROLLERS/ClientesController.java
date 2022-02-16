package com.tiendagenerica.CONTROLLERS;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendagenerica.DAO.ClientesDAO;
import com.tiendagenerica.DTO.ClientesDTO;

@RestController
public class ClientesController {

	@RequestMapping("/listarCliente")
	public ArrayList<ClientesDTO> listarCliente() {
		ClientesDAO dao = new ClientesDAO();
		return dao.listarCliente();
	}

	@RequestMapping("/crearCliente")
	public void crearCliente(ClientesDTO cliente) {
		ClientesDAO dao = new ClientesDAO();
		dao.crearCliente(cliente);
	}

	@RequestMapping("/consultarCliente")
	public ArrayList<ClientesDTO> consultarCliente(int cedula_cliente) {
		ClientesDAO dao = new ClientesDAO();
		return dao.consultarCliente(cedula_cliente);
	}

	@RequestMapping("/borrarCliente")
	public void borrarCliente(int cedula_cliente) {
		ClientesDAO dao = new ClientesDAO();
		dao.borrarCliente(cedula_cliente);
	}

	@RequestMapping("/actualizarCliente")
	public void actualizarCliente(ClientesDTO cliente) {
		ClientesDAO dao = new ClientesDAO();
		dao.actualizarCliente(cliente);
	}
	
}

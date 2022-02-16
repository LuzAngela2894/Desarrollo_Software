package com.tiendagenerica.CONTROLLERS;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendagenerica.DAO.ProveedoresDAO;
import com.tiendagenerica.DTO.ProveedoresDTO;

@RestController
public class ProveedoresController {

	@RequestMapping("/listarProveedor")
	public ArrayList<ProveedoresDTO> listarProveedor() {
		ProveedoresDAO dao = new ProveedoresDAO();
		return dao.listarProveedor();
	}

	@RequestMapping("/crearProveedor")
	public void crearProveedor(ProveedoresDTO proveedor) {
		ProveedoresDAO dao = new ProveedoresDAO();
		dao.crearProveedor(proveedor);
	}

	@RequestMapping("/consultarProveedor")
	public ArrayList<ProveedoresDTO> consultarProveedor(int nit_proveedor) {
		ProveedoresDAO dao = new ProveedoresDAO();
		return dao.consultarProveedor(nit_proveedor);
	}

	@RequestMapping("/borrarProveedor")
	public void borrarProveedor(int nit_proveedor) {
		ProveedoresDAO dao = new ProveedoresDAO();
		dao.borrarProveedor(nit_proveedor);
	}

	@RequestMapping("/actualizarProveedor")
	public void actualizarProveedor(ProveedoresDTO proveedor) {
		ProveedoresDAO dao = new ProveedoresDAO();
		dao.actualizarProveedor(proveedor);
	}

}

package com.tiendagenerica.CONTROLLERS;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendagenerica.DAO.VentasDAO;
import com.tiendagenerica.DTO.VentasDTO;

@RestController
public class VentasController {

	@RequestMapping("/listarVenta")
	public ArrayList<VentasDTO> listarVenta() {
		VentasDAO dao = new VentasDAO();
		return dao.listarVenta();
	}

	@RequestMapping("/crearVenta")
	public void crearVenta(VentasDTO venta) {
		VentasDAO dao = new VentasDAO();
		dao.crearVenta(venta);
	}

	@RequestMapping("/consultarVenta")
	public ArrayList<VentasDTO> consultarVenta(int codigo_venta) {
		VentasDAO dao = new VentasDAO();
		return dao.consultarVenta(codigo_venta);
	}

	@RequestMapping("/borrarVenta")
	public void borrarVenta(int codigo_venta) {
		VentasDAO dao = new VentasDAO();
		dao.borrarVenta(codigo_venta);
	}

	@RequestMapping("/actualizarVenta")
	public void actualizarVenta(VentasDTO venta) {
		VentasDAO dao = new VentasDAO();
		dao.actualizarVenta(venta);
	}

}

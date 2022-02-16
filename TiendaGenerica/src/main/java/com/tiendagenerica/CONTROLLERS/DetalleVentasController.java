package com.tiendagenerica.CONTROLLERS;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendagenerica.DAO.DetalleVentasDAO;
import com.tiendagenerica.DTO.DetalleVentasDTO;

@RestController
public class DetalleVentasController {

	@RequestMapping("/listarDetalleVenta")
	public ArrayList<DetalleVentasDTO> listarDetalleVenta() {
		DetalleVentasDAO dao = new DetalleVentasDAO();
		return dao.listarDetalleVenta();
	}

	@RequestMapping("/crearDetalleVenta")
	public void crearDetalleVenta(DetalleVentasDTO venta) {
		DetalleVentasDAO dao = new DetalleVentasDAO();
		dao.crearDetalleVenta(venta);
	}

	@RequestMapping("/consultarDetalleVenta")
	public ArrayList<DetalleVentasDTO> consultarDetalleVenta(int codigo_detalle_venta) {
		DetalleVentasDAO dao = new DetalleVentasDAO();
		return dao.consultarDetalleVenta(codigo_detalle_venta);
	}

	@RequestMapping("/borrarDetalleVenta")
	public void borrarDetalleVenta(int codigo_detalle_venta) {
		DetalleVentasDAO dao = new DetalleVentasDAO();
		dao.borrarDetalleVenta(codigo_detalle_venta);
	}

	@RequestMapping("/actualizarDetalleVenta")
	public void actualizarDetalleVenta(DetalleVentasDTO venta) {
		DetalleVentasDAO dao = new DetalleVentasDAO();
		dao.actualizarDetalleVenta(venta);
	}

}

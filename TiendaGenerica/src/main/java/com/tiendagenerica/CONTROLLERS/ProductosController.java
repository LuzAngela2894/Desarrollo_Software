package com.tiendagenerica.CONTROLLERS;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendagenerica.DAO.ProductosDAO;
import com.tiendagenerica.DTO.ProductosDTO;

@RestController
public class ProductosController {

	@RequestMapping("/listarProducto")
	public ArrayList<ProductosDTO> listarProducto() {
		ProductosDAO dao = new ProductosDAO();
		return dao.listarProducto();
	}

	@RequestMapping("/crearProducto")
	public void crearProducto(ProductosDTO producto) {
		ProductosDAO dao = new ProductosDAO();
		dao.crearProducto(producto);
	}

	@RequestMapping("/consultarProducto")
	public ArrayList<ProductosDTO> consultarProducto(int codigo_producto) {
		ProductosDAO dao = new ProductosDAO();
		return dao.consultarProducto(codigo_producto);
	}

	/*
	 * @RequestMapping("/borrarProducto") public void borrarProducto(int
	 * codigo_producto) { dao.borrarProducto(codigo_producto); }
	 */

	@RequestMapping("/actualizarProducto")
	public void actualizarProducto(ProductosDTO producto) {
		ProductosDAO dao = new ProductosDAO();
		dao.actualizarProducto(producto);
	}

}

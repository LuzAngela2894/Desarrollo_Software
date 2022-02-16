package com.tiendagenerica.DTO;

import java.util.Objects;

public class ProveedoresDTO {

	private Integer nit_proveedor;
	private String nombre_proveedor;
	private String direccion_proveedor;
	private String telefono_proveedor;
	private String ciudad_proveedor;

	/*
	 * public ProveedoresDTO(int nit_proveedor, String nombre_proveedor, String
	 * direccion_proveedor, String telefono_proveedor, String ciudad_proveedor) {
	 * super(); this.nit_proveedor = nit_proveedor; this.nombre_proveedor =
	 * nombre_proveedor; this.direccion_proveedor = direccion_proveedor;
	 * this.telefono_proveedor = telefono_proveedor; this.ciudad_proveedor =
	 * ciudad_proveedor; }
	 */

	public Integer getNit_proveedor() {
		return nit_proveedor;
	}

	public void setNit_proveedor(Integer nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}

	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}

	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}

	public void setTelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}

	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}

	public void setCiudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciudad_proveedor, direccion_proveedor, nit_proveedor, nombre_proveedor, telefono_proveedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProveedoresDTO other = (ProveedoresDTO) obj;
		return Objects.equals(ciudad_proveedor, other.ciudad_proveedor)
				&& Objects.equals(direccion_proveedor, other.direccion_proveedor)
				&& Objects.equals(nit_proveedor, other.nit_proveedor)
				&& Objects.equals(nombre_proveedor, other.nombre_proveedor)
				&& Objects.equals(telefono_proveedor, other.telefono_proveedor);
	}

}

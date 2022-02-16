package com.tiendagenerica.DTO;

import java.util.Objects;

public class DetalleVentasDTO {

	private Integer codigo_detalle_venta;
	private Integer codigo_producto;
	private Integer codigo_venta;
	private Integer cantidad_producto;
	private Double valor_venta;
	private Double valor_iva;
	private Double valor_total;

	/*
	 * public DetalleVentasDTO(Integer codigo_detalle_venta, Integer
	 * codigo_producto, Integer codigo_venta, Integer cantidad_producto, Double
	 * valor_venta, Double valor_iva, Double valor_total) { super();
	 * this.codigo_detalle_venta = codigo_detalle_venta; this.codigo_producto =
	 * codigo_producto; this.codigo_venta = codigo_venta; this.cantidad_producto =
	 * cantidad_producto; this.valor_venta = valor_venta; this.valor_iva =
	 * valor_iva; this.valor_total = valor_total; }
	 */

	public Integer getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}

	public void setCodigo_detalle_venta(Integer codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}

	public Integer getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Integer codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Integer getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(Integer codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public Integer getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(Integer cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public Double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public Double getValor_iva() {
		return valor_iva;
	}

	public void setValor_iva(Double valor_iva) {
		this.valor_iva = valor_iva;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad_producto, codigo_detalle_venta, codigo_producto, codigo_venta, valor_iva,
				valor_total, valor_venta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleVentasDTO other = (DetalleVentasDTO) obj;
		return Objects.equals(cantidad_producto, other.cantidad_producto)
				&& Objects.equals(codigo_detalle_venta, other.codigo_detalle_venta)
				&& Objects.equals(codigo_producto, other.codigo_producto)
				&& Objects.equals(codigo_venta, other.codigo_venta) && Objects.equals(valor_iva, other.valor_iva)
				&& Objects.equals(valor_total, other.valor_total) && Objects.equals(valor_venta, other.valor_venta);
	}

}

package com.curso.sesion.modelo;

public class Detalle {

	private String producto;
	private int cantidad;

	public Detalle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Detalle(String producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Detalle [producto=" + producto + ", cantidad=" + cantidad + "]";
	}

}

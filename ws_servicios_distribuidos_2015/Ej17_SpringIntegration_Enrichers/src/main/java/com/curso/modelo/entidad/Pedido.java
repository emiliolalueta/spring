package com.curso.modelo.entidad;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Pedido {

	private String cliente;
	private String destino;
	private String producto;
	private int cantidad;
	private int precio;

	@XmlTransient
	private int total;
	@XmlTransient
	private boolean enviado;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(String cliente, String destino, String producto,
			int cantidad, int precio, int total, boolean enviado) {
		super();
		this.cliente = cliente;
		this.destino = destino;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
		this.enviado = enviado;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isEnviado() {
		return enviado;
	}

	public void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}

	@Override
	public String toString() {
		return "Pedido [cliente=" + cliente + ", destino=" + destino
				+ ", producto=" + producto + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", total=" + total + ", enviado="
				+ enviado + "]";
	}

}

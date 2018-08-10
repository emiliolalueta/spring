package com.curso.modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalles_pedido")
public class DetallePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double precio;
	private Integer cantidad;

	@ManyToOne
	@JoinColumn(name = "fk_id_pedido", referencedColumnName = "id")
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name = "fk_id_producto", referencedColumnName = "id")
	private Producto producto;

	public DetallePedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetallePedido(Integer id, Double precio, Integer cantidad,
			Pedido pedido, Producto producto) {
		super();
		this.id = id;
		this.precio = precio;
		this.cantidad = cantidad;
		this.pedido = pedido;
		this.producto = producto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "DetallePedido [id=" + id + ", precio=" + precio + ", cantidad="
				+ cantidad + ", pedido=" + pedido + ", producto=" + producto
				+ "]";
	}
	
}

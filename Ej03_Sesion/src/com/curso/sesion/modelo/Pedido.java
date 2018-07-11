package com.curso.sesion.modelo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

//Para el ejemplo 2
//@Component(value="pedidoEnSesion")
//@Scope("session")

//Para el ejemplo 4
//@Component("pedidoProxy")
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, 
//       value     = "session")
public class Pedido {

	private String codigo;
	private List<Detalle> detalles = new ArrayList<Detalle>();

	public Pedido() {
		super();
		System.out.println("CREANDO PEDIDO");
		// TODO Auto-generated constructor stub
	}

	public Pedido(String codigo, List<Detalle> detalles) {
		super();
		this.codigo = codigo;
		this.detalles = detalles;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

}

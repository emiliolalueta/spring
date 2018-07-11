package com.curso.sesion.controlador;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.curso.sesion.modelo.Detalle;
import com.curso.sesion.modelo.Pedido;

@Controller
@Scope("session")
public class Controlador3 {

	private Pedido pedido = new Pedido();

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@RequestMapping("mostrarPagina3")
	public ModelAndView mostrarPagina() {
		ModelAndView mav = new ModelAndView("pagina3");
		mav.addObject("detalle", new Detalle());
		return mav;
	}

	@RequestMapping("addProducto3")
	public ModelAndView addDetalle(@ModelAttribute(value = "detalle") Detalle detalle) {

		pedido.getDetalles().add(detalle);

		ModelAndView mav = new ModelAndView("pagina3");
		mav.addObject("detalle", new Detalle());
		return mav;
	}

}

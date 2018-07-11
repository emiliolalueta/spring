package com.curso.sesion.controlador;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.curso.sesion.modelo.Detalle;
import com.curso.sesion.modelo.Pedido;

@Controller
//Singleton
public class Controlador4 {

	@Autowired
	@Qualifier("pedidoProxy")
	private Pedido pedido;

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@ModelAttribute(value="pedidoProxy")
	public Pedido getPedido() {
		return pedido;
	}		
	
	@RequestMapping("mostrarPagina4")
	public ModelAndView mostrarPagina() {
		ModelAndView mav = new ModelAndView("pagina4");
		mav.addObject("detalle", new Detalle());
		return mav;
	}

	@RequestMapping("addProducto4")
	public ModelAndView addDetalle(@ModelAttribute(value = "detalle") Detalle detalle) {

		pedido.getDetalles().add(detalle);		

		System.out.println(pedido.getDetalles());
		
		ModelAndView mav = new ModelAndView("pagina4");
		mav.addObject("detalle", new Detalle());
		return mav;
	}

	
}

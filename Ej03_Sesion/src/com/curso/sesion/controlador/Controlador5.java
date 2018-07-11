package com.curso.sesion.controlador;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.curso.sesion.modelo.Detalle;
import com.curso.sesion.modelo.Pedido;

@Controller
//Singletón
@SessionAttributes("pedidoSesion5")
public class Controlador5 {

	@ModelAttribute("pedidoSesion5")                                                           
	public Pedido getPedido() {
		return new Pedido();
	}		
	
	@RequestMapping("mostrarPagina5")
	public ModelAndView mostrarPagina() {
		ModelAndView mav = new ModelAndView("pagina5");
		mav.addObject("detalle", new Detalle());
		return mav;
	}

	@RequestMapping("addProducto5")
	public ModelAndView addDetalle(
			@ModelAttribute(value = "pedidoSesion5") Pedido pedido,
			@ModelAttribute(value = "detalle") Detalle detalle) {

		pedido.getDetalles().add(detalle);		

		System.out.println(pedido.getDetalles());
		
		ModelAndView mav = new ModelAndView("pagina5");
		mav.addObject("detalle", new Detalle());
		return mav;
	}

	@RequestMapping("finalizar5")
	public ModelAndView finalizar(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return new ModelAndView("redirect:inicio.html");
	}
	
}










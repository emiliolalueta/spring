package com.curso.sesion.controlador;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.curso.sesion.modelo.Detalle;
import com.curso.sesion.modelo.Pedido;

@Controller
public class Controlador1 {

	@RequestMapping("mostrarPagina1")
	public ModelAndView mostrarPagina(){
		ModelAndView mav = new ModelAndView("pagina1");
		mav.addObject("detalle", new Detalle());
		return mav;
	}
	
	@RequestMapping("addProducto1")
	public ModelAndView addDetalle(HttpSession sesion, @ModelAttribute(value="detalle") Detalle detalle){
		Pedido p = (Pedido) sesion.getAttribute("pedidoSesion1");
		if(p==null){
			p = new Pedido();
			sesion.setAttribute("pedidoSesion1", p);
		}
		p.getDetalles().add(detalle);
		
		ModelAndView mav = new ModelAndView("pagina1");
		mav.addObject("detalle", new Detalle());
		return mav;
	}
	
}










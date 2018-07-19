package expedientesx.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import expedientesx.modelo.Expediente;
import expedientesx.negocio.ServicioGestionExpendientes;

@Controller
public class ControlExpedientes {
	@Autowired 
	private ServicioGestionExpendientes gestionExpendientes;
	
	@RequestMapping("/mostrar/todos")
	public ModelAndView mostrarTodos() {
		System.out.println("Peticion Mostrar Expedientes Recibida");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("vistaExpedientes");
		mav.addObject("expedientes", gestionExpendientes.mostrarTodos());
		return mav;
	}
	
	@RequestMapping("/mostrar/{id}")
	public ModelAndView mostrar(@PathVariable Long id) {
		System.out.println("Peticion Mostrar Expediente Recibida");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("vistaExpediente");
		mav.addObject("expediente", gestionExpendientes.mostrar(id));
		return mav;
	}
	
	@RequestMapping(value="/clasificar")
	public String clasificar( @RequestParam("id") Long id, Model model){
		System.out.println("Clasificar el expediente: "+id);
		Expediente expediente = gestionExpendientes.mostrar(id);
		gestionExpendientes.clasificar(expediente);
		return "redirect:/expedientesx/mostrar/todos";
	}
	
	@RequestMapping(value="/desclasificar")
	public String desclasificar( @RequestParam("id") Long id, Model model){
		System.out.println("Desclasificar el expediente: "+id);
		Expediente expediente = gestionExpendientes.mostrar(id);
		gestionExpendientes.desclasificar(expediente);
		return "redirect:/expedientesx/mostrar/todos";
	}

}

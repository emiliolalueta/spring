import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.negocio.SaludadorRemote;


public class Pruebas {

	public static void main(String[] args) {
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("==========================================");				
		
		SaludadorRemote saludador = (SaludadorRemote) appCtx.getBean("saludador");
		System.out.println(saludador.saludar("Luis Ramón"));	
		
	}
	
}

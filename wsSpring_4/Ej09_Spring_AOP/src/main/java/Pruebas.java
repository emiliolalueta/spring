import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;

public class Pruebas {

	public static void main(String[] args) {
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/curso/cfg/beans.xml");
		
		GestorClientes gc = (GestorClientes) appCtx.getBean("gestorClientes");
		
		Cliente c = new Cliente("Bart");
		gc.insertar(c);
		gc.borrar(c);
		
	}
	
}

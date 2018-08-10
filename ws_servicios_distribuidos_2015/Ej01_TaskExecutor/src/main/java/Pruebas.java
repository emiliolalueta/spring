import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.EjecutorDeTareas;


public class Pruebas {

	public static void main(String[] args) {
		
		ApplicationContext appCtx = 
			new ClassPathXmlApplicationContext("beans.xml");
		
		EjecutorDeTareas et = (EjecutorDeTareas) appCtx.getBean("ejecutorDeTareas");
		et.lanzarTareas();
		System.out.println("Fin en main");	
		
	}
	
}

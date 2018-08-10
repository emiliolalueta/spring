import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//Pruebas de TaskScheduler con configuracion XM
public class PruebasAnotaciones {

	public static void main(String[] args) {		
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("beansAnotaciones.xml");
		System.out.println("====================================");
		
	}
	
	
}

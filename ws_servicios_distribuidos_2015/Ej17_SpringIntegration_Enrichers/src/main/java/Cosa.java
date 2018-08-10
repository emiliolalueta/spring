import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.curso.modelo.entidad.Pedido;


public class Cosa {

	public static void main(String[] args) {
		
		 try {
			 
				File file = new File("E:\\inboundPedidos\\pedido1.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Pedido.class);
		 
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Pedido customer = (Pedido) jaxbUnmarshaller.unmarshal(file);
				System.out.println(customer);
		 
			  } catch (JAXBException e) {
				e.printStackTrace();
			  }		
		
		
	}
	
}

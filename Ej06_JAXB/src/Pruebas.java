import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import modelogenerado.Disco;


public class Pruebas {

	public static void main(String[] args) throws JAXBException {
		
		Disco d = new Disco();
		d.setTitulo("The dark side of the moon");
		d.setGrupo("Pink Floyd");
		d.setYear(1973);
		
		System.out.println("=================================");
		System.out.println("Marshalleando...");
		JAXBContext jCtx = JAXBContext.newInstance(Disco.class);
		Marshaller m = jCtx.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(d, new File("datos.xml"));
		
		System.out.println("=================================");
		System.out.println("Unmarshalleando...");
		JAXBContext jCtx2 = JAXBContext.newInstance(Disco.class);
		Unmarshaller um = jCtx2.createUnmarshaller();
		Disco d2 = (Disco) um.unmarshal(new File("datos.xml"));
		
		System.out.println(d2);
		
	}
	
	
}

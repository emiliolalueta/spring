package com.curso.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import com.curso.modelo.entidad.CocheDTO;

@Component
public class ReaderXMLCoches extends StaxEventItemReader<CocheDTO>{
 
	public ReaderXMLCoches(){
		this.setResource(new ClassPathResource("data/coches.xml"));
		this.setFragmentRootElementName("coche");
		
		Jaxb2Marshaller studentMarshaller = new Jaxb2Marshaller();
		studentMarshaller.setClassesToBeBound(CocheDTO.class);
		this.setUnmarshaller(studentMarshaller);
	}
	
}
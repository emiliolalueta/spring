package com.curso.batch;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.curso.modelo.entidad.CocheDTO;

public class WriterXMLCoches extends JdbcBatchItemWriter<CocheDTO>{

	public WriterXMLCoches(){

		StaxEventItemWriter<CocheDTO> writer = new StaxEventItemWriter<CocheDTO>();
		writer.setResource(new FileSystemResource("salida.xml"));
		writer.setRootTagName("coche");
		
		Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
		unmarshaller.setClassesToBeBound(CocheDTO.class);
		
		writer.setMarshaller(unmarshaller);			
	}
    
}

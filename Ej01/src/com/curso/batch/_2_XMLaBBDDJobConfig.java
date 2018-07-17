package com.curso.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.curso.modelo.entidad.CocheDTO;

//@Configuration
public class _2_XMLaBBDDJobConfig {
 
    @Bean
    ItemReader<CocheDTO> xmlFileItemReader() {
        StaxEventItemReader<CocheDTO> xmlFileReader = new StaxEventItemReader<>();
        xmlFileReader.setResource(new ClassPathResource("data/coches.xml"));
        xmlFileReader.setFragmentRootElementName("coche");
 
        Jaxb2Marshaller studentMarshaller = new Jaxb2Marshaller();
        studentMarshaller.setClassesToBeBound(CocheDTO.class);
        xmlFileReader.setUnmarshaller(studentMarshaller);
 
        return xmlFileReader;
    }
}
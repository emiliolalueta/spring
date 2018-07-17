package com.curso.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.modelo.entidad.CocheDTO;

//@Configuration
public class _4_ListJobConfig {
 
    private static final String QUERY =
            "SELECT * FROM coches";
 
    @Bean
    ItemReader<CocheDTO> listItemReader() {
        return new ReaderListaCoches();
    }
}





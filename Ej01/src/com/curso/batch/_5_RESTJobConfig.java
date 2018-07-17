package com.curso.batch;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.curso.modelo.entidad.CocheDTO;
 
//@Configuration
public class _5_RESTJobConfig {
 
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }	
	
    @Bean
    ItemReader<CocheDTO> restStudentReader(Environment environment, 
                                           RestTemplate restTemplate) {
        return new ReaderRESTCoches(
            environment.getRequiredProperty("url"), 
            restTemplate
        );
    }

}
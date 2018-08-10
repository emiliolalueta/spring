package com.curso.batch_3;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.curso.dto.CocheDTO;
 
//@Component

//A esta clase le falta la interfaz InitializingBean
class ReaderRESTCoches implements ItemReader<CocheDTO>{
  
    private final String apiUrl;
    private final RestTemplate restTemplate;
 
    private int pos;
    private List<CocheDTO> datos;
 
    ReaderRESTCoches(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }
    
    @Override
    public CocheDTO read() throws Exception {
        if (datos == null) {
            datos = listarCoches();
        }
 
        CocheDTO coche = null;
 
        if (pos < datos.size()) {
            coche = datos.get(pos);
            pos++;
        }
 
        return coche;
    }
 
    private List<CocheDTO> listarCoches() {
        ResponseEntity<CocheDTO[]> response = restTemplate.getForEntity(
            apiUrl, 
            CocheDTO[].class
        );
        CocheDTO[] studentData = response.getBody();
        return Arrays.asList(studentData);
    }
}
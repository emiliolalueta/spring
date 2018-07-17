package com.curso.batch;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.curso.modelo.entidad.CocheDTO;

//@Configuration
public class _3_BBDDaXMLJobConfig {
 
    private static final String QUERY =
            "SELECT * FROM coches";
 
    @Bean
    ItemReader<CocheDTO> databaseXmlItemReader(DataSource dataSource) {
        JdbcCursorItemReader<CocheDTO> databaseReader = new JdbcCursorItemReader<>();
 
        databaseReader.setDataSource(dataSource);
        databaseReader.setSql(QUERY);
        databaseReader.setRowMapper(new BeanPropertyRowMapper<>(CocheDTO.class));
 
        return databaseReader;
    }
}





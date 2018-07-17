package com.curso.batch;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.curso.modelo.entidad.CocheDTO;

//@Configuration
public class ReaderBBDDCoches extends JdbcCursorItemReader<CocheDTO> {
 
    private static final String QUERY = "SELECT * FROM coches";
 
    @Autowired
    private DataSource dataSource;

    @Override
    public void afterPropertiesSet(){
    	this.setDataSource(dataSource);
    	this.setSql(QUERY);
    	this.setRowMapper(new BeanPropertyRowMapper<>(CocheDTO.class));
    }
    
}





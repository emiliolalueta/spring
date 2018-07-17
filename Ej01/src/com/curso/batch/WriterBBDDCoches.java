package com.curso.batch;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import com.curso.modelo.entidad.CocheDTO;

//@Component
public class WriterBBDDCoches extends JdbcBatchItemWriter<CocheDTO>{

	public WriterBBDDCoches(DataSource dataSource){
        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<CocheDTO>());
        this.setSql("INSERT INTO coches (marca,modelo,matricula) VALUES (:marca,:modelo,:matricula)");
        this.setDataSource(dataSource);
	}
    
}

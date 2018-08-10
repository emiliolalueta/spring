package com.curso.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Cliente;

@Repository
public class ClienteDaoMysql implements ClienteDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertar(Cliente cliente){
		//A la antigua: con array
		//jdbcTemplate.update("insert into coches (marca,modelo,matricula,potencia) values (?,?,?,?)",
		//					new Object[] { coche.getMarca(), coche.getModelo(), coche.getMatricula(), coche.getPotencia()});
		//Java5: El m�todo tiene parametros variables
		jdbcTemplate.update("insert into cliente (nombre, direccion, telefono, numero_tc) values (?,?,?,?)",
				            cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono(), cliente.getNumeroTC());
	}

	public void modificar(Cliente cliente){
		jdbcTemplate.update("update cliente set nombre=?, direccion=?, telefono=?, numero_tc=? where id=?",
	            cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono(), cliente.getNumeroTC(), cliente.getId());
	}
	
	public void borrar(Cliente cliente){
		jdbcTemplate.update("delete from cliente where id=?",
				cliente.getId());
	}

	public Cliente buscar(int id){		
		return jdbcTemplate.queryForObject("select * from cliente where id=?",
										   new ClienteRowMapper(),
										   id);		
	}

	public List<Cliente> listarTodos(){		
		return (List<Cliente>) jdbcTemplate.query("select id,nombre from clientes",
										   new ClienteRowMapper());
	}
	
}

class ClienteRowMapper implements RowMapper<Cliente> {
	public Cliente mapRow(ResultSet rs, int indice) throws SQLException {
		return new Cliente(rs.getInt("id"),
						 rs.getString("nombre"),
						 rs.getString("direccion"),
						 rs.getString("telefono"),
						 rs.getInt("numero_tc"));
	}	
}




























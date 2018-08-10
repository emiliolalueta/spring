package com.curso.modelo.persistencia;

import org.springframework.stereotype.Repository;
import com.curso.modelo.entidad.Cliente;

@Repository
public class ClienteDAOJPAImplementation extends AbstractJPADAO<Cliente, Integer>
                                         implements ClienteDAO{
}


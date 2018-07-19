package expedientesx.persistencia;

import java.util.List;

import expedientesx.modelo.Expediente;

public interface ExpedientesDao {
	Expediente buscar(Long id);
	List<Expediente> listar();
	void guardar(Expediente expediente);
	void borrar(Expediente expediente);
}

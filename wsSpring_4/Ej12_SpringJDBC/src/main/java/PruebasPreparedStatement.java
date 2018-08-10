import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class PruebasPreparedStatement {

	public static void main(String[] args) {
		
		//Cargamos el driver
		//Solo tenemos que hacerlo una vez para todo el tiempo de 
		//ejecución de la aplicación
		//Si es de escritorio, el main es un buen lugar para hacerlo
		//si se ejecuta por segunda vez, no pasa nada 
		//Incluso en las últimas versiones de los drivers se puede obviar y basta
		//solo con añadir el jar al proyecto
		//
		//La clase Driver es la que crea de verdad las conexiones.
		//Cuando llamamos a DriverManager.getConnection internamente 
		//se utiliza el Driver.
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		int id = 3;
		String nombre    = "Bender Bending Rodriguez";
		String direccion = "C/Tal";
		String telefono  = "555";
		Integer numeroTC = 2000;

		Connection cx = null;		
		try {
			//Obtenemos una conexión
			cx = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bbdd",
											 "postgres",
											 "root");

			//Creamos el prepared statement
			PreparedStatement pst = cx.prepareStatement("insert into cliente (id, nombre, direccion, telefono, numero_tc) values (?,?,?,?,?)");
			//Sustituimos las interrogaciones por los valores
			pst.setInt(1, id);
			pst.setString(2, nombre);
			pst.setString(3, direccion);
			pst.setString(4, telefono);
			pst.setInt(5, numeroTC); 
			//Ejecutamos la consulta
			pst.executeUpdate(); 			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
}

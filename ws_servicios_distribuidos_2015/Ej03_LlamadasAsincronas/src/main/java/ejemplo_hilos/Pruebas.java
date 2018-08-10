package ejemplo_hilos;

public class Pruebas {

	public static void main(String[] args) {
		
		GestorFacturas gf = new GestorFacturas();
		//Asi hacemos el toli:
		//gf.run();
		
		Thread th = new Thread(gf);
		th.start();		
		
		System.out.println("FIN");
		
		
	}
	
}

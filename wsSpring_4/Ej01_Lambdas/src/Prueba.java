
public class Prueba {
	public static void main(String[] args) {
		
		InterfaceDeUnMetodo idum = new InterfaceDeUnMetodo() {
			public Integer operacion(int a, int b) {
				return null;
			}
		};
		
		InterfaceDeUnMetodo i1 = (int a, int b) -> { return a+b; };
		InterfaceDeUnMetodo i2 = (int a, int b) -> a+b;
		InterfaceDeUnMetodo i3 = (a, b) -> { return a+b; };
		InterfaceDeUnMetodo i4 = (a, b) -> a+b;

		System.out.println(i1.operacion(1, 2));
		System.out.println(i2.operacion(1, 2));
		System.out.println(i3.operacion(1, 2));
		System.out.println(i4.operacion(1, 2));
	}
}

interface InterfaceDeUnMetodo {
	public Integer operacion(int a, int b);
}

package arbol.test;

import arbol.Arbol;

public class TestArbolSimple {

	public static void main(String[] args) {
		Arbol<String> arbol  = new Arbol();
		
		arbol.insertar(null, "A", "A");
		arbol.insertar("A", "D", "D");
		arbol.insertar("A", "R", "R");
		arbol.insertar("D", "M", "M");
		arbol.insertar("D", "H", "H");
		
		System.out.println(arbol);
	}
}

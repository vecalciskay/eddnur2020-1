package arbol.test;

import arbol.ArbolAritmetico;
import arbol.Numero;
import arbol.OperadorSuma;
import arbol.OperadorSustraccion;

public class TestArbolAritmetico {

	public static void main(String[] args) {
		
		ArbolAritmetico a = new ArbolAritmetico();
		
		ArbolAritmetico.Nodo actual = a.insertar(new OperadorSuma());
		a.insertarDerecha(actual, new Numero(2));
		actual = a.insertarIzquierda(actual, new OperadorSustraccion());
		
		a.insertarDerecha(actual, new Numero(5));
		a.insertarIzquierda(actual, new Numero(4));
		
		System.out.println(a + " = " + a.evaluar());
				
		//a = new ArbolAritmetico("3+2");
		//System.out.println(a + " = " + a.evaluar());
	}
}

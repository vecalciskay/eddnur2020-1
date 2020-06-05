package arbol.test;

import arbol.ArbolAritmetico;
import arbol.Numero;
import arbol.OperadorSuma;
import arbol.OperadorSustraccion;

public class TestArbolAritmetico {

	public static void main(String[] args) {
		
		ArbolAritmetico a = new ArbolAritmetico();
		
		/*ArbolAritmetico.Nodo actual = a.insertar(new OperadorSuma());
		a.insertarDerecha(actual, new Numero(2));
		actual = a.insertarIzquierda(actual, new OperadorSustraccion());
		
		a.insertarDerecha(actual, new Numero(5));
		a.insertarIzquierda(actual, new Numero(4));
		
		System.out.println(a + " = " + a.evaluar());
			*/
		String exprString = "( 3.5 - 0.5) + (3*(4/6.3))"; 
		try {
			
			a = new ArbolAritmetico(exprString);
			System.out.println(a + " = " + a.evaluar());
		} catch (Exception e) {
			System.out.println("No pudo leer expresion '" + exprString + "': " + e.getMessage());
		}
		
		//System.out.println(a + " = " + a.evaluar());
	}
}

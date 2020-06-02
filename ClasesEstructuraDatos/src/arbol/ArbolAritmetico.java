package arbol;

import arbol.Arbol.Nodo;

public class ArbolAritmetico {

	public Nodo raiz;
	
	public class Nodo {
		private ElementoAritmetico contenido;
		
		private Nodo izquierda;
		private Nodo derecha;
		
		public Nodo(ElementoAritmetico e) {
			contenido = e;
			izquierda = null;
			derecha = null;
		}
		
		public String toString() {
			StringBuilder result = new StringBuilder();
			if (izquierda != null) 
				result.append("(").append(izquierda.toString());
			
			result.append(contenido.toString());
			   
			if (derecha != null)
			result.append(derecha.toString()).append(")");
			
			return result.toString();
		}

		public Nodo getIzquierda() {
			return izquierda;
		}

		public void setIzquierda(Nodo izquierda) {
			this.izquierda = izquierda;
		}

		public Nodo getDerecha() {
			return derecha;
		}

		public void setDerecha(Nodo derecha) {
			this.derecha = derecha;
		}

		public ElementoAritmetico getContenido() {
			return contenido;
		}
		
		public double evaluar() {
			
			if (contenido instanceof Numero) {
				return ((Numero) contenido).getValor();
			}
			
			double valorIzq = izquierda.evaluar();
			double valorDer = derecha.evaluar();
			
			Operador operacion = (Operador)contenido;
			double resultado = operacion.evaluar(valorIzq, valorDer);
			
			return resultado;
		}
	}
	
	public String toString() {
		return raiz.toString();
	}
	
	public Nodo insertar(ElementoAritmetico o) {
		
			Nodo nuevoNodo = new Nodo(o);
			raiz = nuevoNodo;
			return raiz;
	}
		
	public Nodo insertarIzquierda(Nodo padre, ElementoAritmetico o) {
		// Si el padre es nulo, da error
		
		Nodo nuevoNodo = new Nodo(o);
		padre.setIzquierda(nuevoNodo);
		return nuevoNodo;
	}
	
	public Nodo insertarDerecha(Nodo padre, ElementoAritmetico o) {
		// Si el padre es nulo, da error
		
		Nodo nuevoNodo = new Nodo(o);
		padre.setDerecha(nuevoNodo);
		return nuevoNodo;
	}
	
	public double evaluar() {
		if (raiz == null)
			return 0;
		
		return raiz.evaluar();
	}
}

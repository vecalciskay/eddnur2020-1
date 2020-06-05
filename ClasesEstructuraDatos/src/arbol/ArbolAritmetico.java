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
		
		public Nodo(String expr) throws Exception {
			leerExpresion(expr);
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
		
		public void leerExpresion(String exprSinTrim) throws Exception {
			
			String expr = exprSinTrim.trim();
			
			double posibleNumero = 0;
			try {
				posibleNumero = Double.parseDouble(expr);
				this.contenido = new Numero(posibleNumero);
				this.izquierda = null;
				this.derecha = null;
				return;
			} catch(Exception q) {
				// log que la expr no es un numero y se lee en recurrencia
			}
			
			// Aquí significa que es una expresion
			
			int indexSigno = -1;
			int numeroParentesis = 0;
			int indexActual = -1;
			
			String expresionIzquierda = "";
			String expresionDerecha = "";
			
			while(indexActual < expr.length() && 
					indexSigno < 0) {
				indexActual++;
				if (indexActual == expr.length()) 
					break;
				String caracter = String.valueOf(expr.charAt(indexActual));
				
				if (caracter.equals(" ")) {					
					continue;
				}
				
				if (caracter.equals("(")) {
					numeroParentesis++;
					continue;
				}
				
				if (caracter.equals(")")) {
					numeroParentesis--;
					continue;
				}
				
				if (caracter.matches("[0-9]|\\.")) {
					continue;
				}
				
				if (numeroParentesis == 0 &&
						(
								caracter.equals(OperadorSuma.CARACTER) ||
								caracter.equals(OperadorSustraccion.CARACTER) ||
								caracter.equals(OperadorMultiplicacion.CARACTER) ||
								caracter.equals(OperadorDivision.CARACTER)
						)
					) 
				{
					indexSigno = indexActual;
					break;
				}
			}
			
			if (indexSigno < 0 && 
					expr.startsWith("(") && expr.endsWith(")") &&
					numeroParentesis == 0) {
				// le hemos quitado parentesis
				this.leerExpresion(expr.substring(1,expr.length() - 1));
				return;
			}
			
			if (indexSigno < 0) {
				throw new Exception("La expresion no es valida, no encuentra operador principal");
			}
			
			expresionIzquierda = expr.substring(0, indexSigno);
			expresionDerecha = expr.substring(indexSigno+1);
			
			String signoString = expr.substring(indexSigno,indexSigno+1);
			
			this.contenido = Operador.construir(signoString);
			this.izquierda = new Nodo(expresionIzquierda);
			this.derecha = new Nodo(expresionDerecha);
		}
	}
	
	public ArbolAritmetico(String exprString) throws Exception {
		leerExpresion(exprString);
	}

	public ArbolAritmetico() {
		
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
	
	public void leerExpresion(String expr) throws Exception {
		raiz = new Nodo(expr);
	}
}

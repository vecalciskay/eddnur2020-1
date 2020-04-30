package listaversionfinal;

import java.util.Iterator;

public class Lista<T> implements Iterable<T> {

	protected Nodo<T> inicio;

	public Lista() {
		inicio = null;
	}

	public boolean vacia() {
		return inicio == null;
	}

	/**
	 * Si la lista tiene por ejemplo objeto: hugo, objeto: paco, objeto: luis
	 * entonces me devuelve [hugo, paco, luis]
	 */
	public String toString() {
		if (inicio == null)
			return "[]";

		StringBuilder resultado = new StringBuilder();
		resultado.append("[");

		String separador = "";
		Nodo<T> actual = inicio;
		while (actual != null) {
			String itemString = actual.getContenido().toString();
			resultado.append(separador).append(itemString);
			separador = ",";
			actual = actual.getSiguiente();
		}

		resultado.append("]");
		return resultado.toString();
	}

	public void insertar(T o) {
		Nodo<T> nuevoNodo = new Nodo<T>(o);
		nuevoNodo.setSiguiente(inicio);
		inicio = nuevoNodo;
	}

	public void agregar(T o) {
		if (inicio == null) {
			insertar(o);
			return;
		}
		
		Nodo<T> actual = inicio;
		while(actual.getSiguiente() != null) {
			actual = actual.getSiguiente();
		}
		
		Nodo<T> nuevoNodo = new Nodo<T>(o); 
		actual.setSiguiente(nuevoNodo);
	}
	
	public void eliminar(int pos) throws Exception {
		
		if (pos < 0)
			throw new Exception("No existen posiciones negativas");
		
		if (inicio == null)
			throw new Exception("Lista vacia, nada que eliminar");
		
		if (pos == 0) {
			inicio = inicio.getSiguiente();
			return;
		}
		
		int contador = 0;
		Nodo<T> actual = inicio;
		while(contador < (pos-1) && actual.getSiguiente() != null) {
			actual = actual.getSiguiente();
			contador++;
		}
		if (actual.getSiguiente() == null)
			throw new Exception("No existe esa posicion en esta lista");
		
		actual.setSiguiente(actual.getSiguiente().getSiguiente());
	}

	public int length() {
		int contador = 0;
		Nodo<T> actual = inicio;
		while (actual != null) {
			contador++;
			actual = actual.getSiguiente();
		}

		return contador;
	}

	@Override
	public Iterator<T> iterator() {
		return new IteradorNodo<>(inicio);
	}

	class Nodo<T> {

		private T contenido;
		private Nodo<T> siguiente;

		public Nodo(T o) {
			contenido = o;
			siguiente = null;
		}

		public T getContenido() {
			return contenido;
		}

		public void setContenido(T contenido) {
			this.contenido = contenido;
		}

		public Nodo<T> getSiguiente() {
			return siguiente;
		}

		public void setSiguiente(Nodo<T> siguiente) {
			this.siguiente = siguiente;
		}

	}

	class IteradorNodo<T> implements Iterator<T> {

		private Nodo<T> actual;

		public IteradorNodo(Nodo<T> inicio) {
			actual = inicio;
		}

		@Override
		public boolean hasNext() {
			return actual != null;
		}

		@Override
		public T next() {
			T resultado = actual.getContenido();
			actual = actual.getSiguiente();
			return resultado;
		}

	}
}

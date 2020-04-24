package lista;

import java.util.Iterator;

public class Lista<T> implements Iterable<T> {

	private Nodo<T> inicio;
	
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
		while(actual != null) {
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

	@Override
	public Iterator<T> iterator() {
		return new IteradorNodo<>(inicio);
	}
}

package listaversionfinal;

import listaversionfinal.Lista.Nodo;

public class ListaOrdenada<T> extends Lista<T> {

	public ListaOrdenada() {
		super();
	}
	
	public void insertar(T o) {
		if (!(o instanceof Comparable)) {
			super.insertar(o);
			return;
		}
		
		if (inicio == null) {
			super.insertar(o);
			return;
		}
		
		Nodo<T> nuevoNodo = new Nodo<T>(o); 
		Comparable<T> objComparable = (Comparable<T>)o;
		
		if (objComparable.compareTo(inicio.getContenido()) < 0) {
			nuevoNodo.setSiguiente(inicio);
			inicio = nuevoNodo;
			return;
		}
		
		Nodo<T> actual = inicio;
		while(actual.getSiguiente() != null &&
				((Comparable)actual.getSiguiente().getContenido()).compareTo(objComparable) < 0) {
			actual = actual.getSiguiente();
		}		
		
		// Si se puede ordenar
		nuevoNodo.setSiguiente(actual.getSiguiente());
		actual.setSiguiente(nuevoNodo);
	}
}

package lista;

import java.util.Iterator;

public class IteradorNodo<T> implements Iterator<T> {

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

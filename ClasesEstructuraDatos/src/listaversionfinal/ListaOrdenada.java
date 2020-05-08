package listaversionfinal;

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
			tamano++;
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
		tamano++;
	}

	public T buscar(T o, int[] posicion) throws Exception {
		
		if (!(o instanceof Comparable)) {
			return super.buscar(o, posicion);
		}
		
		int idxInicio = 0;
		int idxFinal = tamano;
		int idxMitad = (idxFinal - idxInicio) / 2;
		T contenidoMitad = get(idxMitad);
		
		Comparable<T> objBuscar = (Comparable)o;
		
		// 5 6 8 9 12
		while(contenidoMitad != o) {
			
			if (objBuscar.compareTo(contenidoMitad) < 0) {
				idxFinal = idxMitad;			
			}
			if (objBuscar.compareTo(contenidoMitad) > 0) {
				idxInicio = idxMitad;			
			}
			idxMitad = (idxFinal + idxInicio) / 2;
			contenidoMitad = get(idxMitad);
		}
		
		posicion[0] = idxMitad;
		return contenidoMitad;
	}
}

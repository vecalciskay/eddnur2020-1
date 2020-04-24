package lista;

public class Nodo<T> {

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

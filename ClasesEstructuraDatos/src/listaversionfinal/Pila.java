package listaversionfinal;

public class Pila<T> extends Lista<T> {
	
	public Pila() {
		super();
	}
	
	public boolean isEmpty() {
		return inicio == null;
	}

	public void push(T o) {
		this.insertar(o);
	}
	
	public T pop() throws Exception {
		T resultado = inicio.getContenido();
		this.eliminar(0);
		return resultado;
	}
}

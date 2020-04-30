package listaversionfinal;

public class Cola<T> extends Lista<T>{

	public Cola() {
		super();
	}
	
	public boolean isEmpty() {
		return inicio == null;
	}

	public void push(T o) {
		this.agregar(o);
	}
	
	public T pop() throws Exception {
		T resultado = inicio.getContenido();
		this.eliminar(0);
		return resultado;
	}
}

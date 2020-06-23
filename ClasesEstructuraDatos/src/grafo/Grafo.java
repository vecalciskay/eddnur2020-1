package grafo;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import lista.Lista;

public class Grafo<T> {

	class Nodo<T> {
		private String id;
		private T contenido;
		private Lista<Nodo<T>> conectados;
		
		public Nodo(String id, T o) {
			this.id = id;
			contenido = o;
			conectados = new Lista<>();
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public T getContenido() {
			return contenido;
		}

		public void setContenido(T contenido) {
			this.contenido = contenido;
		}

		public Lista<Nodo<T>> getConectados() {
			return conectados;
		}

		public void conectar(Nodo<T> nodoA) {
			conectados.insertar(nodoA);
		}
	}
	
	private Hashtable<String, Nodo<T>> nodos;
	
	public Grafo() {
		nodos = new Hashtable<>();
	}
	
	public Hashtable<String, Nodo<T>> getNodos() {
		return nodos;
	}

	public void insertarNodo(String id, T o) throws Exception {
		
		if (id == null ||
				id.isBlank() ||
				id.isEmpty())
			throw new Exception("El identificador no puede ser vacio o nulo");
		
		Nodo<T> nuevoNodo = new Nodo(id, o);
		
		nodos.put(id, nuevoNodo);
	}
	
	public void conectar(String de, String a) {
		
		Nodo<T> nodoDe = nodos.get(de);
		Nodo<T> nodoA = nodos.get(a);
		
		nodoDe.conectar(nodoA);
		
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		StringBuilder conexiones = new StringBuilder();
		
		String separador = "";
		Enumeration<String> enumerador = nodos.keys();
		// Creamos la parte de nodos primero
		while(enumerador.hasMoreElements()) {
			String k = enumerador.nextElement();
			
			// La identificacion aqui
			builder.append(separador).append(k);
			// Las con3xiones aqui
			Nodo<T> actual = nodos.get(k);
			for(Nodo<T> conectado : actual.getConectados()) {
				conexiones.append(k).append(" ").append(conectado.getId()).append("\n");
			}
			
			separador = ",";
		}
		
		builder.append("\n");
		
		// Falta la parte de nodos
		builder.append(conexiones.toString());
		
		return builder.toString();
	}
}

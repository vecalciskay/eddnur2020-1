package grafo;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import lista.Lista;
import listaversionfinal.Cola;

public class Grafo<T> {
	
	class Arco<T> {
		private int peso;
		private Nodo<T> destino;
		
		public Arco(int w, Nodo<T> hacia) {
			peso = w;
			destino = hacia;
		}

		public int getPeso() {
			return peso;
		}

		public void setPeso(int peso) {
			this.peso = peso;
		}

		public Nodo<T> getDestino() {
			return destino;
		}

		public void setDestino(Nodo<T> destino) {
			this.destino = destino;
		}
		
		public String toString() {
			if (peso > 1)
				return " -" + String.valueOf(peso) + "-> " + destino.toString();
			else {
				return " -> " + destino.toString();
			}
		}
		
	}

	class Nodo<T> {
		private String id;
		private T contenido;
		private Lista<Arco<T>> conectados;
		private int visitado;
		
		public Nodo(String id, T o) {
			this.id = id;
			contenido = o;
			conectados = new Lista<>();
		}
		
		public String toString() {
			return this.id;
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

		public int getVisitado() {
			return visitado;
		}

		public void setVisitado(int visitado) {
			this.visitado = visitado;
		}

		public Lista<Arco<T>> getConectados() {
			return conectados;
		}
		public Lista<Nodo<T>> getNodosConectados() {
			Lista<Nodo<T>> resultadoLista = new Lista<>();
			for(Arco<T> a : conectados) {
				resultadoLista.insertar(a.getDestino());
			}
			return resultadoLista;
		}
		
		public void conectar(Nodo<T> nodoA, int peso) {
			Arco<T> nuevoArco = new Arco<>(peso, nodoA);
			conectados.insertar(nuevoArco);
		}

		/**
		 * Metodo wrapper hacia conectar para pesos por defecto a 1
		 * @param nodoA
		 */
		public void conectar(Nodo<T> nodoA) {
			conectar(nodoA, 1);
		}

		public Lista<Nodo<T>> vecinosNoVisitadosYNoEnVisitas(Cola<Nodo<T>> visitas) {
			Lista<Nodo<T>> resultado = new Lista<Nodo<T>>();
			
			for(Nodo<T> vecino: this.getNodosConectados()) {
				if (vecino.getVisitado() < 0) {
					resultado.insertar(vecino);
					continue;
				} else {
					continue;
				}
				
				// No es necesario porque los q no estan visitados van a la cola en la proxmia iteracion
				/*boolean enListaVisitas = false;
				for(Nodo<T> existente : visitas) {
					if (vecino.getVisitado() >= 0 || existente.getId().equals(vecino.getId())) {
						enListaVisitas = true;
						break;
					}
				}
				
				if (!enListaVisitas) {
					resultado.insertar(vecino);
					continue;
				}*/
			}
			
			return resultado;
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
		conectar(de, a, 1);
	}
	
	public void conectar(String de, String a, int peso) {
		
		Nodo<T> nodoDe = nodos.get(de);
		Nodo<T> nodoA = nodos.get(a);
		
		nodoDe.conectar(nodoA, peso);
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
//			for(Nodo<T> conectado : actual.getNodosConectados()) {
//				conexiones.append(k).append(" -> ").append(conectado.getId()).append(";\n");
//			}
			for(Arco<T> arco : actual.getConectados()) {
				conexiones.append(k).append(arco).append(";\n");
			}
			
			separador = ",";
		}
		
		builder.append("\n");
		
		// Falta la parte de nodos
		builder.append(conexiones.toString());
		
		return builder.toString();
	}
	
	public int caminoMasCortoBFS(String desde, String hasta) throws Exception {
		if (!nodos.containsKey(desde) || !nodos.containsKey(hasta))
			throw new Exception("No existe nodo con llave " + desde + " o " + hasta);
		
		if (desde.equals(hasta))
			return 0;
		
		// 1. Crear la pila/cola de visitas
		// 2. colocar el primer nodo en la pila/cola
		// 3. WHILE pila/cola vacia
		// 4.    Visitar nodo (IF nodo es HASTA)
		// 5.    obtener conectados que No visitados y NO en pila/cola
		// 6. END

		// Antes que nad amarcamos como NO VISITADOS
		Enumeration<Nodo<T>> enumerador = nodos.elements();
		// Creamos la parte de nodos primero
		while(enumerador.hasMoreElements()) {
			Nodo<T> nodo = enumerador.nextElement();
			nodo.setVisitado(-1);
		}
		
		Cola<Nodo<T>> visitas = new Cola<Nodo<T>>();
		Nodo<T> nodoDesde = nodos.get(desde);
		nodoDesde.setVisitado(0);
		visitas.push(nodoDesde);
		
		int resultado = -1;
		while(!visitas.vacia()) {
			Nodo<T> nodoAVisitar = visitas.pop();
			if (nodoAVisitar.getId().equals(hasta)) {
				// Hemos encontrado y calculamos la distancia
				resultado = nodoAVisitar.getVisitado();
				break;
			}
			
			Lista<Nodo<T>> conexiones = nodoAVisitar.vecinosNoVisitadosYNoEnVisitas(visitas);
			
			for(Nodo<T> nodoHijoAVisitar : conexiones) {
				nodoHijoAVisitar.setVisitado( nodoAVisitar.getVisitado() + 1);
				visitas.push(nodoHijoAVisitar);
			}
		}
		
		if (resultado < 0)
			throw new Exception("No hay camino entre " + desde + " y " + hasta);
		
		return resultado;
	}
}

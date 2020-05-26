package arbol;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

import lista.Nodo;

/**
 * Cuando se tiene por ejemplo el siguiente arbol:
 * 
 *     A
 *    / \
 *   D   R
 *  / \
 * M   H
 * 
 * Qué representación de tipo texto podemos tener?
 * 
 * A (D (M,H),R)
 * 
 * @author Vladimir
 *
 * @param <T>
 */
public class Arbol<T> {

	private Nodo<T> raiz;
	
	public Arbol() {
		raiz = null;
	}
	
	public String toString() {
		
		return raiz.toString() ;
	}
	
	public void insertar(String idpadre, String id, T obj) {
		Nodo<T> nodo = new Nodo<T>(id, obj);
		
		if (idpadre == null) {
			raiz = nodo;
			return;
		}
		
		Nodo<T> nodoPadre = raiz.encontrar(idpadre);
		nodoPadre.hijos.put(id, nodo);
	}

	public void dibujar(Graphics g, int x, int y) {
		BufferedImage bgImage = new BufferedImage(
				600,400, 
				BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2 = bgImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.blue);
		
		raiz.dibujar(g2, x, y);

		g.drawImage(bgImage, 0, 0, null);
		
	}

	class Nodo<T> {
		
		public static final int ANCHO_NODO = 30;
		public static final int SEPARACION_HORIZONTAL = 20;
		
		private T contenido;
		private String id;
		private Hashtable<String, Nodo<T>> hijos;
		private Nodo<T> padre;
		
		public Nodo(String id, T obj) {
			contenido = obj;
			this.id = id;
			hijos = new Hashtable<String,Nodo<T>>();
			padre = null;
		}
		
		public void dibujar(Graphics2D g2, int x, int y) {
			
			int anchoTotal = getAnchoTotal();
		}
		
		private int getAnchoTotal() {
			if (hijos.isEmpty()) {
				return ANCHO_NODO;
			}
			
			int ancho = 0;
			int separador = 0;
			for(Nodo<T> nodo : hijos.values()) {
				ancho += separador + nodo.getAnchoTotal();
				separador = SEPARACION_HORIZONTAL;
			}
			
			return ancho;
		}

		public Nodo<T> getPadre() {
			return padre;
		}
		public void setPadre(Nodo<T> padre) {
			this.padre = padre;
		}
		public T getContenido() {
			return contenido;
		}
		public String getId() {
			return id;
		}
		public Hashtable<String, Nodo<T>> getHijos() {
			return hijos;
		}
		
		public String toString() {
			StringBuilder result = new StringBuilder();			
			result.append(id);
			
			if (hijos.isEmpty())
				return result.toString();
			
			result.append("(");
			String separador = "";
			for(Nodo<T> nodo : hijos.values()) {
				result.append(separador).append(nodo.toString());
				separador = ",";
			}
			
			result.append(")");
			
			return result.toString();
		}
		
		public Nodo<T> encontrar(String id) {
			if (this.id.equals(id))
				return this;
			Nodo<T> encontro = null;
			for(Nodo<T> nodo : hijos.values()) {
				encontro = nodo.encontrar(id);
				if (encontro != null)
					return encontro;
			}
			
			return encontro;
		}
	}
}

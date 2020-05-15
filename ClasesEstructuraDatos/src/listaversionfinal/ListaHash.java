package listaversionfinal;

import java.util.Iterator;

/**
 * Problema: Cómo encontrar un elemento en 1 (un) solo salto?
 * 
 * Solución posible: Hash Qué es algo que identifica a cualquier persona en el
 * país? Nos hemos inventado un hash para las personas que es el CI
 * 
 * Si una persona X tiene un hash (CI) = A y otra persona Y tiene el mismo hash
 * (CI) = A entonces X y Y son la misma persona.
 * 
 * Si X tiene hash(X) = A (A e [0,999]) Entonces lista[A] = X Cuando toca BUSCAR
 * X, entonces calculamos hash(X) y nos sale A. Lo unico que hay que hacer ahora
 * es devolver lista[A]
 * 
 * 1. Digamos que T es un string. Cual es su hash? "hugo" --> hash = ?
 * 
 * 2. Cómo hacer para que el hash tenga un tamaño razonable? Valor de hash debe
 * ser entre 0 y 999
 * 
 * 3. Seguro que para 2 strings diferentes nos va a salir el mismo hash (porque
 * no somos un grupo de investigadores de varias universidades y porque hash
 * [0,999] y los strings pueden ser infinitos). Qué hacemos en ese caso?
 * Manejamos colisiones con listas
 * 
 * @author Vladimir
 *
 * @param <T>
 */
public class ListaHash {

	private Lista[] items;

	public ListaHash() {
		items = new Lista[1000];
		for (int i = 0; i < items.length; i++) {
			items[i] = new Lista();
		}
	}

	public void insertar(Hashable o) {
		int index = o.getHash();
		items[index].insertar(o);
	}

	public Hashable buscar(String identificador, Hashable baseAlgoritmoHash) {

		int index = baseAlgoritmoHash.getHash(identificador);

		Hashable result = null;
		Lista posibles = items[index];
		
		Iterator iterator = posibles.iterator();
		while(iterator.hasNext()) {
			Hashable objEnPosibles = (Hashable)iterator.next();
			if (objEnPosibles.getIdentificador().equals(identificador))
			{
				result = objEnPosibles;
				break;
			}
		}
		
		return result;
	}

	public String toString() {
		StringBuilder resultBuilder = new StringBuilder();
		String separador = "";
		for (Lista l : items) {
			if (!l.vacia()) {
				resultBuilder.append(separador).append(l);
				separador = ",";
			}
		}
		return resultBuilder.toString();
	}
}

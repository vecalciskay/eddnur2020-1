package lista.test;

import java.util.Iterator;

import lista.Lista;

public class TestListaBasico {

	public static void main(String[] args) {
		Lista<String> lista = new Lista<String>();
		if (lista.vacia())
			System.out.println("Lista vacia");
		else 
			System.out.println(lista.toString());
		
		lista.insertar("hugo");
		lista.insertar("paco");
		lista.insertar("luis");
		
		Iterator<String> i = lista.iterator();
		while(i.hasNext()) {
			String elemento = i.next(); 
			System.out.println(elemento);
		}
		
		for(String elemento : lista) {
			System.out.println(elemento);
		}
		
		System.out.println(lista);
	}
}

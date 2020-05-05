package lista.test;

import listaversionfinal.ListaOrdenada;

public class TestOrdenar {

	public static void main(String[] args) {
		ListaOrdenada<String> l = new ListaOrdenada<String>();
		
		l.insertar("juan");
		l.insertar("pedro");
		l.insertar("alicia");
		l.insertar("maria");
		
		System.out.println(l);
	}
}

package lista.test;

import java.util.Iterator;

import listaversionfinal.Lista;

public class TestListaVersionFinal {
	public static void main(String[] args) {
		Lista<String> lista = new Lista<String>();

		lista.agregar("hugo");
		lista.agregar("paco");
		lista.agregar("luis");

		System.out.println(lista);
		
		System.out.println(lista.length());
		
		try {
			lista.eliminar(2);
		} catch (Exception e) {
			System.out.println("No pudo eliminar: " + e.getMessage());
		}
		
		System.out.println(lista);
	}
}

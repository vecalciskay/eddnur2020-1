package lista.test;

import listaversionfinal.ListaOrdenada;

public class TestDicotomico {
	public static void main(String[] args) throws Exception {
		
		ListaOrdenada<Integer> numeros = new ListaOrdenada<Integer>();
		
		for (int i = 0; i < 10000; i++) {
			Integer n = (int)(Math.random() * 999999.0);
			numeros.insertar(n);
		}
				
		Integer buscar = numeros.get(2867);
		System.out.println("Buscando numero " + buscar);
		
		int[] posicion = new int[1];		
		Integer encontrado = numeros.buscar(buscar, posicion);
		
		System.out.println("Encontro " + encontrado + " en la posicion " + posicion[0]);

	}
}

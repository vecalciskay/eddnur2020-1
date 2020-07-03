package grafo.test;


import grafo.Grafo;

public class TestGrafo {
	public static void main(String[] args) throws Exception {
		
		Grafo<String> grafo = new Grafo<>();
		grafo.insertarNodo("P", "A");
		grafo.insertarNodo("H", "B");
		grafo.insertarNodo("S", "D");
		grafo.insertarNodo("X", "C");
		grafo.insertarNodo("A", "E");
		grafo.insertarNodo("E", "E");
		grafo.insertarNodo("M", "E");
		grafo.insertarNodo("L", "E");
		
		grafo.conectar("P","X");
		grafo.conectar("P","H");
		grafo.conectar("P","M");
		grafo.conectar("H","S");
		grafo.conectar("L","M");
		grafo.conectar("L","S");
		grafo.conectar("L","P");
		grafo.conectar("X","S");
		grafo.conectar("X","A");
		grafo.conectar("S","E");
		grafo.conectar("E","A");
		grafo.conectar("E","L");
		grafo.conectar("A","X");
		grafo.conectar("M","E");
		grafo.conectar("M","X");

		System.out.println(grafo);
		
		int cmc = grafo.caminoMasCortoBFS("A", "H");
		System.out.println("El camino mas corto es de " + cmc + " saltos");
	}
}

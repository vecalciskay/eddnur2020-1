package grafo.test;

import grafo.Grafo;

public class TestGrafo {
public static void main(String[] args) throws Exception {
	Grafo<String> grafo = new Grafo<>();
	grafo.insertarNodo("A", "A");
	grafo.insertarNodo("B", "B");
	
	grafo.conectar("A", "B");
	
	System.out.println(grafo);
}
}

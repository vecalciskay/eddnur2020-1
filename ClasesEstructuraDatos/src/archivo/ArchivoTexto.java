package archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import lista.Lista;

public class ArchivoTexto {

	private Lista<String> lineas;
	
	public ArchivoTexto() {
		lineas = new Lista<>();
	}
	
	public void leer(File fuente) throws IOException {
		InputStream inputstream = new FileInputStream(fuente);
		InputStreamReader lecturadorFuente = new InputStreamReader(inputstream);
		BufferedReader entrada = new BufferedReader(lecturadorFuente);
		
		while(entrada.ready()) {
			String unaLinea = entrada.readLine();
			lineas.insertar(unaLinea);
		}
		
		entrada.close();
	}
	
	public void escribir(String destino) throws FileNotFoundException {
		OutputStream salida = new FileOutputStream(new File(destino));
		
		PrintWriter escribidor = new PrintWriter(salida);
		
		escribidor.println("Escribiendo en el archivo");
		for(String linea : lineas) {
			escribidor.println(linea);
		}
		
		escribidor.flush();
		escribidor.close();
	}

	public String getTexto() {
		StringBuilder resultBuilder = new StringBuilder();
		for(String linea : lineas) {
			resultBuilder.append(linea).append("\n");
		}
		return resultBuilder.toString();
	}
}

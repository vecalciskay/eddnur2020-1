package redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClienteRed {
	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket clt = new Socket("localhost",5555);
	
		BufferedReader entrada = new BufferedReader(
				new java.io.InputStreamReader(clt.getInputStream()));
		
		PrintWriter out = new PrintWriter(clt.getOutputStream());
		
		String mensajeString ="Enviamos desde el cliente de estructura de datos"; 
		out.println(mensajeString);
		out.flush();
		System.out.println(" >>> " + mensajeString);
		
		String linea = entrada.readLine();
		System.out.println(" <<< " + linea);
		
		out.close();
		entrada.close();
		clt.close();
	}
}

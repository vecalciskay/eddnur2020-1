package redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestEscuchaRed {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(5555);
		System.out.println("Esperando...");
		Socket socket = server.accept();
		
		BufferedReader entrada = new BufferedReader(
				new java.io.InputStreamReader(socket.getInputStream()));
		
		String linea = entrada.readLine();
		
		System.out.println(" <<< " + linea);
		
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		String mensajeString ="Respondiendo desde el servidor de estructura de datos"; 
		out.println(mensajeString);
		System.out.println(" >>> " + mensajeString);
		
		out.flush();
		out.close();
		entrada.close();
		socket.close();
		
		server.close();
		
		System.out.println("Fin");
	}
}

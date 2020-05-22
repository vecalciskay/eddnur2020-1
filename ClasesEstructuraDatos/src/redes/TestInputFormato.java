package redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import redes.circulo.ComandoCirculo;
import redes.circulo.ComandoPintar;
import redes.circulo.ComandoPosicion;
import redes.circulo.ComandoRadio;

public class TestInputFormato {
	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(5555);
		System.out.println("Esperando...");
		Socket socket = server.accept();

		BufferedReader entrada = new BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));

		String linea = "";
		while (!"FIN".equals(linea)) {
			linea = entrada.readLine();

			ComandoCirculo cmd = interpretarComando(linea);
			if (cmd != null)
				System.out.println(cmd);
			System.out.println(" <<< " + linea);
		}
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		String mensajeString = "Respondiendo desde el servidor de estructura de datos";
		out.println(mensajeString);
		System.out.println(" >>> " + mensajeString);

		out.flush();
		out.close();
		entrada.close();
		socket.close();

		server.close();

		System.out.println("Fin");
	}

	private static ComandoCirculo interpretarComando(String linea) {
		// Como testear qué es la linea RADIO 50
		String regexString = "^((RADIO)\\s+[1-9][0-9]|(POSICION)\\s+\\(\\s*[0-9]{1,3}\\s*,\\s*[0-9]{1,3}\\s*\\)|(PINTAR))$";

		Pattern pattern = Pattern.compile(regexString);
		Matcher matcher = pattern.matcher(linea);
		boolean found = false;
		while (matcher.find()) {
			System.out.println(
					"Encontre: " + matcher.group() + " en posicion " + matcher.start() + " hasta " + matcher.end());
			System.out.println("Encontro grupos: " + matcher.groupCount());
			
			if (matcher.group(2) != null)
				return new ComandoRadio(linea);
			if (matcher.group(3) != null)
				return new ComandoPosicion(linea);
			if (matcher.group(4) != null)
				return new ComandoPintar();
			found = true;
		}
		if (!found) {
			System.out.println("No encontre nada");
		}

		return null;
	}
}
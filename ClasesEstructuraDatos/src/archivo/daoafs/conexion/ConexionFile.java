package archivo.daoafs.conexion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConexionFile extends archivo.daoafs.conexion.Conexion {
	public String archivo;
	
	public static final String ARCHIVO_PATH = "E:\\work\\Dropbox\\Personal\\Programming\\javaprojects\\ClasesEstructuraDatos\\personas.txt";
	
	public ConexionFile(String archivo) {
		this.archivo = archivo;
	}
	
	public Object[] leer() throws IOException {
		List<String> resultStrings = Files.readAllLines(Paths.get(archivo));
		
		return resultStrings.toArray();
	}
	
	public String leerCondicion(String condicion) throws IOException {
		List<String> resultStrings = Files.readAllLines(Paths.get(archivo));
		
		for(String linea : resultStrings) {
			if (linea.isBlank() || linea.isEmpty())
				continue;
			String nombre = linea.substring(0,linea.indexOf("|"));
			if (nombre.equals(condicion))
				return linea;
		}
		
		return null;
	}
	
	public void eliminarCondicion(String condicion) throws IOException {
		List<String> resultStrings = Files.readAllLines(Paths.get(archivo));
		
		List<String> finalStrings = new ArrayList<String>() ;
		for(String linea : resultStrings) {
			String nombre = linea.substring(0,linea.indexOf("|"));
			if (nombre.equals(condicion))
				continue;
			finalStrings.add(linea);
		}
		
		PrintWriter out = new PrintWriter(new File(archivo));
		for (String unaLinea : finalStrings) {
			out.println(unaLinea);
		}
	}
	
	public void insertar(String unaLinea) throws IOException {
		BufferedWriter output = new BufferedWriter(new FileWriter(archivo, true));
		output.newLine();
		output.append(unaLinea);
		
		output.flush();
		output.close();
	}

	@Override
	public Object ejecutarConsulta(String query) throws IOException {
		if (query.isEmpty() || query.isBlank()) {
			return leer();
		}
		return leerCondicion(query);
	}

	@Override
	public void ejecutarComando(String cmd) throws IOException {
		if (cmd.contains("|")) {
			insertar(cmd);
			return;
		}
		eliminarCondicion(cmd);
	}
}

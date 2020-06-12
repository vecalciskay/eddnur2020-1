package archivo.dao;

import java.io.IOException;
import java.text.ParseException;

import lista.Lista;
import utils.Persona;

public class PersonaDAO {

	private Conexion conexion;
	
	public PersonaDAO() {
		conexion = Conexion.getOrCreate(); 
	}
	
	public Persona getByNombre(String nombre) throws IOException, ParseException {
		String linea = conexion.leerCondicion(nombre);
		Persona p = Persona.buildPersona(linea);
		
		return p;
	}
	
	public Lista<Persona> getAll() throws IOException, ParseException {
		Lista<Persona> resultadoLista = new Lista<Persona>();
		Object[] lineas = conexion.leer();
		for(Object s: lineas) {
			if (s.toString().isBlank() || s.toString().isEmpty())
				continue;
			Persona p = Persona.buildPersona(s.toString());
			resultadoLista.insertar(p);
		}
		
		return resultadoLista;
	}
	
	public void insert(Persona p) throws IOException {
		String linea = p.getNombre() + "|" + 
				p.getFechaNacimiento().getYear()+ "-" + p.getFechaNacimiento().getMonth() + "-" + p.getFechaNacimiento().getDay() + "|" +
				p.getSalario();
		
		conexion.insertar(linea);
	}
}

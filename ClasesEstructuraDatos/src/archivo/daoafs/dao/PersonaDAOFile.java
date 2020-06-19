package archivo.daoafs.dao;

import archivo.daoafs.conexion.Conexion;
import lista.Lista;
import utils.Persona;

public class PersonaDAOFile extends PersonaDAO {
	
	public PersonaDAOFile() {
	}
	
	public Persona getByCriterio(String nombre) throws Exception {
		Conexion conexion = Conexion.getOrCreate(); 
		String linea = (String)( conexion.ejecutarConsulta(nombre));
		Persona p = Persona.buildPersona(linea);
		
		return p;
	}
	
	public Lista<Persona> getAll() throws Exception {
		Conexion conexion = Conexion.getOrCreate(); 
		Lista<Persona> resultadoLista = new Lista<Persona>();
		Object[] lineas = (Object[])(conexion.ejecutarConsulta(""));
		for(Object s: lineas) {
			if (s.toString().isBlank() || s.toString().isEmpty())
				continue;
			Persona p = Persona.buildPersona(s.toString());
			resultadoLista.insertar(p);
		}
		
		return resultadoLista;
	}
	
	public void insert(Persona p) throws Exception {
		Conexion conexion = Conexion.getOrCreate(); 
		String linea = p.getNombre() + "|" + 
				p.getFechaNacimiento().getYear()+ "-" + p.getFechaNacimiento().getMonth() + "-" + p.getFechaNacimiento().getDay() + "|" +
				p.getSalario();
		
		conexion.ejecutarComando(linea);
	}
}

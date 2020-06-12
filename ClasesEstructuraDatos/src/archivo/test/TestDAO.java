package archivo.test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import archivo.dao.PersonaDAO;
import lista.Lista;
import utils.Persona;

public class TestDAO {
	public static void main(String[] args) throws IOException, ParseException {

		PersonaDAO dao = new PersonaDAO();
		
		Lista<Persona> lista = dao.getAll();

		System.out.println(lista);
		
		
		Persona persona = new Persona();
		persona.setNombre("Maria");
		persona.setFechaNacimiento(new Date(1998,5,6));
		persona.setSalario(3056);
		
		dao.insert(persona);
		
		lista = dao.getAll();
		System.out.println(lista);
	}
}

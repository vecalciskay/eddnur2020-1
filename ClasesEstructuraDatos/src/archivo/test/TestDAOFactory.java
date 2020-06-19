package archivo.test;

import java.util.Date;

import archivo.daoafs.dao.DAOFactory;
import archivo.daoafs.dao.PersonaDAO;
import lista.Lista;
import utils.Persona;

public class TestDAOFactory {
	public static void main(String[] args) throws Exception {

		DAOFactory factory = DAOFactory.getOrCreate();
		PersonaDAO dao = factory.getPersonaDAO();
		Lista<Persona> lista = dao.getAll();

		System.out.println(lista);		
		
		/*Persona persona = new Persona();
		persona.setNombre("Jose");
		persona.setFechaNacimiento(new Date(1995,3,8));
		persona.setSalario(5029);
		
		dao.insert(persona);
		
		lista = dao.getAll();
		System.out.println(lista);*/

	}
}

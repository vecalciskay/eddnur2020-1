package archivo.daoafs.dao;

public class DAOFactoryFile extends DAOFactory {

	@Override
	public PersonaDAO getPersonaDAO() {
		return new PersonaDAOFile();
	}

}

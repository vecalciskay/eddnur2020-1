package archivo.daoafs.dao;

public class DAOFactoryMysql extends DAOFactory {

	@Override
	public PersonaDAO getPersonaDAO() {
		return new PersonaDAOMysql();
	}

}

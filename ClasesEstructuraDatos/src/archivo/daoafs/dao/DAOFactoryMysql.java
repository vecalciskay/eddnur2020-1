package archivo.daoafs.dao;

/**
 * La implementaci�n del Dao Factory para MySql. Aqu� se crea toda la familia
 * de DAOs que usar�n MySql como soporte de base de datos.
 * 
 * @author Vladimir
 *
 */
public class DAOFactoryMysql extends DAOFactory {

	@Override
	public PersonaDAO getPersonaDAO() {
		return new PersonaDAOMysql();
	}

}

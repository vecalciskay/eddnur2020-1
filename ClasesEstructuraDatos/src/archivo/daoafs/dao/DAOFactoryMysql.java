package archivo.daoafs.dao;

/**
 * La implementación del Dao Factory para MySql. Aquí se crea toda la familia
 * de DAOs que usarán MySql como soporte de base de datos.
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

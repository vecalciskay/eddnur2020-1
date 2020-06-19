package archivo.daoafs.dao;

import archivo.daoafs.conf.ConfiguracionDao;

public abstract class DAOFactory implements IDAOFactory {

	private static DAOFactory singleton;
	
	public static DAOFactory getOrCreate() {
		if (singleton != null)
			return singleton;
		
		ConfiguracionDao cfg = ConfiguracionDao.getOrCreate();
		if (cfg.getDao() == ConfiguracionDao.TipoDao.File)
			singleton = new DAOFactoryFile();
		else if (cfg.getDao() == ConfiguracionDao.TipoDao.MySql)
			singleton = new DAOFactoryMysql();
		
		return singleton;
	}
	
}

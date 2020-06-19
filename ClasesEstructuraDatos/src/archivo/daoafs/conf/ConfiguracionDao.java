package archivo.daoafs.conf;

public class ConfiguracionDao {
	
	public enum TipoDao {
		File, MySql
	}
	
	private TipoDao dao;

	private static ConfiguracionDao singleton;
	
	private ConfiguracionDao() {
		dao = TipoDao.MySql;
	}
	
	public TipoDao getDao() {
		return dao;
	}
	
	public static ConfiguracionDao getOrCreate() {
		if (singleton == null)
			singleton = new ConfiguracionDao();
		return singleton;
	}
}

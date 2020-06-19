package archivo.daoafs.conexion;

import archivo.daoafs.conf.ConfiguracionDao;

public abstract class Conexion implements IConexion {
	private static Conexion singleton;
	
	public static Conexion getOrCreate() {
		
		if (singleton != null)
			return singleton;
		
		ConfiguracionDao cfg = ConfiguracionDao.getOrCreate();
		if (cfg.getDao() == ConfiguracionDao.TipoDao.File) {
			singleton = new ConexionFile(ConexionFile.ARCHIVO_PATH);
		} else if (cfg.getDao() == ConfiguracionDao.TipoDao.MySql) {
			singleton = new ConexionMysql();
		}
		
		return singleton;
	}
}

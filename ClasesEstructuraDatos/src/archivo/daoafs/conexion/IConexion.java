package archivo.daoafs.conexion;

public interface IConexion {
	public Object ejecutarConsulta(String query) throws Exception;
	public void ejecutarComando(String cmd) throws Exception;
}

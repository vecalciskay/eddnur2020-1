package archivo.daoafs.dao;

import lista.Lista;

public interface IDAO<T> {
	public  T getByCriterio(String criterio) throws Exception;
	
	public  Lista<T> getAll() throws Exception;
	
	public  void insert(T p) throws Exception;
}

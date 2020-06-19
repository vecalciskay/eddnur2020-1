package archivo.daoafs.dao;

import java.sql.ResultSet;
import java.util.Date;

import archivo.daoafs.conexion.Conexion;
import lista.Lista;
import utils.Persona;

public class PersonaDAOMysql extends PersonaDAO {

	@Override
	public Persona getByCriterio(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lista<Persona> getAll() throws Exception {
		String queryString = "select nombre, fechanacimiento, salario from personas";
		Conexion conexion = Conexion.getOrCreate();
		ResultSet rs = (ResultSet)conexion.ejecutarConsulta(queryString);
		
		Lista<Persona> lista = new Lista<>();
		while(rs.next()) {
			String nombre = rs.getString("nombre");
			Date fechaDate = rs.getDate("fechanacimiento");
			int salario = rs.getInt("salario");
			
			Persona persona = new Persona(nombre, fechaDate,salario);
			
			lista.insertar(persona);
		}
		
		return lista;
	}

	@Override
	public void insert(Persona p) throws Exception {
		// TODO Auto-generated method stub
		
	}


}

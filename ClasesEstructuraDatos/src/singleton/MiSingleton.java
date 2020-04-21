package singleton;

/**
 * SOlamente puede existir una instancia de esta clase
 * @author Vladimir
 *
 */
public class MiSingleton {
	
	private String atributo1;
	
	private static MiSingleton unicaInstancia;
	
	public static MiSingleton getOrCreate() {
		if (unicaInstancia == null)
			unicaInstancia = new MiSingleton();
		
		return unicaInstancia;
	}
	

	private MiSingleton() {
		atributo1 = "Hugo";		
	}

	public String getAtributo1() {
		return atributo1;
	}

	public void setAtributo1(String atributo1) {
		this.atributo1 = atributo1;
	}
	
	
}

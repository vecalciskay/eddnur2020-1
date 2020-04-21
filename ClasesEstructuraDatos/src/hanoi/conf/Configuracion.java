package hanoi.conf;

public class Configuracion {

	private static Configuracion singleton;
	
	public static Configuracion getOrCreate() {
		if (singleton == null)
			singleton = new Configuracion();
		
		return singleton;
	}
	
	private String claseDibujador;
	
	private Configuracion() {
		claseDibujador = "hanoi.gui.DibujadorHanoi";
	}

	public String getClaseDibujador() {
		return claseDibujador;
	}

	public void setClaseDibujador(String claseDibujador) {
		this.claseDibujador = claseDibujador;
	}

	public void setDibujadorEspecial() {
		claseDibujador = "hanoi.gui.DibujadorHanoiAlt";
	}
	
	public void setDibujadorStandard() {
		claseDibujador = "hanoi.gui.DibujadorHanoi";
	}
}

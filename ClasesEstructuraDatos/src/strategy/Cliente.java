package strategy;

public class Cliente {
	private String nombre;
	private float deuda;
	private float montoVentaPromedio;
	private IPresentador presentador;

	public Cliente(String nombre, float debe, float vtaPromedio, IPresentador presentador) {
		this.nombre = nombre;
		deuda = debe;
		montoVentaPromedio = vtaPromedio;
		this.presentador = presentador;
	}
	
	public String toString() {
		return presentador.toString(this);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getDeuda() {
		return deuda;
	}

	public void setDeuda(float deuda) {
		this.deuda = deuda;
	}

	public float getMontoVentaPromedio() {
		return montoVentaPromedio;
	}

	public void setMontoVentaPromedio(float montoVentaPromedio) {
		this.montoVentaPromedio = montoVentaPromedio;
	}
	
	
}

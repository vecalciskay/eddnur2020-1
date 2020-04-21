package strategy;

public class PresentadorComercial implements IPresentador{

	@Override
	public String toString(Cliente cliente) {
		return "Clt: " + cliente.getNombre() +
				" Deuda: " + cliente.getDeuda() + 
				" VtaProm: " + cliente.getMontoVentaPromedio();
	}

}

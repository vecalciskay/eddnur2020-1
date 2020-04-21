package strategy;

public class MainCliente {
	public static void main(String[] args) {
		Cliente cliente = new Cliente("Jaime", 200.50f, 50.3f, new PresentadorCliente());

		System.out.println(cliente);
	}
}

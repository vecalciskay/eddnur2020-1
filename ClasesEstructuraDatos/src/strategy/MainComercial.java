package strategy;

public class MainComercial {

	public static void main(String[] args) {
		//Cliente cliente = new Cliente("Jaime", 200.50f, 50.3f);
		
		Cliente cliente = new Cliente("Jaime", 200.50f, 50.3f, new PresentadorComercial());
		
		System.out.println(cliente);
	}
}

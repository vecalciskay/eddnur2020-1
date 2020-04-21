package observer;

public class Banco {

	public static void main(String[] args) {
		Comercial comercial = new Comercial();
		CuentaBanco cuentaBanco = new CuentaBanco(comercial);
		
		cuentaBanco.depositar(200);
		cuentaBanco.depositar(300);
		cuentaBanco.depositar(800);
		cuentaBanco.sacar(200);
		cuentaBanco.depositar(100);
		cuentaBanco.sacar(500);
		
		System.out.println("Saldo final: " + cuentaBanco.getSaldo());
	}
}

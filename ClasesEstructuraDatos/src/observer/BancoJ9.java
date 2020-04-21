package observer;

public class BancoJ9 {
	public static void main(String[] args) {
		ComercialJ9 comercial = new ComercialJ9();
		CuentaBancoJ9 cuentaBanco = new CuentaBancoJ9();
		cuentaBanco.addObserverSaldo(comercial);
		
		cuentaBanco.depositar(200);
		cuentaBanco.depositar(300);
		cuentaBanco.depositar(800);
		cuentaBanco.sacar(200);
		cuentaBanco.depositar(100);
		cuentaBanco.sacar(500);
		
		System.out.println("Saldo final: " + cuentaBanco.getSaldo());
	}
}

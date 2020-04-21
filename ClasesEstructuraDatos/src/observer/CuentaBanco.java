package observer;

import java.util.Observable;


/**
 * Problema: Como hacer para que cada 100 bs depositados, el banco le regala 5 Bs si y
 * solamente si el saldo es menor a 1000 bs?
 * 
 * @author Vladimir
 *
 */
public class CuentaBanco extends Observable {

	private int saldo;
	
	public CuentaBanco(Comercial comercial) {
		this.addObserver(comercial);
	}
	
	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void depositar(int cantidad) {
		// Primera solución:
		// Colocar toda la logica dentro del metodo depositar
		this.setChanged();
		this.notifyObservers(cantidad);
		ingreso(cantidad);
		System.out.println("Se depositaron " + cantidad + " bs. Saldo: " + saldo);
	}
	
	public void sacar(int cantidad) {
		this.setChanged();
		this.notifyObservers(-cantidad);
		egreso(cantidad);
		System.out.println("Se sacaron " + cantidad + " bs Saldo: " + saldo);
	}
	
	public void ingreso(int cantidad) {
		saldo += cantidad;
	}
	
	public void egreso(int cantidad) {
		saldo -= cantidad;
	}
}

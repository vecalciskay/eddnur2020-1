package observer;

import java.beans.PropertyChangeSupport;

public class CuentaBancoJ9 {
	private int saldo;
	
	private PropertyChangeSupport changeSupport;

	public CuentaBancoJ9() {
		this.changeSupport = new PropertyChangeSupport(this);
	}
	
	public void addObserverSaldo(ComercialJ9 observador) {
		this.changeSupport.addPropertyChangeListener(observador);
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void depositar(int cantidad) {
		int oldSaldo = saldo;		
		ingreso(cantidad);
		System.out.println("Se depositaron " + cantidad + " bs. Saldo: " + saldo);
		this.changeSupport.firePropertyChange("saldo", oldSaldo, saldo);		
	}

	public void sacar(int cantidad) {
		int oldSaldo = saldo;
		egreso(cantidad);
		System.out.println("Se sacaron " + cantidad + " bs Saldo: " + saldo);
		this.changeSupport.firePropertyChange("saldo", oldSaldo, saldo);
	}

	public void ingreso(int cantidad) {
		saldo += cantidad;
	}

	public void egreso(int cantidad) {
		saldo -= cantidad;
	}
}

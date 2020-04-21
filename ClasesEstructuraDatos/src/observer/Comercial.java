package observer;

import java.util.Observable;
import java.util.Observer;

public class Comercial implements Observer {

	public void incentivo202004(CuentaBanco c, int cantidad) {
		
		if (cantidad > 0 && c.getSaldo() < 1000) {
			int incentivo = (cantidad / 100) * 5;
			c.ingreso(incentivo);
			System.out.println("Se acaba de dar un incentivo de " + incentivo + " bs");
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		CuentaBanco cuentaBanco = (CuentaBanco)o;
		
		incentivo202004(cuentaBanco, (int)arg);
	}

}

package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ComercialJ9 implements PropertyChangeListener {
	public void incentivo202004(CuentaBancoJ9 c, int cantidad) {

		if (cantidad > 0 && c.getSaldo() < 1000) {
			int incentivo = (cantidad / 100) * 5;
			c.ingreso(incentivo);
			System.out.println("Se acaba de dar un incentivo de " + incentivo + " bs");
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Cambio del " + evt.getPropertyName() + ": \t(" + evt.getOldValue() + 
							" -> " + evt.getNewValue() + ")");
		
		CuentaBancoJ9 cuentaBanco = (CuentaBancoJ9)evt.getSource();
		int cantidad = (int)(evt.getNewValue()) - (int)(evt.getOldValue());

		incentivo202004(cuentaBanco, cantidad);
	}
}

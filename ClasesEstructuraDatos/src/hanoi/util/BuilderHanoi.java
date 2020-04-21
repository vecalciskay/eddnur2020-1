package hanoi.util;

import hanoi.HanoiPOO;
import hanoi.conf.Configuracion;
import hanoi.gui.IDibujador;

public class BuilderHanoi {

	public static IDibujador getDibujador(HanoiPOO hanoi) {
		Configuracion configuracion = Configuracion.getOrCreate();

		IDibujador estrategiaDibujar = null;

		try {
			estrategiaDibujar = (IDibujador) (Class.forName(configuracion.getClaseDibujador()).newInstance());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		estrategiaDibujar.setHanoi(hanoi);

		return estrategiaDibujar;
	}
}

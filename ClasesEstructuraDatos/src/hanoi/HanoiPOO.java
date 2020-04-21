package hanoi;

import java.awt.Graphics;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import hanoi.conf.Configuracion;
import hanoi.gui.IDibujador;
import hanoi.util.BuilderHanoi;

public class HanoiPOO  {

	private Torre[] torres;
	private int cantidadAnillos;
	
	private PropertyChangeSupport anillosChangeSupport;
	private IDibujador estrategiaDibujar;

	public HanoiPOO(int n) {
		torres = new Torre[3];

		cantidadAnillos = n;
		torres[0] = new Torre(n);
		torres[1] = new Torre();
		torres[2] = new Torre();
		
		anillosChangeSupport = new PropertyChangeSupport(this);
	}
	
	public void addObserver(PropertyChangeListener listener) {
		anillosChangeSupport.addPropertyChangeListener(listener);
	}

	public void resolver() {
		resolverHanoi(0, 2, 1, cantidadAnillos);
	}

	private void resolverHanoi(int desde, int hasta, int pp, int n) {
		if (n == 1) {
			Anillo a = torres[desde].sacar();
			torres[hasta].meter(a);

			this.anillosChangeSupport.firePropertyChange("movimiento", desde, hasta);
			try {
				Thread.currentThread().sleep(200);
			} catch (Exception e) {
				;
			}
			return;
		}

		resolverHanoi(desde, pp, hasta, n - 1);
		resolverHanoi(desde, hasta, pp, 1);
		resolverHanoi(pp, hasta, desde, n - 1);

	}

	public String toString() {
		StringBuilder result = new StringBuilder();

		result.append("|-");
		result.append(torres[0]).append("\n");
		result.append("|-");
		result.append(torres[1]).append("\n");
		result.append("|-");
		result.append(torres[2]).append("\n");

		return result.toString();
	}

	public Torre[] getTorres() {
		return torres;
	}
	
	public void dibujar(Graphics g, int x, int y, int w, int h) {
		
		if (estrategiaDibujar == null)
			estrategiaDibujar = BuilderHanoi.getDibujador(this);
		
		if (estrategiaDibujar != null)
			estrategiaDibujar.dibujar(g, x, y, w, h);
	}

	public void resetDibujador() {
		estrategiaDibujar = null;
	}
}

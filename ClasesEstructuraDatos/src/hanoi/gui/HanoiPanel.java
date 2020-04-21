package hanoi.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import hanoi.HanoiPOO;
import hanoi.conf.Configuracion;

public class HanoiPanel extends JPanel implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HanoiPOO modelo;

	public HanoiPanel(HanoiPOO m) {
		modelo = m;
	}

	public Dimension getPreferredSize() {
		return new Dimension(600, 400);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (modelo != null) {
			modelo.dibujar(g, 10, 350, 450, 300);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Movimiento de torre " + evt.getOldValue() + " a torre " + evt.getNewValue());
		repaint();
	}

}

package redes.circulo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

public class CirculoPanel extends JPanel implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Circulo modelo;
	
	public CirculoPanel(Circulo m) {
		modelo = m;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(600,400);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
				
		modelo.dibujar((Graphics2D)g);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
	}
}

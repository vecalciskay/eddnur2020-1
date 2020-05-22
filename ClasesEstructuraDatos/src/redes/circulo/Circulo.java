package redes.circulo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeSupport;

public class Circulo {

	private int radio;
	private int x;
	private int y;
	private boolean pintado;
	
	private PropertyChangeSupport cambios;
	
	public Circulo() {
		radio = 50;
		x = 200;
		y = 200;
		pintado = false;
		
		cambios = new PropertyChangeSupport(this);
	}
	
	public void dibujar(Graphics2D g) {
		BufferedImage bgImage = new BufferedImage(
				600,400, 
				BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2 = bgImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.red);

		if (pintado) {
			g2.fillOval(x - radio, y - radio, radio*2, radio*2);
		} else {
			g2.drawOval(x - radio, y - radio, radio*2, radio*2);
		}
		
		g.drawImage(bgImage, 0, 0, null);
	}
	
	public void hacerComando(ComandoCirculo cmd) {
		if (cmd instanceof ComandoPintar) 
			pintado = true;
		if (cmd instanceof ComandoPosicion)
		{
			ComandoPosicion posicion = (ComandoPosicion)cmd;
			x = posicion.getX();
			y = posicion.getY();
		}
		if (cmd instanceof ComandoRadio)
		{
			ComandoRadio r = (ComandoRadio)cmd;
			radio = r.getRadio();
		}
		
		cambios.firePropertyChange("dibujo", 1, 0);
	}

	public void addObserver(CirculoPanel panel) {
		cambios.addPropertyChangeListener(panel);
	}
}

package arbol.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import arbol.Arbol;

public class PanelArbol extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Arbol<String> modelo;

	
	public PanelArbol(Arbol<String> modelo) {
		this.modelo = modelo;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(600,400);
	}
	
	public void paintComponent(Graphics g) {
		BufferedImage bgImage = new BufferedImage(
				600,400, 
				BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D g2 = bgImage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.blue);
		
		g2.drawString(modelo.toString(), 200, 200);

		g.drawImage(bgImage, 0, 0, null);
	}
}

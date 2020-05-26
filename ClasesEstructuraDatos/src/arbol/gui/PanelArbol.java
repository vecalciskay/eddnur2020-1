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
		
		modelo.dibujar(g, 10, 10);
		
	}
}

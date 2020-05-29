package arbol.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import arbol.Arbol;

public class PanelArbol extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Arbol<String> modelo;

	
	public PanelArbol(Arbol<String> modelo) {
		this.modelo = modelo;
		this.addMouseListener(this);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(600,400);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		modelo.dibujar(g, 10, 10);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		String contenido = modelo.buscarEnXY(e.getX(), e.getY());
		if (contenido == null)
			return;
		
		JOptionPane.showMessageDialog(this, "Contenido: " + contenido);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

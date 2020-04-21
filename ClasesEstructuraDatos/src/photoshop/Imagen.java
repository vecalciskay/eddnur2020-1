package photoshop;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Imagen {

	private int ancho;
	private int alto;
	
	private int[][] pixeles;
	
	private PropertyChangeSupport imagenChangeSupport;
	
	public Imagen(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		
		pixeles = new int[ancho][alto];
		
		imagenChangeSupport = new PropertyChangeSupport(this);
		
		todoGris();
	}
	
	public void addObserver(PropertyChangeListener listener) {
		imagenChangeSupport.addPropertyChangeListener(listener);
	}
	
	public void todoGris() {
		for (int i = 0; i < ancho; i++) {
			for (int j = 200; j < alto; j++) {
				pixeles[i][j] = 0x00aaaaaa; 
			}
		}
	}
	
	public int getColor(int x, int y) {
		return pixeles[x][y];
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
	public void dibujar(Graphics g) {
		BufferedImage rsm = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = rsm.createGraphics();
		for (int i = 0; i < ancho; i++) {
			for (int j = 0; j < alto; j++) {
				
				g2d.setColor(new Color(pixeles[i][j]));
				g2d.drawLine(i, j, i, j);
			}
		}
		
		g.drawImage(rsm, 0, 0, null);
	}
	
	public void hacerTransformacion(IComando cmd) {
		
		cmd.setImagen(this);
		cmd.ejecutar();
		imagenChangeSupport.firePropertyChange("imagen", 10, 20);
	}

	public int[][] getPixeles() {
		return pixeles;
	}
}

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
	int numeroTransformaciones = 0;
	
	private int[][] pixeles;
	
	private PropertyChangeSupport imagenChangeSupport;
	
	public Imagen(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		
		pixeles = new int[ancho][alto];
		
		imagenChangeSupport = new PropertyChangeSupport(this);
	}
	
	public void addObserver(PropertyChangeListener listener) {
		imagenChangeSupport.addPropertyChangeListener(listener);
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
	
	public int getNumeroTransformaciones() {
		return numeroTransformaciones;
	}

	public void setNumeroTransformaciones(int numeroTransformaciones) {
		this.numeroTransformaciones = numeroTransformaciones;
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
		numeroTransformaciones++;
		imagenChangeSupport.firePropertyChange("imagen", 10, 20);
	}

	public int[][] getPixeles() {
		return pixeles;
	}

	public void setImagen(BufferedImage img) {
		ancho = img.getWidth();
		alto = img.getHeight();
		
		pixeles = new int[ancho][alto];
		
		for (int i = 0; i < ancho; i++) {
			for (int j = 0; j < alto; j++) {
				
				pixeles[i][j] = img.getRGB(i, j);
			}
		}
		imagenChangeSupport.firePropertyChange("nueva", 10, 20);
	}

	public Imagen clonar() {
		Imagen clonImagen = new Imagen(ancho, alto);
		for (int i = 0; i < ancho; i++) {
			for (int j = 0; j < alto; j++) {
				
				clonImagen.setColor(i,j, pixeles[i][j]);
			}
		}
		clonImagen.setNumeroTransformaciones(numeroTransformaciones);
		return clonImagen;
	}

	private void setColor(int i, int j, int color) {
		pixeles[i][j]= color;
	}

	public void setFromImagen(Imagen img) {
		ancho = img.getAncho();
		alto = img.getAlto();
		pixeles = img.getPixeles();
		numeroTransformaciones = img.getNumeroTransformaciones();
		imagenChangeSupport.firePropertyChange("recupera", 10, 20);
	}
}

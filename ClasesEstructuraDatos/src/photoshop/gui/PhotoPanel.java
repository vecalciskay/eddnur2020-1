package photoshop.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import photoshop.Imagen;
import photoshop.util.Deshacedor;


public class PhotoPanel extends JPanel implements PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private Imagen modelo;
	private Deshacedor listaCambiosDeshacedor;

	public PhotoPanel(Imagen modelo) {
		this.modelo = modelo;
		this.listaCambiosDeshacedor = new Deshacedor();
		this.modelo.addObserver(this.listaCambiosDeshacedor);
	}

	public Dimension getPreferredSize() {
		return new Dimension(600, 400);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (modelo != null)
			modelo.dibujar(g);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//Imagen modeloImagen = (Imagen)evt.getSource();
		repaint();
	}

	public void deshacer() {
		listaCambiosDeshacedor.deshacer();
		Imagen img = listaCambiosDeshacedor.clonarActual();
		modelo.setFromImagen(img);
	}

	public void rehacer() {
		listaCambiosDeshacedor.rehacer();
		Imagen img = listaCambiosDeshacedor.clonarActual();
		modelo.setFromImagen(img);
	}
}

package arbol.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import arbol.Arbol;

public class FrameArbol extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Arbol<String> modelo;
	private PanelArbol panel;
	
	public FrameArbol() {
		init();
		panel.repaint();
	}

	public void init() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.getContentPane().setLayout(new BorderLayout());

		modelo = new Arbol<String>();
		
		inicializarConEjemplo();
		
		panel = new PanelArbol(modelo);

		this.getContentPane().add(panel, BorderLayout.CENTER);
		
		this.pack();
	}
	

	public void inicializarConEjemplo() {
		
		modelo.insertar(null, "A", "Adan");
		modelo.insertar("A", "D", "Daniel");
		modelo.insertar("A", "R", "Ramiro");
		modelo.insertar("A", "C", "Carla");
		modelo.insertar("D", "M", "Maria");
		modelo.insertar("D", "H", "Horacio");
		
	}

	public static void main(String[] args) {
		FrameArbol frameArbol  = new FrameArbol();
		frameArbol.setVisible(true);
	}
}

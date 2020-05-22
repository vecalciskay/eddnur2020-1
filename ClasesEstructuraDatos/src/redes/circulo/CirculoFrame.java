package redes.circulo;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;


public class CirculoFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Circulo modelo;
	private CirculoPanel panel;
	
	public CirculoFrame() {
		init();
		panel.repaint();
	}

	public void init() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.getContentPane().setLayout(new BorderLayout());

		modelo = new Circulo();
		panel = new CirculoPanel(modelo);
		modelo.addObserver(panel);

		this.getContentPane().add(panel, BorderLayout.CENTER);

		iniciarServicio();
		
		this.pack();
	}
	
	private void iniciarServicio() {

		ServidorCirculo srv = new ServidorCirculo(modelo);
		srv.comenzar();
	}

	public static void main(String[] args) {
		CirculoFrame frame = new CirculoFrame();
		frame.setVisible(true);
	}
}

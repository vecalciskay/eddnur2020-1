package photoshop.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import photoshop.Imagen;
import photoshop.cmd.ComandoAclarar;

public class PhotoFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private PhotoPanel panel;
	private Imagen modelo;
	
	public PhotoFrame() {
		init();
	}
	
	public void init() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		modelo = new Imagen(300, 300);
		panel = new PhotoPanel(modelo);
		modelo.addObserver(panel);
		
		this.getContentPane().add(panel, BorderLayout.CENTER);
		
		// La barra de mennu
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("Archivo");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Standard");
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mnu_config_standard();
			}
			
		});
		
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Salir");
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mnu_archivo_salir();
			}
			
		});
		menu.add(menuItem);
		
		// Menu Operaciones Imagen
		menu = new JMenu("Imagen");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Aclarar");
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mnu_imagen_aclarar();
			}
			
		});
		
		menu.add(menuItem);
		
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		this.pack();
	}

	protected void mnu_imagen_aclarar() {
		modelo.hacerTransformacion(new ComandoAclarar(20));
	}

	protected void mnu_archivo_salir() {
		System.exit(0);
	}

	protected void mnu_config_standard() {
	}

}

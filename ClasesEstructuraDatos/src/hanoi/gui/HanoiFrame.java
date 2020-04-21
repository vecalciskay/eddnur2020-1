package hanoi.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import hanoi.HanoiPOO;
import hanoi.conf.Configuracion;

public class HanoiFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HanoiPanel panel;
	private HanoiPOO modelo;
	
	public HanoiFrame() {
		init();
	}
	
	public void init() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		modelo = new HanoiPOO(5);
		
		panel = new HanoiPanel(modelo);
		modelo.addObserver(panel);
		
		this.getContentPane().add(panel, BorderLayout.CENTER);
		
		// Boton de inicio
		JButton btnButton = new JButton("Comenzar");
		btnButton.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnComenzar_clicked();
				
			}
			
		});
		
		this.getContentPane().add(btnButton, BorderLayout.SOUTH);
		
		// La barra de mennu
		JMenuBar menuBar = new JMenuBar();
		
		JMenu config = new JMenu("Configuracion");
		menuBar.add(config);
		
		JMenuItem menuItem = new JMenuItem("Standard");
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mnu_config_standard();
			}
			
		});
		
		config.add(menuItem);
		
		menuItem = new JMenuItem("Especial");
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mnu_config_especial();
			}
			
		});
		config.add(menuItem);
		
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		this.pack();
	}

	protected void mnu_config_especial() {
		modelo.resetDibujador();
		
		Configuracion configuracion = Configuracion.getOrCreate();
		configuracion.setDibujadorEspecial();
	}

	protected void mnu_config_standard() {
		modelo.resetDibujador();
		
		Configuracion configuracion = Configuracion.getOrCreate();
		configuracion.setDibujadorStandard();
	}

	protected void btnComenzar_clicked() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				modelo.resolver();
			}
		});
		
		thread.start();
	}
}

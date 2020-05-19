package photoshop.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

import photoshop.Imagen;
import photoshop.cmd.ComandoAclarar;
import photoshop.cmd.ComandoConvertirGris;
import photoshop.cmd.ComandoOscurecer;

public class PhotoFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private PhotoPanel panel;
	private Imagen modelo;
	private KernelFrame kernelF;

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

		// Menu Archivo
		// -----------------------------------------
		JMenu menu = new JMenu("Archivo");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("Abrir");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mnu_archivo_abrir();
			}
		});
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Salir");
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mnu_archivo_salir();
			}

		});
		menu.add(menuItem);

		// Menu Operaciones Imagen
		// -----------------------------------------s
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

		menuItem = new JMenuItem("Oscurecer");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mnu_imagen_oscurecer();
			}

		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Convertir a Gris");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mnu_imagen_convertirgris();
			}

		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Convolucionar");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mnu_imagen_convolucionar();
			}

		});
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Deshacer");
		KeyStroke ctrlZ = KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);
		menuItem.setAccelerator(ctrlZ);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mnu_imagen_deshacer();
			}

		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Rehacer");
		KeyStroke ctrlY = KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK);
		menuItem.setAccelerator(ctrlY);
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mnu_imagen_rehacer();
			}

		});
		menu.add(menuItem);

		this.setJMenuBar(menuBar);
		this.setVisible(true);
		this.pack();
	}

	protected void mnu_imagen_rehacer() {
		panel.rehacer();
	}

	protected void mnu_imagen_deshacer() {
		panel.deshacer();
	}

	protected void mnu_imagen_convertirgris() {
		modelo.hacerTransformacion(new ComandoConvertirGris());
	}

	protected void mnu_imagen_aclarar() {
		modelo.hacerTransformacion(new ComandoAclarar(20));
	}

	protected void mnu_imagen_oscurecer() {
		modelo.hacerTransformacion(new ComandoOscurecer(20));
	}

	protected void mnu_imagen_convolucionar() {
		kernelF = new KernelFrame(modelo);
	}

	protected void mnu_archivo_salir() {
		System.exit(0);
	}

	protected void mnu_archivo_abrir() {
		JFileChooser inputFile = new JFileChooser();
		inputFile.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				}
				String extension = f.getAbsolutePath().substring(f.getAbsolutePath().length() - 4);
				extension = extension.toLowerCase();
				return extension.equals(".jpg") || extension.equals(".gif") || extension.equals(".png");
			}
		});
		inputFile.showOpenDialog(this);

		if (inputFile.getSelectedFile() == null) {
			JOptionPane.showMessageDialog(this, "Debe elegir una imagen");
			return;
		}

		BufferedImage img = null;
		try {
			img = ImageIO.read(inputFile.getSelectedFile());
		} catch (IOException e) {
			;
		}

		modelo.setImagen(img);
	}

}

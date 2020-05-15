package photoshop.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import photoshop.Imagen;
import photoshop.cmd.ComandoConvolucionar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class KernelFrame extends JFrame {

    private Imagen imagen;
    static final Logger log = LogManager.getLogger();

    private JButton btnRepujado = new JButton("Repujado");
    private JButton btndetectarBordes = new JButton("Detectar Bordes");
    private JButton btnRealzarBordes = new JButton("Realzar Bordes");
    private JButton btnEnfoque = new JButton("Enfoque");
    private JButton btnDesenfoque = new JButton("Desenfoque");
    private JButton btnConvolucionar = new JButton("Convolucionar");

    private JTextField tf1 = new JTextField("-1");
    private JTextField tf2 = new JTextField("-2");
    private JTextField tf3 = new JTextField("-1");
    private JTextField tf4 = new JTextField("-2");
    private JTextField tf5 = new JTextField("15");
    private JTextField tf6 = new JTextField("-2");
    private JTextField tf7 = new JTextField("-1");
    private JTextField tf8 = new JTextField("-2");
    private JTextField tf9 = new JTextField("-1");

    public KernelFrame(Imagen img) {
        this.imagen = img;
        init();
    }

    /**
     * Se inicializan todos los componentes del Frame
     */
    public void init() {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.setLayout(null);
        this.setLocation(500, 100);

        btnRepujado.setBounds(50, 50, 130, 25);
        btndetectarBordes.setBounds(50, 80, 130, 25);
        btnRealzarBordes.setBounds(50, 110, 130, 25);
        btnDesenfoque.setBounds(50, 140, 130, 25);
        btnEnfoque.setBounds(50, 170, 130, 25);
        btnConvolucionar.setBounds(220, 160, 120, 35);

        tf1.setBounds(220, 50, 30, 30);
        tf2.setBounds(260, 50, 30, 30);
        tf3.setBounds(300, 50, 30, 30);
        tf4.setBounds(220, 85, 30, 30);
        tf5.setBounds(260, 85, 30, 30);
        tf6.setBounds(300, 85, 30, 30);
        tf7.setBounds(220, 120, 30, 30);
        tf8.setBounds(260, 120, 30, 30);
        tf9.setBounds(300, 120, 30, 30);

        this.add(btnConvolucionar);
        this.add(btnRepujado);
        this.add(btndetectarBordes);
        this.add(btnRealzarBordes);
        this.add(btnEnfoque);
        this.add(btnDesenfoque);

        this.add(tf1);
        this.add(tf2);
        this.add(tf3);
        this.add(tf4);
        this.add(tf5);
        this.add(tf6);
        this.add(tf7);
        this.add(tf8);
        this.add(tf9);

        this.setVisible(true);
        this.pack();

        /**
         * Se capturan los eventos de los botones de filtros
         */
        btnConvolucionar.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hacerConvolucion();
            }

        });

        btnRepujado.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                filtroRepujado();
                log.info("Filtro Repujado seleccionado");
            }

        });

        btndetectarBordes.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                filtroDetectarBordes();
                log.info("Filtro Detectar Bordes seleccionado");
            }
        });

        btnRealzarBordes.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                filtroRealzarBordes();
                log.info("Filtro Realzar Bordes seleccionado");
            }
        });

        btnDesenfoque.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                filtroDesenfoque();
                log.info("Filtro Desenfoque seleccionado");
            }
        });

        btnEnfoque.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                filtroSharpen();
                log.info("Filtro Sharpen seleccionado");
            }
        });
    }

    public Dimension getPreferredSize() {
        return new Dimension(400, 280);
    }

    /**
     * Método que pasa el Kernel al comando de la convolución para ser transformado
     */
    private void hacerConvolucion() {

        try {
            int convolucion[][] = {
                {Integer.parseInt(tf1.getText()), Integer.parseInt(tf2.getText()), Integer.parseInt(tf3.getText())},
                {Integer.parseInt(tf4.getText()), Integer.parseInt(tf5.getText()), Integer.parseInt(tf6.getText())},
                {Integer.parseInt(tf7.getText()), Integer.parseInt(tf8.getText()), Integer.parseInt(tf9.getText())},};

            imagen.hacerTransformacion(new ComandoConvolucionar(convolucion));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo se admiten números enteros");
        }
    }

    /**
    * Todos los filtros prellenados en los TextFields
    */
    private void filtroRepujado() {
        /*{0, 0, 0},
        {1, 2, 1},
        {0, 0, -2}*/
        tf1.setText("0");
        tf2.setText("0");
        tf3.setText("0");
        tf4.setText("1");
        tf5.setText("2");
        tf6.setText("1");
        tf7.setText("0");
        tf8.setText("0");
        tf9.setText("-2");
    }

    private void filtroDetectarBordes() {
        /*{1, 0, 0},
        {0, 2, 0}
        {0, 0, -2},*/
        tf1.setText("1");
        tf2.setText("0");
        tf3.setText("0");
        tf4.setText("0");
        tf5.setText("2");
        tf6.setText("0");
        tf7.setText("0");
        tf8.setText("0");
        tf9.setText("-2"); 
    }

    private void filtroRealzarBordes() {
        /*{0, 0, 0},
        {-1, 1, -1},
        {0, 0, 0}*/
        tf1.setText("0");
        tf2.setText("0");
        tf3.setText("0");
        tf4.setText("-1");
        tf5.setText("1");
        tf6.setText("-1");
        tf7.setText("0");
        tf8.setText("0");
        tf9.setText("0");  
    }

    private void filtroDesenfoque() {
        /*{1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}*/
        tf1.setText("1");
        tf2.setText("1");
        tf3.setText("1");
        tf4.setText("1");
        tf5.setText("1");
        tf6.setText("1");
        tf7.setText("1");
        tf8.setText("1");
        tf9.setText("1");  
    }

    private void filtroSharpen() {
        /*{-1, -2, -1},
        {-2, 15, -2},
        {-1, -2, -1}*/
        tf1.setText("-1");
        tf2.setText("-2");
        tf3.setText("-1");
        tf4.setText("-2");
        tf5.setText("15");
        tf6.setText("-2");
        tf7.setText("-1");
        tf8.setText("-2");
        tf9.setText("-1");  
    }

}
